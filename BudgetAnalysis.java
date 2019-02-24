import java.text.DecimalFormat; 
import java.util.Scanner; 
 

public class BudgetAnalysis { 
 
 public static void main(String[] args) { 
 
  // Create a DecimalFormat object to format output. 
  DecimalFormat dollar = new DecimalFormat("#,##0.00"); 
 
  // Create a Scanner object for keyboard input. 
  Scanner keyboard = new Scanner(System.in); 
  double totalIncome = 4000;//Test total Income	
  double totalBudget = 0;
  // Get the budget amount. 
  System.out.print("Enter your budget for Insurance: "); 
  double InsuranceBudget = keyboard.nextDouble();
  if (totalIncome - InsuranceBudget <0){
	  System.out.println("Warning! Your Budget is over your Income");
  }
  totalBudget += InsuranceBudget;
  System.out.print("Enter your budget for Rent: "); 
  double RentBudget = keyboard.nextDouble(); 
  if (totalIncome - RentBudget <0){
	  System.out.println("Warning! Your Budget is over your Income");
  }
  totalBudget += RentBudget;
  System.out.print("Enter your budget for Clothing: "); 
  double ClothingBudget = keyboard.nextDouble();
  if (totalIncome - ClothingBudget <0){
	  System.out.println("Warning! Your Budget is over your Income");
  }
  totalBudget += ClothingBudget;
  System.out.print("Enter your budget for Food: "); 
  double FoodBudget = keyboard.nextDouble();
  if (totalIncome - FoodBudget <0){
	  System.out.println("Warning! Your Budget is over your Income");
  }
  totalBudget += FoodBudget;
  System.out.print("Enter your budget for Bills: "); 
  double BillsBudget = keyboard.nextDouble();
  if (totalIncome - BillsBudget <0){
	  System.out.println("Warning! Your Budget is over your Income");
  }
  totalBudget += BillsBudget;
  System.out.print("Enter your budget for Entertainment: "); 
  double EntertainmentBudget = keyboard.nextDouble();
  if (totalIncome - EntertainmentBudget <0){
	  System.out.println("Warning! Your Budget is over your Income");
  }
  totalBudget += EntertainmentBudget;
  System.out.print("Enter your budget for Extras: "); 
  double ExtrasBudget = keyboard.nextDouble();
  if (totalIncome - ExtrasBudget <0){
	  System.out.println("Warning! Your Budget is over your Income");
  }
  totalBudget += ExtrasBudget;
  // Get each expense, keep track of total. 
  double expense;  
  double totalExpenses = 0.0; 
  do { 
    // Get an expense amount. 
   System.out.print("Enter an expense, or a negative " 
     + "number to quit: "); 
   expense = keyboard.nextDouble(); 
   if (expense > 0){
	totalExpenses += expense;
   }	
  } while (expense >= 0);
  
  // this parts needs to be connected with Expense class
  // Display the amount after expenses. 
  double balance = calculateAmountOverBudget(totalBudget, totalExpenses); 
  if (balance < 0) { 
   System.out.println("You are OVER total budget by $" 
     + dollar.format(Math.abs(balance))); 
  } else if (balance > 0) { 
   System.out.println("You are UNDER total budget by $" 
     + dollar.format(balance)); 
  } else { 
   System.out.println("You spent the budget amount exactly."); 
  } 
   
  keyboard.close(); 
 } 
 
 static double calculateAmountOverBudget(double totalBudgetBudget, 
   double totalExpenses) { 
  return totalBudgetBudget - totalExpenses; 
 } 
 
}