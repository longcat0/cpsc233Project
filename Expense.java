import java.util.*;

class Expense extends Budget {
  Budget someBudget;
  /**
   * Constructor for Expense class. The creation of an Expense object
   * will call the the default constructor of Budget class.
   * A object of Expense class will have all instance variables of Budget as a result.
   * Use the accessor methods from the Budget class in order to access the instance variables
   * of an Expense object.
   */
  public Expense () {

  }


  private static void makeLines() {
    System.out.println("----------------");
  }

  private static void printExpenses() {
    makeLines();
    System.out.println("1 - Rent");
    System.out.println("2 - Food");
    System.out.println("3 - Entertainment");
    System.out.println("4 - Bills");
    System.out.println("5 - Clothing");
    System.out.println("6 - Insurance");
    System.out.println("7 - Extras");
    makeLines();
  }


  /**
   * This method runs the entire expense program. Note: It is important that you create
   * an object of the Expense class before you run this program.
   */
  public void runExpense() {
    Scanner reader = new Scanner(System.in);
    int count = 0;
    String input;
    do {
      System.out.print("Would you like to input an expense? Please enter Y (Yes) or N (No): ");
      input = reader.nextLine();
      if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
        count = 1;
      } else {
        System.out.println("Invalid input. Please try again.");
      }

    } while (count == 0);

    // Sets the status to true if the input is yes. Otherwise, it will set status to false.
    Boolean status = (input.equalsIgnoreCase("Y")) ? true : false;

    Boolean status2 = false;

    while (status) {
      status2 = false;
      printExpenses();
      System.out.println("Total rent: " + this.getRent());
      System.out.println("Total food: " + this.getFood());
      System.out.println("Total entertainment: " + this.getEntertainment());
      System.out.println("Total bills: " + this.getBills());
      System.out.println("Total clothing: " + this.getClothing());
      System.out.println("Total insurance: " + this.getInsurance());
      System.out.println("Total extras: " + this.getExtras());
      makeLines();
      System.out.println();
      System.out.print("To which category would you like to input your expense to: ");
      String command = reader.nextLine();

      // Swtich statement will check if command matches any of the Expenses listed
      switch (command) {

        // Rent
        case "1":
          int count2 = 0;
          double amount = 0;

          do {
            try { // Will go through the following block of code to see if there is an excpetion (error). If there is, the code from the catch block will run.
              System.out.println();
              System.out.print("What is the amount? ");
              amount = Double.parseDouble(reader.nextLine());
              count2 = 1;
            } catch (Exception e) {
              System.out.println("Input is invalid. Please try again.");
            }

          } while (count2 == 0);
          this.setRent(amount);
          System.out.println();
          System.out.println("The total amount you've spent on rent: " + this.getRent());
          status2 = true;
          break;

       // Food
       case "2":
         int count3 = 0;
         double amount2 = 0;

         do {
           try {
             System.out.print("What is the amount? ");
             amount2 = Double.parseDouble(reader.nextLine());
             count3 = 1;
           } catch (Exception e) {
             System.out.println("Input is invalid. Please try again.");
           }


         } while (count3 == 0);
         this.setFood(amount2);
         System.out.println();
         System.out.println("The total amount you've spent on food: " + this.getFood());
         status2 = true;
         break;

      // Entertainment
      case "3":
        int count4 = 0;
        double amount3 = 0;

        do {
          try {
            System.out.print("What is the amount? ");
            amount3 = Double.parseDouble(reader.nextLine());
            count4 = 1;
          } catch (Exception e) {
            System.out.println("Input is invalid. Please try again.");
          }


        } while (count4 == 0);
        this.setEntertainment(amount3);
        System.out.println();
        System.out.println("The total amount you've spent on entertainment: " + this.getEntertainment());
        status2 = true;
        break;

      // Bills
      case "4":
        int count5 = 0;
        double amount4 = 0;

        do {
          try {
            System.out.print("What is the amount? ");
            amount4 = Double.parseDouble(reader.nextLine());
            count5 = 1;
          } catch (Exception e) {
            System.out.println("Input is invalid. Please try again.");
          }


        } while (count5 == 0);
        this.setBills(amount4);
        System.out.println();
        System.out.println("The total amount you've spent on bills: " + this.getBills());
        status2 = true;
        break;


    // Clothing
     case "5":
       int count6 = 0;
       double amount5 = 0;

       do {
         try {
           System.out.print("What is the amount? ");
           amount5 = Double.parseDouble(reader.nextLine());
           count6 = 1;
         } catch (Exception e) {
           System.out.println("Input is invalid. Please try again.");
         }


       } while (count6 == 0);
       this.setClothing(amount5);
       System.out.println();
       System.out.println("The total amount you've spent on clothing: " + this.getClothing());
       status2 = true;
       break;

     // Insurance
     case "6":
        int count7 = 0;
        double amount6 = 0;

        do {
          try {
            System.out.print("What is the amount? ");
            amount6 = Double.parseDouble(reader.nextLine());
            count7 = 1;
          } catch (Exception e) {
            System.out.println("Input is invalid. Please try again.");
          }


        } while (count7 == 0);
        this.setInsurance(amount6);
        System.out.println();
        System.out.println("The total amount you've spent on insurance: " + this.getInsurance());
        status2 = true;
        break;

    // Extras
    case "7":
        int count8 = 0;
        double amount7 = 0;

        do {
          try {
            System.out.print("What is the amount? ");
            amount7 = Double.parseDouble(reader.nextLine());
            count8 = 1;
          } catch (Exception e) {
            System.out.println("Input is invalid. Please try again.");
          }


        } while (count8 == 0);
        this.setExtras(amount7);
        System.out.println();
        System.out.println("The total amount you've spent on extras: " + this.getExtras());
        status2 = true;
        break;

    default:
       System.out.println("Command doesn't exist. Please try again.");


     }

  if (status2) {
    System.out.println();
    System.out.print("Would you like to add anymore? Enter Y (Yes) or N (No): ");
    String input2 = reader.nextLine();
    // Will set the value of status to false if input2 is no.
    status = (input2.equalsIgnoreCase("N")) ? false : true;

  }


 }
}
  public static void main(String[] args) {
    Expense one = new Expense();
    one.runExpense();

  }
}
