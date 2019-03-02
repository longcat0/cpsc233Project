import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    double incomeOne, incomeTwo, incomeThree, incomeFour;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to your virtual piggy banking app! ");
		System.out.println("Please enter the amount of income one: ");
		incomeOne = keyboard.nextDouble();
		System.out.println("Please enter the amount of income two: ");
		incomeTwo = keyboard.nextDouble();
		System.out.println("Please enter the amount of income Three: ");
		incomeThree = keyboard.nextDouble();
		System.out.println("Please enter the amount of income Four: ");
		incomeFour= keyboard.nextDouble();


    Income three = new Income(incomeOne, incomeTwo, incomeThree, incomeFour);
    three.incomeTaxCalculator();

    System.out.println(three.salaryFinal);
    
      double rent, insurance, clothing, food, bills, entertainment, extras;
		Scanner keyboard2 = new Scanner(System.in);
		System.out.println("Please enter the budget of rent: ");
		rent = keyboard2.nextDouble();
		System.out.println("Please enter the budget of insurance: ");
		insurance = keyboard2.nextDouble();
		System.out.println("Please enter the budget of clothing: ");
		clothing = keyboard2.nextDouble();
		System.out.println("Please enter the budget of food: ");
		food= keyboard2.nextDouble();
		System.out.println("Please enter the budget of bills: ");
		bills = keyboard2.nextDouble();
		System.out.println("Please enter the budget of entertainment: ");
		entertainment = keyboard2.nextDouble();
		System.out.println("Please enter the budget of extras: ");
		extras = keyboard2.nextDouble();


    BudgetCalculator four = new BudgetCalculator(rent, food, clothing, bills, insurance, entertainment, extras, three.salaryFinal);

    //System.out.println(four.getRentBudg());







    Budget1 two = new Budget1(0.0, four.getClothingBudg(), four.getBillsBudg(), four.getEntertainmentBudg(), four.getInsuranceBudg(), four.getFoodBudg(), four.getRentBudg()); // Create a budget object (This is essentially your budget)

    Expense one = new Expense(two); // Creating an expense object that takes in your budget as a parameter.

    //System.out.println("Rent Budget: " + one.someBudget.getRent()); // This is the value of the rent budget.
   // System.out.println("Clothing Budget:" + one.someBudget.getClothing()); // This is the value of thie clothing budget.


    one.runExpense();
  }

}
