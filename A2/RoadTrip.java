/*************************************************************************
 * Compilation: javac RoadTrip.java
 * Execution: java RoadTrip <gallons> <mpg> <isRaining> <hasMountainPass>
 * <numPassengers> <isWeekend>
 *
 * Estimates the maximum driving range of a car based on fuel, fuel efficiency,
 * and several trip conditions
 *
 * @author Matthew Specht
 *************************************************************************/
public class RoadTrip {

    /**
     * Parses command-line arguments, applies modifiers, and prints
     * the expected driving range in miles (rounded to one decimal place) <- may
     * need to be changed, depends if this has been taught at this point in CS111
     *
     * @param args six command-line arguments: gallons mpg isRaining hasMountainPass
     *             numPassengers isWeekend
     */
    public static void main(String[] args) {

        Double gallons = Double.parseDouble(args[0]);
        Double mpg = Double.parseDouble(args[1]);
        Boolean isRaning = Boolean.parseBoolean(args[2]);
        Boolean hasMountainPass = Boolean.parseBoolean(args[3]);
        int numPassengers = Integer.parseInt(args[4]);
        Boolean isWeekend = Boolean.parseBoolean(args[5]);

        if (isWeekend == true) {
            mpg = mpg * 0.7;
        }
        if (isRaning == true) {
            mpg = mpg * 0.85;
        }
        if (hasMountainPass == true) {
            mpg = mpg * 0.9;
        }
        if (numPassengers >= 3) {
            mpg = mpg * 1.05;
        }

        Double distance = gallons * mpg;

        System.out.printf("Expected range: %.1f miles", distance);

    }
}