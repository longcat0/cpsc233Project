// Code by Sharif Ehsani
public class BudgetCalculator
{
	private double incomeOne, incomeTwo,incomeThree, incomeFour;
	private double rentExp, foodExp, clothingExp, billsExp, insuranceExp, entertainmentExp,extrasExp;
	private double rentBudg, foodBudg, clothingBudg, billsBudg, insuranceBudg, entertainmentBudg;
	private double totalIncome = incomeOne + incomeTwo + incomeThree + incomeFour;
	
	// Constructor for income Class
	public BudgetCalculator(double incomeOne, double incomeTwo, double incomeThree, double incomeFour)
	{
		if ((incomeOne >= 0) && (incomeTwo >= 0) && (incomeThree >= 0) && (incomeFour >= 0))
		{
			this.incomeOne = incomeOne;
			this.incomeTwo = incomeTwo;
			this.incomeThree = incomeThree;
			this.incomeFour = incomeFour;
		}
		else 
		{
			System.out.println("Sorry! Can't enter a negative infcome ");
			this.incomeOne = this.incomeOne;
			this.incomeTwo = this.incomeTwo;
			this.incomeThree = this.incomeThree;
			this.incomeFour = this.incomeFour;
		}
	}
	/**
	 * constructor for expenseClass
	 * checks if the expenditure is more than funds allocated. if it exceeds, the variable is not changed and the
	 * user is warned
	 */
	public BudgetCalculator(double rent, double food, double clothing, double bills, double insurance, double entertainment)
	{
		if ((rent > rentBudg) && (food > foodBudg) && (clothing > clothingBudg) && (bills > billsBudg) && (insurance > insuranceBudg) && (entertainment > entertainmentBudg))
		{
			System.out.println("Invalid input! you can't exceed your budget.");
			this.rentExp = this.rentExp;
			this.foodExp = this.foodExp;
			this.clothingExp = this.clothingExp;
			this.billsExp = this.billsExp;
			this.insuranceExp = this.insuranceExp;
			this.entertainmentExp = this.entertainmentExp;
		}
		else
		{
			this.rentExp = rent;
			this.foodExp = food;
			this.clothingExp = clothing;
			this.billsExp = bills;
			this.insuranceExp = insurance;
			this.entertainmentExp = entertainment;
		}
	}
	
