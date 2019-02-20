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


  public void setName(String someName) {
    this.name = someName;
  }

  public void addBalance(double amount) {
    if (amount >= 0) {
      this.balance += amount;

    } else {
      System.out.println("Removal amount is negative or it causes balance to be negative.");
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
    System.out.printf(("Expense Name: %s \nBalance: %f"), this.name, this.balance);
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



   public static void main(String[] args) {

     makeLines();
     System.out.println();
     System.out.println("Welcome! For a list of commands, please type \"Commands\" into the prompt. Note: Commands are case sensitive." );
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
           System.out.println();
          }
          break;


      case "AddToExpense":
          System.out.print("Which expense would you like to add to? ");
          String name2 = keyboard.nextLine();
          int y = 1;
          double amount2 = 0;
          int count = 0;

          do {
            if (all.containsKey(name2)) {
              do {
                try {
                  System.out.println();
                  System.out.println("How much do you want to add? ");
                  amount2 = Double.parseDouble(keyboard.nextLine());
                  y = 0;
                } catch (Exception e) {
                  System.out.println("Your input is invalid. Please try again.");
                }
              } while (y == 1);
              all.get(name2).addBalance(amount2);
              System.out.println("Added.");
              count = 1;
            } else {
              System.out.println("Does not exist. Please try again.");
            }

          } while (count == 0);
          break;

      case "RemoveFromExpense":
        ;

      default:
        System.out.println("Unknown command. Please try again.");
        }
      }

// This isn't part of the actual program. This is used to test to see if everyting works.
     Expenses object = new Expenses("hello", 1239.79);
     System.out.println(object.name);
     System.out.println(object.balance);
     System.out.println(object.numberOfAccounts);
     object.printInfo();



     try {
       object.removeAmount(1239.0);
       object.addBalance(12321);

     } catch (Exception e) {
       System.out.println(e);

     } finally {
      System.out.println("Testing...");
    }



     all.get("Hello").printInfo();




   }
}
