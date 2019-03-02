import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    HashMap<String, Accounts> userAccounts = new HashMap<String, Accounts>();

    String input = mainMenu();

  }

  public static String mainMenu() {
    Scanner reader = new Scanner(System.in);
    System.out.println("Welcome to the Virtual Banking application. Below is a list of available commands.");
    System.out.println();
    System.out.println("1 - Create an account");
    System.out.println("2 - Add to income");
    System.out.println("3 - Manage budgets");
    System.out.println("4 - View recent transactions");
    System.out.println("5 - Exit application");

    System.out.println();
    System.out.print("What would you like to do? ");
    String input = reader.nextLine();
    return input;
  }


}
