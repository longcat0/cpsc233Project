import java.util.*;
import java.io.Serializable;

class Accounts implements Serializable {
  private String name = "Untitled";
  private Income1 userIncome = new Income1();
  private Budgets Rent = new Budgets();
  private Budgets Entertainment = new Budgets();
  private Budgets Clothing  = new Budgets();
  private Budgets Bills = new Budgets();
  private Budgets Food = new Budgets();
  private Budgets Insurance = new Budgets();
  private Budgets Extras = new Budgets();
  private Budgets UnallocatedFunds = new Budgets();



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
  /**
   * Returns user Income
   * @return userIncome
   */
  public Income1 getIncome() {
    return userIncome;
  }

  /**
   * Returns user Name
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * When the user inputs an expense, this method will check if the budget has a sufficient amount of funds
   * @param  amount     Expense amount
   * @param  availFunds Budget amount
   * @return           false if expense exceeds budget, true otherwise
   */
  public boolean checkBudg(String name, double amount, double availFunds) {
    if ((amount < 0) || ((availFunds - amount) < 0)) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Takes in two amounts and compares if one is bigger than the other.
   * @param  someAmount A double value
   * @param  amount   A double value
   * @return          true if someAmount is greater than amount, false otherwise
   */
  public boolean checkExpense(double someAmount, double amount) {
    if ((someAmount - amount ) >= 0) {
      return true;
    }
    return false;
  }

  public Budgets returnAllBudgets(String Name) {
    String budgetName = Name;

    switch (budgetName) {
      case "Rent":
        return Rent;

      case "Entertainment":
        return Entertainment;

      case "Food":
        return Food;

      case "Clothing":
        return Clothing;

      case "Bills":
        return Bills;

      case "Insurance":
        return Insurance;

      default:
        break;
    }
    return Extras;
  }




}
