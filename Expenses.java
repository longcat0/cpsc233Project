import java.util.*;

class Expenses {

  private String name = "Untitled";
  private double balance = 0.0;
  private static int numberOfAccounts;

  public Expenses(String someName, double amount) {
    this.name = someName;
    this.balance = amount;
    numberOfAccounts++;
  }

  public Expenses(String someName) {
    this.name = someName;
    numberOfAccounts++;
  }

  public Expenses() {

  }

  public Expenses(Expenses object) {
    this.name = object.name;
    this.balance = object.balance;
  }

  public double getBalance() {
    return this.balance;
  }

  public String getName() {
    return this.name;
  }


  public void setName(String someName) {
    this.name = someName;
  }

  public void addBalance(double amount) {
    if (amount >= 0) {
      this.balance += amount;

    } else {
      System.out.println("Input is a negative number. Please try again.");
    }
  }

  public void removeAmount(double amount) {
    if ((amount >= 0) && (this.balance - amount >= 0)) {
      this.balance -= amount;
    } else {
      System.out.println("Removal amount is negative or it causes balance to be negative.");
    }
  }

  public static double calculateGST(double amount) {
    return Math.round(amount * 1.05 * 100) / 100.0;
  }

  public void printInfo() {
    makeLines();
    System.out.println();
    System.out.println("Expense Name: " + this.getName());
    System.out.println("Balance: " + this.getBalance());
    System.out.println();
  }

  public static void makeLines() {
    System.out.println("---------------");
  }

  public static void printCommands() {
    System.out.println("Quit - Closes the applicaton");
    System.out.println("CreateExpense - Creates a new spending category. User can give it a name (default name is \"Untitled\")");
    System.out.println("CalculateGST - Calculates the given amount with GST applied");
    System.out.println("AddToExpense - Adds a given amount to a spending category");
    System.out.println("RemoveFromExpense - Removes a given amount from a spending category (usually used for refunds)");
    System.out.println("ListExpenses - Lists out all the expenses that the user has created");
  }

  public static void runExpenseProgram() {
    makeLines();
    System.out.println();
    System.out.println("Welcome! This program will help you keep track of your everyday spending.\nFor a list of commands, please type \"Commands\" into the prompt. Note: Commands are case sensitive." );
    System.out.println();
    makeLines();

    HashMap<String, Expenses> all = new HashMap<String, Expenses>();

    Scanner keyboard = new Scanner(System.in);

    boolean status = true;

    while (status) {
      System.out.println();
      System.out.print("What would you like to do? ");
      String command = keyboard.nextLine();
      System.out.println();

      switch(command) {

        case "Commands":
         printCommands();
         break;


       case "Quit":
         System.out.println("See you soon. Have a nice day :)");
         status = false;
         break;


       case "CalculateGST":
         int x = 1;
         double amount = 0;

         do {
           try {
             System.out.println();
             System.out.print("What is the amount? ");
             amount = Double.parseDouble(keyboard.nextLine());
             x = 0;
           } catch (Exception e) {
             System.out.println("Your input is invalid. Please try again.");
           }
         } while (x == 1);

         System.out.println("Your total with GST is: " + calculateGST(amount));
         break;


      case "CreateExpense":
         System.out.print("Enter a name: ");
         String name = keyboard.nextLine();
         all.put(name, new Expenses(name));
         break;


     case "ListExpenses":
         System.out.print("Your current number of expenses: " + Expenses.numberOfAccounts + "\n");
         for (String key : all.keySet()) {
          all.get(key).printInfo();
         }
         break;


     case "AddToExpense":
         int y = 1;
         double amount2 = 0;
         int count = 0;

         do {
           System.out.println();
           System.out.print("Which expense would you like to add to? ");
           String name2 = keyboard.nextLine();
           if (all.containsKey(name2)) {

             do {
               try {
                 System.out.println();
                 System.out.print("How much do you want to add? ");
                 amount2 = Double.parseDouble(keyboard.nextLine());
                 y = 0;
               } catch (Exception e) {
                 System.out.println("Your input is invalid. Please try again.");
               }
             } while (y == 1);

             all.get(name2).addBalance(Math.round(amount2 * 100) / 100.0);
             if (amount2 >= 0) {
               System.out.println("Added.");
               count = 1;
             }

           } else {
             System.out.println();
             System.out.println("Does not exist. Please try again.");
           }

         } while (count == 0);
         break;

     case "RemoveFromExpense":
         int z = 1;
         double amount3 = 0;
         int count2 = 0;

         do {
           System.out.println();
           System.out.print("Which expense would you like to remove from? ");
           String name3 = keyboard.nextLine();
           if (all.containsKey(name3)) {

             do {
               try {
                 System.out.println();
                 System.out.print("How much do you want to remove? ");
                 amount3 = Double.parseDouble(keyboard.nextLine());
                 z = 0;
               } catch (Exception e) {
                 System.out.println("Your input is invalid. Please try again.");
               }
             } while (z == 1);

             if ((amount3 >= 0) && ((all.get(name3).getBalance() - amount3) >= 0)) {
               all.get(name3).removeAmount(Math.round(amount3 * 100) / 100.0);
               System.out.println("Removed.");
               count2 = 1;
             } else {
               System.out.println("Removal amount is negative or it causes balance to be negative. Please try again.");
             }

           } else {
             System.out.println();
             System.out.println("Does not exist. Please try again.");
           }

         } while (count2 == 0);
             break;

     default:
       System.out.println("Unknown command. Please try again.");
       }
     }

  }



   public static void main(String[] args) {

    runExpenseProgram();

   }
}
