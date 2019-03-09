import java.util.*;

class Budgets {

	private String name;
	private double amount = 0.0;

	public Budgets() {

	}

	public Budgets(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}

	public Budgets(String name) {
		this.name = name;
	}

	public double getBudgAmount() {
		return this.amount;
	}

	public String getBudgName() {
		return this.name;
	}

	public void setBudgAmount(double amount) {
		this.amount = (amount > 0) ? amount : 0;

	}

	public void addToBudg(double amount) {
		this.amount += (amount > 0) ? amount : 0;
	}

	public void removeFromBudg(double amount) {
		this.amount -= ((amount > 0) && ((this.amount - amount) > 0)) ? amount : 0;
	}


	public void transferToBudget(Budgets someBudget, double amount) {
		if ((amount > 0) && ((this.amount - amount) > 0)) {
			this.removeFromBudg(amount);
			someBudget.addToBudg(amount);
		} else {
			System.out.println("Invalid transfer.");
		}

	}


}
