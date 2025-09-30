public class SpeedingTicket 
{
    public static void main(String[] args) {

        int speed = Integer.parseInt(args[0]);
        int fine = 0;
        
        if (speed < 0) {
            System.out.println("Error, Invalid Input.");
            return;
        }
        if (speed < 60){
            fine = 0;
        } else if (60 < speed && speed <= 75) {
            fine = 100;
        } else if (75 < speed && speed <= 90) {
            fine = 200;
        } else {
            fine = 500;
        }

        System.out.printf("$%d", fine);
    }
}
