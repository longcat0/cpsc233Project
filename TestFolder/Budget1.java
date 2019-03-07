class Budget1 {


	private double extras;
	private double insurance;
	private double bills;
	private double entertainment;
	private double rent;
	private double clothing;
	private double food;


	public Budget1(){
		extras = 0;
		insurance = 0;
		bills = 0;
		entertainment = 0;
		food = 0;
		clothing = 0;
		rent = 0;

	}

	public Budget1(double extras, double clothing, double bills, double entertainment, double insurance, double food, double rent){
		this.extras = extras;
		this.clothing = clothing;
		this.bills = bills;
		this.entertainment = entertainment;
		this.insurance = insurance;
		this.rent = rent;
		this.food = food;

	}

	public void setExtras(double extras){
		this.extras += extras;
	}
	public void setClothing(double clothing){
		this.clothing += clothing;
	}
	public void setBills(double bills){
		this.bills += bills;
	}
	public void setEntertainment(double entertainment){
		this.entertainment += entertainment;
	}
	public void setFood(double food){
		this.food += food;
	}
	public void setInsurance(double insurance){
		this.insurance += insurance;
	}
	public void setRent(double rent){
		this.rent += rent;
	}

	public double getExtras(){
		return extras;
	}
	public double getClothing(){
		return clothing;
	}
	public double getBills(){
		return bills;
	}
	public double getEntertainment(){
		return entertainment;
	}
	public double getFood(){
		return food;
	}
	public double getRent(){
		return rent;
	}
	public double getInsurance(){
		return insurance;
	}
}
