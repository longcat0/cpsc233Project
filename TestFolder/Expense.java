import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Expense {
  ArrayList<String> transactions = new ArrayList<String>();

  public Expense() {

  }

  private static String makeLines(){
    String lines = ("-------------");
    return lines;
  }
  public void putIntoArray(String name, double amount) {
    Date date = new Date();
    String info = ( "\n" + makeLines() + "\nTime and Date: " + date.toString() + "\nBudget: " + name + "\n" + "Amount: " + amount);
    transactions.add(info);
  }
  public void printInfo() {
    for (int i = 0; i < transactions.size(); i++) {
      System.out.print(transactions.get(i));
    }
  }

}
