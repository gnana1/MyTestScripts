import java.util.Scanner;

public class Fibinocci {

    //Using  For Loop1

        public static void main(String[] args)
        {
            // Set it to the number of elements you want in the Fibonacci Series
            Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
            System.out.print("Enter Maximum number- ");
            int maxNumber= sc.nextInt();
            int startNumber = 0;
            int nextNumber = 1;

            System.out.print("Fibonacci Series of "+maxNumber+" numbers:");

            for (int i = 1; i <= maxNumber; ++i)
            {
                System.out.print(startNumber+" ");
                /* On each iteration, we are assigning second number
                 * to the first number and assigning the sum of last two
                 * numbers to the second number
                 */


                int sum = startNumber + nextNumber;
                startNumber = nextNumber;
                nextNumber = sum;
            }
        }
    }

