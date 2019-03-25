import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Expense {
  private String budgetName;
  private double amount;
  private String time;
  private String currentAccount; // The account that the expense relates to
  private Budgets b;
  

  public Expense(String budgetName, double amount, String currentAccount) {
	b = new Budgets(budgetName, amount);
    Date datto = new Date();
    this.budgetName = budgetName;
    setAmount(amount);
    this.time = datto.toString();
    this.currentAccount = currentAccount;
  }

  public String getBudgetName() {
    return budgetName;
  }
  public void setAmount(double amount)
  {
	  if (amount < 0)
	  {
		  this.amount = this.amount;
	  }
	  else if (amount > b.getBudgAmount())
	  {
		  this.amount = this.amount;
	  }
	  else 
	  {
		  this.amount = amount;
	  }
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
