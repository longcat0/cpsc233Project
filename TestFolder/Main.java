import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    HashMap<String, Accounts> userAccounts = new HashMap<String, Accounts>();
    Boolean status = true;

    while (status) {

      String input = mainMenu();

      switch(input) {
        case "1":
          Accounts temp = createAccount();
          userAccounts.put(temp.getName(), new Accounts(temp));;
          temp.printUserBudgets();
          break;
        case "2":
          userAccounts.get("Tom").userExpense.putIntoExpense("Soda", 2000); // Showing recent transactions
          break;

        case "3":
          for (String key : userAccounts.keySet()) {
            System.out.println("Account: " + key); // Show different accounts
          }
          if (userAccounts.size() > 0) {
            System.out.print("Which account would you like to do? ");
          }
          break;
        case "4":
          userAccounts.get("Tom").userExpense.putIntoExpense("Gaming", 3000); // Show recent transactions
          break;
        case "5":
          status = false;
          break;

        case "6":
          userAccounts.get("Jerrod").printUserBudgets(); // Show difference in budget between two accounts
          break;

        case "7":
          userAccounts.get("Tom").printUserBudgets(); // Same as case 6
          break;

        case "8":
          userAccounts.get("Tom").userExpense.printInfo(); // Show recent transactions
          break;
        case "9":
          userAccounts.get("Jerrod").addIncome(); // Showing how you can add an income to a budget
          userAccounts.get("Jerrod").printUserBudgets();
          break;
        case "10":
          System.out.println("Enter some amount:"); // Showing how expenses could work
          double amount = Double.parseDouble(reader.nextLine());
          System.out.println("Choose a budget");
          String budg = reader.nextLine();
          userAccounts.get("Tom").userBudgets.get(budg).removeFromBudg(amount);
          userAccounts.get("Tom").userExpense.putIntoExpense(budg, amount);
          userAccounts.get("Tom").printUserBudgets();
          break;

        case "11":
          System.out.println("Enter some amount:"); // Showing how budget transfer works
          double amount1 = Double.parseDouble(reader.nextLine());
          System.out.println("Choose a budget to transfer from");
          String budg1 = reader.nextLine();
          System.out.println("Choose a budget to transfer to");
          String budg2 = reader.nextLine();
          Budgets temp3 = userAccounts.get("Jerrod").userBudgets.get(budg2);
          userAccounts.get("Jerrod").userBudgets.get(budg1).transferToBudget(temp3, amount1);
          userAccounts.get("Jerrod").printUserBudgets();
          break;
        default:
          System.out.println("Unknown command. Please try again.");
      }
    }


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

  public static Accounts createAccount() {
    Scanner reader = new Scanner(System.in);
    System.out.println();
    System.out.print("Please enter a name for your account: ");
    String name = reader.nextLine();
    Accounts userAccount = new Accounts(name);
    userAccount.createUserBudget();
    return userAccount;

  }

  public void viewTransactions() {

  }







}
