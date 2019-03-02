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

	public static void createBudget(HashMap<String, Budgets> map, double totalIncome) {
		Scanner reader = new Scanner(System.in);
		double total = totalIncome;
		for (Map.Entry<String, Budgets> entry : map.entrySet()) {
			int temp = 0;
			int temp2 = 0;
			do {
				System.out.println();
				try {
					do {
						System.out.println("How much would you like to allocate towards " + entry.getKey() + "?");
						double amount = Double.parseDouble(reader.nextLine());
						if ((total - amount) >= 0) {
							entry.getValue().setBudgAmount(amount);
							total -= amount;
							temp2 = 1;
						} else {
							System.out.println("You do not have enough funds to allocate. You would need " + Math.abs(total - amount) + " more.");
						}

					} while (temp2 == 0);
					temp = 1;
				} catch (Exception e) {
					System.out.println();
	        System.out.println("Invalid input. Please try again.");
				}
			} while (temp == 0);
		}

	}


}
