import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class Main extends Application {

    HashMap<String, Accounts> userAccounts = new HashMap<String, Accounts>();
    ArrayList<String> accountNames = new ArrayList<String>();
    Stage window;
    Scene scene1, scene2, scene3;
    ListView<String> listView;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Virtual Piggy Bank");
    window = primaryStage;

    GridPane layout1 = new GridPane();
    layout1.setPadding(new Insets(10,10,10,10));
    layout1.setVgap(8);
    layout1.setHgap(10);


    // Title at the top of the starting scene
    Label titleLabel = new Label("Virtual Piggy Bank Applicaton");
    titleLabel.setMinWidth(40);
    titleLabel.setMinHeight(40);
    GridPane.setConstraints(titleLabel, 2, 1);
    // Income label
    Label incomeLabel = new Label("Enter your income: ");
    GridPane.setConstraints(incomeLabel,2,25);
    TextField incomeInput = new TextField();
    incomeInput.setPromptText("income");
    GridPane.setConstraints(incomeInput, 3,25);

    // Name Label
    Label nameLabel = new Label("Name your account:");
    TextField nameInput = new TextField("Untitled");;
    GridPane.setConstraints(nameLabel, 2,20);
    GridPane.setConstraints(nameInput,3,20);


    // Budget allocation layout
    GridPane layout2 = new GridPane();
    layout2.setPadding(new Insets(10,10,10,10));
    layout2.setVgap(8);
    layout2.setHgap(10);

    Button button2 = new Button("Enter");
    GridPane.setConstraints(button2, 2, 35);

    Button button3 = new Button("Display budget amount");
    GridPane.setConstraints(button3, 2, 25);

    // Label that displays the amount that you can allocate towards your fund
    Label availIncome = new Label("Your current available funds: ");
    GridPane.setConstraints(availIncome, 2, 10);

    Label availBudg = new Label("Your current budget: ");
    GridPane.setConstraints(availBudg, 3, 25);

    Label budgetLabel = new Label("Enter an amount: ");
    TextField budgetInput = new TextField();
    GridPane.setConstraints(budgetLabel, 2, 30);
    GridPane.setConstraints(budgetInput, 3, 30);

    Label alert = new Label("Invalid amount");

    // Creating the list of budgets that you can select
    listView = new ListView<>();
    listView.getItems().addAll("Rent", "Food", "Bills", "Entertainment", "Clothing", "Insurance", "Extras");
    GridPane.setConstraints(listView, 3, 20);

    // Create account button
    Button button1 = new Button("Create Account");
    /*
    When the button is clicked, it will take the information in the text field and create an Account object.
    Once an Account object is created, it will be put inside of a HashMap which essentially stores all created accounts.
     */
    button1.setOnAction(e -> {
      userAccounts.put(nameInput.getText(), new Accounts(nameInput.getText(), Double.parseDouble(incomeInput.getText())));
      accountNames.add(nameInput.getText());
      double temp = Double.parseDouble(incomeInput.getText());
      availIncome.setText("Your current available funds: " + temp);
      window.setScene(scene2);


    });

    button2.setOnAction(a -> {
      String currentAccountName = accountNames.get(0);
      Accounts currentAccount = userAccounts.get(currentAccountName);
      System.out.print(currentAccount);
      double allocate = currentAccount.getIncome().getAmount();
      String selection = listView.getSelectionModel().getSelectedItem();
      double allocationAmount = Double.parseDouble(budgetInput.getText());
      System.out.println(allocate);
      System.out.println(allocationAmount);
      for (String key : currentAccount.getUserBudgets().keySet()) {
        System.out.println(key);
      }

      if (currentAccount.checkBudg(selection, allocationAmount, allocate)) {
        userAccounts.get(currentAccountName).getUserBudgets().get(selection).addToBudg(allocationAmount);
        allocate -= allocationAmount;
        currentAccount.getIncome().removeAmount(allocationAmount);
        availIncome.setText("Your current available funds: " + allocate);



        System.out.println(allocate);
        System.out.println(currentAccount.getIncome().getAmount());

        for (Budgets keee : currentAccount.getUserBudgets().values()) {
          System.out.println(keee.getBudgAmount());
        }


      } else {

      }

      button3.setOnAction(b -> {
          availBudg.setText("Your current budget2: " + currentAccount.getUserBudgets().get(selection).getBudgAmount());
      });

      System.out.println(listView.getSelectionModel().getSelectedItem());
    });

    GridPane.setConstraints(button1, 2, 30);
    layout1.getChildren().addAll(titleLabel, incomeLabel, incomeInput, nameLabel, nameInput, button1);

    layout2.getChildren().addAll(button2, budgetLabel, budgetInput, listView, availIncome, availBudg, button3);

    scene1 = new Scene(layout1, 700, 500);
    scene2 = new Scene(layout2, 700, 500);
    window.setScene(scene1);

    window.show();







  }
  /*
  public static Accounts createAccount() {
    Scanner reader = new Scanner(System.in);
    System.out.println();
    System.out.print("Please enter a name for your account: ");
    String name = reader.nextLine();
    Accounts userAccount = new Accounts(name);
    userAccount.createUserBudget();
    return userAccount;

  }
  */








}
