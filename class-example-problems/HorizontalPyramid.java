public class HorizontalPyramid {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        // Double for loop, one for the asterisks and one for the lines
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }

        // Subtract 1 from n to make sure end of last loop is peak of pyramid
        n = n - 1;

        // Same as before, but reversed to decrement and start at n instead of 1
        for (int i = n; i >= 1; i--, n--) {
            for (int j = n; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
