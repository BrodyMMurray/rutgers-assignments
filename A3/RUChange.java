/**
 * Write the RUChange program inside the main method  according to the 
 * assignment description.
 * 
 * You should read the argument (number of cents due) as an int and then calculate 
 * the least number of coins needed to achieve that amount. Although your able to 
 * only use arithmetic operations to complete the assignment, you should use loops 
 * and conditionals as required by the assignment. You will also have to print out 
 * the number of quarters, dimes, nickles, and pennies needed to obtain that amount 
 * of change.
 * 
 * To compile:
 *        javac RUChange.java
 * To execute:
 *        java RUChange 76
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 * @param args args[0] is the amount in cents to make change for
 * @author Ved Patel
 * @author Anna Lu
 */


public class RUChange {
    public static void main( String [] args ){
        
        //variables for later use initialized
        int centInput = Integer.parseInt(args[0]);
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        //loops through coin values until all coins are sorted
        while (centInput > 0) {
            if (centInput >= 25) {
                quarters++;
                centInput = centInput - 25;
            } else if (centInput >= 10) {
                dimes++;
                centInput = centInput - 10;
            } else if (centInput >= 5) {
                nickels++;
                centInput = centInput - 5;
            } else {
                pennies++;
                centInput = centInput - 1;
            }
        }

        System.out.printf("Quarters: %d Dimes: %d Nickels: %d Pennies: %d\n",
         quarters, dimes, nickels, pennies);





    }
 }
