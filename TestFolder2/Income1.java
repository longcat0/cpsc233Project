import java.util.*;

class Income1 {

  private double amount = 0.0;

  public Income1() {

  }

  public double getAmount() {
    return this.amount;
  }

  public void setAmount(double amount) {
    this.amount = (amount > 0) ? (amount) : 0;
  }

  public void inputIncome() {
    Scanner reader = new Scanner(System.in);
    int temp = 0;
    do {
      System.out.println();
      System.out.print("What is your income? Please enter a positive number: ");
      try {
        double income = Double.parseDouble(reader.nextLine());
        setAmount(income);
        temp = 1;
      } catch (Exception e) {
        System.out.println();
        System.out.println("Invalid input. Please try again.");
      }
    } while (temp == 0);

  }
  /*
  public void getInt(TextField input, String message) {
    System.out.println("Hello there mate");
  }
  */
}