	/**
	 * constructor for budgetClass
	 * checks if the budget allocated is more than the totla money in the account and updates the toltal money
	 * everytime a fund is allocated to a variable. if it exceeds, it will not change the variable and warns
	 * the user.
	 * variable exrtras is addes just to distnguish between the budget and expense constructor
	 */
	public BudgetCalculator(double rentB, double foodB, double clothingB, double billsB, double insuranceB, double entertainmentB, double extras)
	{
		if ((rentB > (incomeOne + incomeTwo + incomeThree + incomeFour)) && (foodB > ((incomeOne + incomeTwo + incomeThree + incomeFour)-rentB)) && (clothingB > ((incomeOne + incomeTwo + incomeThree + incomeFour)-rentB + foodB )) &&
			(billsB> ((incomeOne + incomeTwo + incomeThree + incomeFour)-rentB + foodB + clothingB)) && (insuranceB > ((incomeOne + incomeTwo + incomeThree + incomeFour)-rentB + foodB + clothingB + billsB)) &&
			(entertainmentB > ((incomeOne + incomeTwo + incomeThree + incomeFour)-rentB + foodB + clothingB + billsB + insuranceB)))
		{
			System.out.println("Invalid input! you can't allocate more funds than your total money ");
			this.rentBudg = this.rentBudg;
			this.foodBudg = this.foodBudg;
			this.clothingBudg = this.clothingBudg;
			this.billsBudg = this.billsBudg;
			this.insuranceBudg = this.insuranceBudg;
			this.entertainmentBudg = this.entertainmentBudg;
			//this.extras = this.extras;
			
		}
		else
		{
			this.rentBudg = rentB;
			this.foodBudg = foodB;
			this.clothingBudg = clothingB;
			this.billsBudg = billsB;
			this.insuranceBudg = insuranceB;
			this.entertainmentBudg = entertainmentB;
		}
	}
	/**
	 * getters and setters
	 */
	public double getIncomeOne()
	{
		return incomeOne;
	}
	public void setIncomeOne(double incomeOne)
	{
		if (incomeOne <0)
		{
			System.out.println("Please enter a value greater than or equal to zero .");
			this.incomeOne = this.incomeOne;
		}
		else
		{
			this.incomeOne = incomeOne;
		}
		
	}
	public double getIncomeTwo()
	{
		return incomeTwo;
	}
	public void setIncomeTwo(double incomeTwo)
	{
		if (incomeTwo <0)
		{
			System.out.println("Please enter a value greater than or equal to zero .");
			this.incomeTwo = this.incomeTwo;
		}
		else
		{
			this.incomeTwo = incomeTwo;
		}
		this.incomeTwo = incomeTwo;
	}
	public double getIncomeThree() 
	{
		return incomeThree;
	}
	public void setIncomeThree(double incomeThree) 
	{
		if (incomeThree <0)
		{
			System.out.println("Please enter a value greater than or equal to zero .");
			this.incomeThree = this.incomeThree;
		}
		else
		{
			this.incomeThree = incomeThree;
		}
		
	}
	public double getIncomeFour() 
	{
		return incomeFour;
	}
	public void setIncomeFour(double incomeFour)
	{
		if (incomeFour <0)
		{
			System.out.println("Please enter a value greater than or equal to zero .");
			this.incomeFour = this.incomeFour;
		}
		else
		{
			this.incomeFour = incomeFour;
		}
		
	}
	public double getRentExp()
	{
		return rentExp;
	}
	public void setRentExp(double rentExp)
	{
		if (rentExp > rentBudg)
		{
			System.out.println("Sorry you can't spend more than your budget");
			System.out.println("Your budget for rent this month is: " + rentBudg);
			this.rentExp = this.rentExp;
		}
		else
		{
			this.rentExp = rentExp;
		}
		
	}
	public double getFoodExp()
	{
		return foodExp;
	}
	public void setFoodExp(double foodExp) 
	{
		if (foodExp > foodBudg)
		{
			System.out.println("Sorry you can't spend more than your budget");
			System.out.println("Your budget for food this month is: " + foodBudg);
			this.foodExp = this.foodExp;
		}
		else
		{
			this.foodExp = foodExp;
		}
		
	}
	public double getClothingExp()
	{
		return clothingExp;
	}
	public void setClothingExp(double clothingExp)
	{
		if (clothingExp > clothingBudg)
		{
			System.out.println("Sorry you can't spend more than your budget");
			System.out.println("Your budget for clothing this month is: " + clothingBudg);
			this.clothingExp = this.clothingExp;
		}
		else
		{
			this.clothingExp = clothingExp;
		}
		
	}
	public double getBillsExp()
	{
		return billsExp;
	}
	public void setBillsExp(double billsExp) 
	{
		if (billsExp > billsBudg)
		{
			System.out.println("Sorry you can't spend more than your budget");
			System.out.println("Your budget for bills this month is: " + billsBudg);
			this.clothingExp = this.clothingExp;
		}
		else
		{
			this.billsExp = billsExp;
		}
	}
	public double getInsuranceExp() 
	{
		return insuranceExp;
	}
	public void setInsuranceExp(double insuranceExp) 
	{
		if (insuranceExp > insuranceBudg)
		{
			System.out.println("Sorry you can't spend more than your budget");
			System.out.println("Your budget for insurance this month is: " + insuranceBudg);
			this.insuranceExp = this.insuranceExp;
		}
		else
		{
			this.insuranceExp = insuranceExp;
		}
		
	}
	public double getEntertainmentExp() 
	{
		return entertainmentExp;
	}
	public void setEntertainmentExp(double entertainmentExp)
	{
		if (entertainmentExp > entertainmentBudg)
		{
			System.out.println("Sorry you can't spend more than your budget");
			System.out.println("Your budget for entertainment this month is: " + entertainmentBudg);
			this.insuranceExp = this.insuranceExp;
		}
		else
		{
			this.entertainmentExp = entertainmentExp;
		}
		
	}
	public double getRentBudg() 
	{
		return rentBudg;
	}
	public void setRentBudg(double rentBudg)
	{
		if (rentBudg > totalIncome )
		{
			System.out.println("Sorry you can't allocate funds more than what you have ");
			System.out.println("You have " + totalIncome + " money left");
			this.rentBudg = this.rentBudg;
		}
		else 
		{
			this.rentBudg = rentBudg;
			this.totalIncome = this.totalIncome - rentBudg;
		}
		
	}
	public double getFoodBudg()
	{
		return foodBudg;
	}
	public void setFoodBudg(double foodBudg) 
	{
		if (foodBudg > totalIncome - rentBudg)
		{
			System.out.println("Sorry you can't allocate funds more than what you have ");
			System.out.println("You have " + totalIncome + " money left");
			this.foodBudg = this.foodBudg;
		}
		else 
		{
			this.foodBudg = foodBudg;
			this.totalIncome = this.totalIncome - foodBudg;
		}
		
	}
	public double getClothingBudg() 
	{
		return clothingBudg;
	}
	public void setClothingBudg(double clothingBudg)
	{
		if (clothingBudg > (totalIncome - (rentBudg + foodBudg)))
		{
			System.out.println("Sorry you can't allocate funds more than what you have ");
			System.out.println("You have " + totalIncome + " money left");
			this.clothingBudg = this.clothingBudg;
		}
		else 
		{
			this.clothingBudg = clothingBudg;
			this.totalIncome = this.totalIncome - clothingBudg;
		}
	}
	public double getBillsBudg() 
	{
		return billsBudg;
	}
	public void setBillsBudg(double billsBudg)
	{
		if (billsBudg > (totalIncome - (rentBudg + foodBudg + clothingBudg)))
		{
			System.out.println("Sorry you can't allocate funds more than what you have ");
			System.out.println("You have " + totalIncome + " money left");
			this.billsBudg = this.billsBudg;
		}
		else 
		{
			this.billsBudg = billsBudg;
			this.totalIncome = this.totalIncome - billsBudg;
		}
	}
	public double getInsuranceBudg()
	{
		return insuranceBudg;
	}
	public void setInsuranceBudg(double insuranceBudg)
	{
		if (insuranceBudg > (totalIncome - (rentBudg + foodBudg + clothingBudg + billsBudg)))
		{
			System.out.println("Sorry you can't allocate funds more than what you have ");
			System.out.println("You have " + totalIncome + " money left");
			this.insuranceBudg = this.insuranceBudg;
		}
		else 
		{
			this.insuranceBudg = insuranceBudg;
			this.totalIncome = this.totalIncome - insuranceBudg;
		}
		
	}
	public double getEntertainmentBudg()
	{
		return entertainmentBudg;
	}
	public void setEntertainmentBudg(double entertainmentBudg)
	{
		if (entertainmentBudg > (totalIncome - (rentBudg + foodBudg + clothingBudg + billsBudg + insuranceBudg)))
		{
			System.out.println("Sorry you can't allocate funds more than what you have ");
			System.out.println("You have " + totalIncome + " money left");
			this.entertainmentBudg= this.entertainmentBudg;
		}
		else 
		{
			this.entertainmentBudg = entertainmentBudg;
			this.totalIncome = this.totalIncome - entertainmentBudg;
		}
		
	}
	
}
