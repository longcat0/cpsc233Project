import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {

    HashMap<String, Accounts> userAccounts = new HashMap<String, Accounts>();
    ArrayList<String> accountNames = new ArrayList<String>();
    Stage window;
    Scene scene1, scene2, scene3, scene4;
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

    // Label that displays the amount that you can allocate towards your fund
    Text availIncome = new Text("Your current available funds: ");
    availIncome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
    GridPane.setConstraints(availIncome, 2, 10);

    VBox budgetTexts = new VBox();
    budgetTexts.setSpacing(10);
    Label rentBudg = new Label("Your current rent budget: " + 0.0);

    Label entertainmentBudg = new Label("Your current entertainment budget: " + 0.0);

    Label billsBudg = new Label("Your current bills budget: " + 0.0);

    Label clothingBudg = new Label("Your current clothing budget: " + 0.0);

    Label insuranceBudg = new Label("Your current insurance budget: " + 0.0);

    Label extrasBudg = new Label("Your current budget for extras: " + 0.0);

    Label foodBudg = new Label("Your current food budget: " + 0.0);

    budgetTexts.getChildren().addAll(rentBudg, entertainmentBudg, billsBudg, foodBudg, insuranceBudg, clothingBudg, extrasBudg);
    GridPane.setConstraints(budgetTexts, 2, 14);


    Label budgetLabel = new Label("Enter an amount: ");
    TextField budgetInput = new TextField();
    GridPane.setConstraints(budgetLabel, 1, 30);
    GridPane.setConstraints(budgetInput, 2, 30);

    Label alert = new Label("Invalid amount");

    // Creating the list of budgets that you can select
    listView = new ListView<>();
    listView.getItems().addAll("Rent", "Food", "Bills", "Entertainment", "Clothing", "Insurance", "Extras");
    GridPane.setConstraints(listView, 2, 20);

    // Create account button
    Button button1 = new Button("Create Account");
    GridPane.setConstraints(button1, 2, 30);
    /*
    When the button is clicked, it will take the information in the text field and create an Account object.
    Once an Account object is created, it will be put inside of a HashMap which essentially stores all created accounts.
     */
    button1.setOnAction(e -> {
      userAccounts.put(nameInput.getText(), new Accounts(nameInput.getText(), Double.parseDouble(incomeInput.getText())));
      accountNames.add(nameInput.getText());
      double temp = Double.parseDouble(incomeInput.getText());
      userAccounts.get(nameInput.getText()).getUnallocatedFunds().setBudgAmount(temp);
      window.setScene(scene3);


    });

/*
    button2.setOnAction(a -> {
      String currentAccountName = accountNames.get(0);
      Accounts currentAccount = userAccounts.get(currentAccountName);
      System.out.print(currentAccount);
      double allocate = currentAccount.getIncome().getAmount();
      String selection = listView.getSelectionModel().getSelectedItem();
      double allocationAmount = Double.parseDouble(budgetInput.getText());
      System.out.println(allocate);
      System.out.println(allocationAmount);

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
*/
    // This is the main menu of the application. Gives the user an option on what they want to do next.
    GridPane layout3 = new GridPane();
    layout3.setPadding(new Insets(10,10,10,10));
    layout3.setVgap(8);
    layout3.setHgap(10);

    Button manageBudgets = new Button("Manage Budgets");
    GridPane.setConstraints(manageBudgets, 5, 30);
    manageBudgets.setOnAction(i -> {
      window.setScene(scene4);
    });

    Button addIncome = new Button("Add Income");
    GridPane.setConstraints(addIncome, 6, 30);
    Button showExpense = new Button("Display transactions");
    GridPane.setConstraints(showExpense, 7, 30);
    Button createNewAccount = new Button("Create New User");
    GridPane.setConstraints(createNewAccount, 8, 30);

    Label menuText = new Label("Welcome to the Virtual Piggy Bank Applicaton!");
    GridPane.setConstraints(menuText, 5, 20);


    // This layout displays options on how a user can manage their budgets.
    GridPane layout4 = new GridPane();
    HBox horizontalButtons = new HBox();
    horizontalButtons.setSpacing(5);
    layout4.setPadding(new Insets(10,10,10,10));
    layout4.setVgap(8);
    layout4.setHgap(10);

    Button addToBudg = new Button("Allocate");
    addToBudg.setOnAction(o -> {
      window.setScene(scene2);
    });

    Button transfer = new Button("Transfer Budgets");

    horizontalButtons.getChildren().addAll(addToBudg, transfer);
    GridPane.setConstraints(horizontalButtons, 3, 20);

    Text options = new Text("Budget Options");
    options.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
    GridPane.setConstraints(options, 3, 15);





    layout1.getChildren().addAll(titleLabel, incomeLabel, incomeInput, nameLabel, nameInput, button1);

    layout2.getChildren().addAll(button2, budgetLabel, budgetInput, listView, availIncome, budgetTexts);

    layout3.getChildren().addAll(manageBudgets, addIncome, showExpense, menuText, createNewAccount);

    layout4.getChildren().addAll(options, horizontalButtons);

    scene1 = new Scene(layout1, 650, 700);
    scene2 = new Scene(layout2, 650, 700);
    scene3 = new Scene(layout3, 650, 700);
    scene4 = new Scene(layout4, 650, 700);
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
