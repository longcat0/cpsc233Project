import java.util.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Expense implements Serializable {
  private String currentAccount = "Untitled"; // The account that the expense relates to
  private String budgetName;
  private double amount;
  private String time;
  private Budgets b;

  private static final long serialVersionUID = -8050658235857325594L;


  public Expense(String budgetName, double amount, String account) {
	  b = new Budgets(budgetName, amount);
    Date datto = new Date();
    this.budgetName = budgetName + " (" + account + ")";
    setAmount(amount);
    this.time = datto.toString();
    this.currentAccount = account;
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
