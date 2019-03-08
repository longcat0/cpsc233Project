import java.util.*;

class Accounts {
  private String name = "Untitled";
  private Income1 userIncome = new Income1();
  private HashMap<String, Budgets> userBudgets = new HashMap<String, Budgets>();
  private Expense userExpense = new Expense();

  public Accounts(String name) {
    this.name = name;
    userIncome.inputIncome();

  }

  public Accounts() {
    userIncome.inputIncome();
  }

  public Accounts(String name, double Income) {
    this.name = name;
    userIncome.setAmount(Income);
    userBudgets.put("Rent", new Budgets("Rent"));
    userBudgets.put("Food", new Budgets("Food"));
    userBudgets.put("Extras", new Budgets("Extras"));
    userBudgets.put("Clothing", new Budgets("Clothing"));
    userBudgets.put("Insurance", new Budgets("Insurance"));
    userBudgets.put("Bills", new Budgets("Bills"));
    userBudgets.put("Entertainment", new Budgets("Entertainment"));

  }

  public Accounts (Accounts copy) {
    this.name = copy.name;
    this.userIncome = copy.userIncome;
    this.userBudgets = copy.userBudgets;
  }

  public HashMap<String, Budgets> getUserBudgets() {
    return userBudgets;
  }

  public Expense getUserExpenses() {
    return userExpense;
  }

  public Income1 getIncome() {
    return userIncome;
  }

  public String getName() {
    return this.name;
  }


  public boolean checkBudg(String name, double amount, double availFunds) {
    if ((amount < 0) || ((availFunds - amount) < 0)) {
      return false;
    } else {
      return true;
    }
  }




}
