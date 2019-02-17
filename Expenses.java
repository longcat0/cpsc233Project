class Expenses {

  private String name;
  private double balance = 0.0;
  private static int numberOfAccounts;

  public Expenses(String someName, double amount) {
    setName(someName);
    setBalance(amount);
    numberOfAccounts++;
  }

  public Expenses(String someName) {
    setName(someName);
    numberOfAccounts++;
  }

  public void setName(String someName) {
    this.name = someName;
  }

  public void setBalance(double amount) {
    if (amount >= 0) {
      this.balance = amount;

    }
  }



   public static void main(String[] args) {

     Expenses object = new Expenses("Hello", -21312.32);
     System.out.println(object.name);
     System.out.println(object.balance);
     System.out.println(object.numberOfAccounts);


  }
}
