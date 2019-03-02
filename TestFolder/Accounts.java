import java.util.*;

class Accounts {
  String name = "Untitled";
  Income1 userIncome = new Income1();
  HashMap<String, Budgets> userBudgets = new HashMap<String, Budgets>();

  public Accounts(String name) {
    this.name = name;
    userIncome.inputIncome();

  }

  public Accounts() {
    userIncome.inputIncome();
  }

  public void createUserBudget() {
    Scanner reader = new Scanner(System.in);
    double totalIncome = userIncome.getAmount();

    for (int x = 0; x < initialBudgetNames().size(); x++) {
      userBudgets.put(initialBudgetNames().get(x), new Budgets(initialBudgetNames().get(x)));
    }


    for (Map.Entry<String, Budgets> entry : userBudgets.entrySet()) {
      int temp = 0;
      int temp2 = 0;
      if (entry.getKey().equals("Unallocated Funds")) {
        continue;
      }
      do {
        System.out.println();
        try {
          do {
            System.out.println("You have " + totalIncome + " left.");
            System.out.print("How much would you like to allocate towards " + entry.getKey() + "? ");
            double amount = Double.parseDouble(reader.nextLine());
            if ((totalIncome - amount) >= 0) {
              entry.getValue().addToBudg(amount);
              totalIncome -= amount;
              temp2 = 1;
            } else {
              System.out.println("You do not have enough funds to allocate. You would need " + Math.abs(totalIncome - amount) + " more.");
            }

          } while (temp2 == 0);
          temp = 1;
        } catch (Exception e) {
          System.out.println();
          System.out.println("Invalid input. Please try again.");
        }
      } while (temp == 0);
    }

    userBudgets.get("Unallocated Funds").setBudgAmount(totalIncome);
  }

  private static ArrayList<String> initialBudgetNames() {
    ArrayList<String> temp = new ArrayList<String>();
    temp.add("Rent");
    temp.add("Food");
    temp.add("Entertainment");
    temp.add("Bills");
    temp.add("Insurance");
    temp.add("Extras");
    temp.add("Clothing");
    temp.add("Unallocated Funds");
    return temp;

  }

  public void printUserBudgets() {
    for (Map.Entry<String, Budgets> entry : userBudgets.entrySet()) {
      System.out.println();
      System.out.println(entry.getKey() + ": " + entry.getValue().getBudgAmount());

    }
  }


  public static void main(String[] args) {
    Accounts user1 = new Accounts("Jonathan");
    user1.createUserBudget();
    user1.printUserBudgets();

  }
}
