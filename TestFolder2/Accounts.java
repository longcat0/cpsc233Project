import java.util.*;

class Accounts {
  private String name = "Untitled";
  private Income1 userIncome = new Income1();
  private HashMap<String, Budgets> userBudgets = new HashMap<String, Budgets>();
  private Expense userExpense = new Expense();

  public Accounts(String name) {
    this.name = name;
    userIncome.inputIncome();

  }

  public Accounts() {
    userIncome.inputIncome();
  }

  public Accounts(String name, double Income) {
    this.name = name;
    userIncome.setAmount(Income);
  }

  public Accounts (Accounts copy) {
    this.name = copy.name;
    this.userIncome = copy.userIncome;
    this.userBudgets = copy.userBudgets;
  }

  public HashMap<String, Budgets> getUserBudgets() {
    return userBudgets;
  }

  public Expense getUserExpenses() {
    return userExpense;
  }

  public Income1 getIncome() {
    return userIncome;
  }

  public String getName() {
    return this.name;
  }

  public void createUserBudget(Double someAmount) {
    Scanner reader = new Scanner(System.in);
    double totalIncome = someAmount;

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
    System.out.println();
    System.out.println("Account name: " + this.name);
    System.out.println("-----------------------------");
    for (Map.Entry<String, Budgets> entry : userBudgets.entrySet()) {
      System.out.println();
      System.out.println(entry.getKey() + ": " + entry.getValue().getBudgAmount());

    }
  }

  public void manageBudgets() {
    Scanner reader = new Scanner(System.in);
    this.printUserBudgets();
    System.out.println("Which budget would you like to manage? ");
    String input = reader.nextLine();

    if (this.userBudgets.containsKey(input)) {
      Budgets.printBudgetCommands();
      System.out.println("What woud you like to do?");

    }


  }

  public void addIncome() {
    Scanner reader = new Scanner(System.in);
    userIncome.inputIncome();
    double totalIncome = userIncome.getAmount();
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

    userBudgets.get("Unallocated Funds").addToBudg(totalIncome);


  }




}
