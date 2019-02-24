import java.util.*;


public class Income{

	double salary;
	double extrasales;
	double salarytwo;
	double extrasalestwo;
	

	//constructors
	public Income(){
		salary = 1.1;
		extrasales = 2.2;
		salarytwo = 0.0;
		extrasalestwo = 0.5;
	}

public Income(double salary, double extrasales, double salarytwo, double extrasalestwo)
{
	if(salary>=0)
	{
		this.salary = salary;
	}
		this.extrasales = extrasales;
		this.salarytwo = salarytwo;
		this.extrasalestwo = extrasalestwo;
	}

	//getters
	public double getSalary(){
		if(salary>=0)
		{
			return salary;
		}
		return salary;
	}

	public double getSalarytwo(){
		if(salarytwo>=0)
		{
			return salarytwo;
		}
		return salarytwo;
	}
	
	public double getExtrasales(){
		return extrasales;
	}

	public double getExtrasalestwo(){
		return extrasalestwo;
	}

	//setter
		public void setIncome(double s, double ex, double stwo, double extwo){
		if(salary>=0)
		{
			this.salary = s;
		}
		this.extrasales = ex;
		this.salarytwo = stwo;
		this.extrasalestwo = extwo;
	}

	//main methods
	//this will calculate the salary without the income tax.
public void incomeTaxCalculator()
	{
		double adder = 1;
      double fullamount = this.salary + this.extrasales + this.salarytwo + this.extrasalestwo;
		if(fullamount <= (47630/12))
		{
			double FirstTax = (fullamount * (0.15));
			double SecondTax = 0;
			double ThirdTax =  0;
			double ForthTax =  0;
			double FifthTax =  0;
			System.out.println(fullamount);
			System.out.println(FirstTax);
			System.out.println(adder);
			adder = FirstTax;
			System.out.println(adder);
			
		
			System.out.println("this is first adder: " + adder);
		}
		
		else if(  ( fullamount > (47630/12) ) &&  ( fullamount <= (95259/12) )  )
		{
			double FirstTax = (47630/12) * (0.15);
			double SecondTax = ( fullamount - (47630/12) ) * (0.205);
			double ThirdTax = 0;
			double ForthTax = 0;
			double FifthTax = 0;
			adder = FirstTax + SecondTax;
			System.out.println("this is second adder: " + adder);
		}
		
		else if(  ( fullamount > (95259/12) ) &&  ( fullamount <= (147667/12) )  )
		{
			double FirstTax = (47630/12) * (0.15);
			double SecondTax = (47629/12) * (0.205);
			double ThirdTax = ( fullamount - (95259/12) ) * (0.26);
			double ForthTax = 0;
			double FifthTax = 0;
			adder = FirstTax + SecondTax + ThirdTax;
			System.out.println("this is third adder: " + adder);
		}
		
		else if(  ( fullamount > (147667/12) ) &&  ( fullamount <= (210371/12) )  )
		{
			double FirstTax = (47630/12) * (0.15);
			double SecondTax = (47629/12) * (0.205);
			double ThirdTax = (52408/12) * (0.26);
			double FourthTax = ( fullamount - (147667/12) ) * (0.29);
			double FifthTax = 0;
			adder = FirstTax + SecondTax + ThirdTax + FourthTax;
			System.out.println("this is 4th adder: " + adder);
		}
		
		else if(  ( fullamount > (210371/12) ) )
		{
			double FirstTax = (47630/12) * (0.15);
			double SecondTax = (47629/12) * (0.205);
			double ThirdTax = (52408/12) * (0.26);
			double ForthTax = (62704/12) * (0.29);
			double FifthTax = ( fullamount - (210371/12) ) * (0.33);
			adder = FirstTax + SecondTax + ThirdTax + ForthTax + FifthTax;
			System.out.println("this is 5th adder: " + adder);
		}	
		
		double salaryFinal = (fullamount - adder);
		System.out.println("Your salary after Income Tax is: " + salaryFinal + ".");
		
	}	




}
