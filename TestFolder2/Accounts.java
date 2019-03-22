import java.util.*;

class Accounts {
  private String name = "Untitled";
  private String password;
  private Income1 userIncome = new Income1();
  private Budgets Rent = new Budgets();
  private Budgets Entertainment = new Budgets();
  private Budgets Clothing  = new Budgets();
  private Budgets Bills = new Budgets();
  private Budgets Food = new Budgets();
  private Budgets Insurance = new Budgets();
  private Budgets Extras = new Budgets();
  private Budgets UnallocatedFunds = new Budgets();
  private Expense userExpense = new Expense();


  /**
   * Constructor for the Accounts class
   * @param name   Assigns it to the instance variable Name
   * @param Income Will take the parameter and set the account's income
   */
  public Accounts(String name, double Income) {
    this.name = name;
    userIncome.setAmount(Income);

  }

  /**
   * Returns the rent budget
   * @return Rent
   */
  public Budgets getRent() {
    return Rent;
  }

  /**
   * Returns the entertainment budget
   * @return Entertainment
   */
  public Budgets getEntertainment() {
    return Entertainment;
  }

  /**
   * Return the clothing budget
   * @return Clothing
   */
  public Budgets getClothing() {
    return Clothing;
  }

  /**
   * Return the bills budget
   * @return Bills
   */
  public Budgets getBills() {
    return Bills;
  }

  /**
   * Return the food budget
   * @return Food
   */
  public Budgets getFood() {
    return Food;
  }

  /**
   * Return the insurance budget
   * @return Insurance
   */
  public Budgets getInsurance() {
    return Insurance;
  }

  /**
   * Return extras budget
   * @return Extras
   */
  public Budgets getExtras() {
    return Extras;
  }

  /**
   * Return unallocated funds
   * @return UnallocatedFunds
   */
  public Budgets getUnallocatedFunds() {
    return UnallocatedFunds;
  }
/*
  public Accounts (Accounts copy) {
    this.name = copy.name;
    this.userIncome = copy.userIncome;
    this.userBudgets = copy.userBudgets;
  }
*/

  public Expense getUserExpenses() {
    return userExpense;
  }

  public Income1 getIncome() {
    return userIncome;
  }

  public String getName() {
    return this.name;
  }

  /**
   * [checkBudg description]
   * @param  name       [description]
   * @param  amount     [description]
   * @param  availFunds [description]
   * @return            [description]
   */
  public boolean checkBudg(String name, double amount, double availFunds) {
    if ((amount < 0) || ((availFunds - amount) < 0)) {
      return false;
    } else {
      return true;
    }
  }




}
