import requests
from bs4 import BeautifulSoup
import json

# The URL of the Rutgers CS course synopses page
URL = "https://www.cs.rutgers.edu/academics/undergraduate/course-synopses"

# Define headers to mimic a web browser
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36'
}

def scrape_rutgers_courses():
    """
    Scrapes the Rutgers CS course catalog, parses the data,
    and saves it to a JSON file.
    """
    print("Starting the scraping process...")
    
    try:
        # 1. Fetch the HTML content from the URL
        response = requests.get(URL, headers=headers)
        
        # Raise an error if the request was unsuccessful
        response.raise_for_status() 
        print("Successfully fetched the webpage.")

        # 2. Parse the HTML using BeautifulSoup
        soup = BeautifulSoup(response.content, 'html.parser')
        
        # 3. Find all the course blocks
        course_blocks = soup.find_all('div', class_='courseblock')
        print(f"Found {len(course_blocks)} course blocks.")
        
        all_courses = []

        # 4. Loop through each course block and extract the data
        for block in course_blocks:
            title_element = block.find('h4', class_='courseblocktitle')
            desc_element = block.find('div', class_='courseblockdesc')

            if title_element and desc_element:
                full_title_text = title_element.get_text(strip=True)
                
                parts = full_title_text.split(' ', 1)
                if len(parts) == 2:
                    course_id = parts[0].replace(':', '-')
                    course_title = parts[1]
                else:
                    course_id = "N/A"
                    course_title = full_title_text

                description = desc_element.get_text(strip=True, separator='\n')

                course_info = {
                    "id": course_id,
                    "title": course_title,
                    "description": description
                }
                all_courses.append(course_info)

        # 5. Save the final list of courses to a JSON file
        output_filename = 'courses.json'
        with open(output_filename, 'w') as f:
            json.dump(all_courses, f, indent=4)
            
        print(f"Successfully scraped {len(all_courses)} courses.")
        print(f"Data saved to {output_filename}")

    except requests.exceptions.RequestException as e:
        print(f"Error fetching the URL: {e}")
    except Exception as e:
        print(f"An error occurred: {e}")

# Run the scraper function when the script is executed
if __name__ == "__main__":
    scrape_rutgers_courses()