import java.util.Scanner;

public class MainException
{
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 1; i++)
        {
            int attempt = 0;

            while (attempt < 3) {

                System.out.println("You can only try 3 times");
                System.out.print("Enter Password: ");
                String password = input.nextLine();

                if (password == "password")
                {
                    try
                    {
                        throw new InvalidPassExcept("Password is correct!");
                    }

                    catch (InvalidPassExcept valid) {
                        System.out.println(valid);
                        System.out.print("Password is correct!");
                    }
                }

                else if (password != "password")
                {
                    try
                    {
                        throw new InvalidPassExcept("Password is incorrect.");
                    }

                    catch (InvalidPassExcept invalid)
                    {
                    System.out.println(invalid);
                    System.out.println();
                    }
                }

                attempt++;

            }
        }
    }
}
