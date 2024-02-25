import java.util.Scanner;

public class MainException {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter numerator: ");
            int numerator = input.nextInt();

            System.out.println("Enter denominator: ");
            int denominator = input.nextInt();

            try
            {

                if (denominator == 0)
                    throw new DivZeroExcept("Denominator zero is not allowed!");

                int result = numerator / denominator;
                System.out.println("Result is " + result);
                System.exit(0);
            }

            catch (DivZeroExcept e)
            {
                System.out.println("Exception caught: " + e);
                System.out.println("Enter new sets of numbers!");
                System.out.println();

            }

        }
    }
}
