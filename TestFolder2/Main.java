import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    HashMap<String, Accounts> userAccounts = new HashMap<String, Accounts>();
    
  }


  public static Accounts createAccount() {
    Scanner reader = new Scanner(System.in);
    System.out.println();
    System.out.print("Please enter a name for your account: ");
    String name = reader.nextLine();
    Accounts userAccount = new Accounts(name);
    userAccount.createUserBudget();
    return userAccount;

  }

  public void viewTransactions() {

  }







}
