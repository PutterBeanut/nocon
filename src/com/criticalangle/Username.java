public class Username
{
    public static String promptUsername()
    {
        Scanner scanner = new Scanner(System.in);

        // Gets username from user.
        System.out.print("Username: ");
        String username = scanner.nextLine();

        return username;
    }
}