public class Hopscotch {
    /*************************************************************************
 *  Compilation:  javac Hopscotch.java
 *  Execution:    java Hopscotch size
 *
 *  @author Ram Buditi
 *
    *************************************************************************/
    
    /* Prints all rectangles on the hopscotch path with first 
       the center rectangles, then the left rectangles,
       and lastly the right rectangles as a sequence of
       integers.

       size: The size of the hopscotch path(the total number of rectangles)
     */
    public static void main(String[] args) {
      
        
        int hopsAmount = Integer.parseInt(args[0]);

        for (int i = 1; i <= hopsAmount; i++) {
            if (i % 3 == 1) {
                System.out.print(i + " ");
            }
        }
        for (int i = 1; i <= hopsAmount; i++) {
            if (i % 3 == 2) {
                System.out.print(i + " ");
            }
        }
        for (int i = 1; i <= hopsAmount; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }

    }

}