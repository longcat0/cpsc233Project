import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Expense {
  private String budgetName;
  private double amount;
  private String time;
  private String currentAccount; // The account that the expense relates to

  public Expense(String budgetName, double amount, String currentAccount) {
    Date datto = new Date();
    this.budgetName = budgetName;
    this.amount = amount;
    this.time = datto.toString();
    this.currentAccount = currentAccount;
  }

  public String getBudgetName() {
    return budgetName;
  }

  public double getAmount() {
    return amount;
  }

  public String getTime() {
    return time;
  }

  public String getAccountName() {
    return currentAccount;
  }

}
