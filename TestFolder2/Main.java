import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
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
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

public class Main extends Application {

    HashMap<String, Accounts> userAccounts = new HashMap<String, Accounts>();
    ListView<String> accountNames;
    Stage window;
    Scene scene1, scene2, scene3, scene4, userSwitch, income;
    ListView<String> listView;
    String currentAccount;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    System.out.println("running...");

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

    Button backButton = new Button("Back");
    GridPane.setConstraints(backButton, 1, 35);
    backButton.setOnAction(l -> {
      window.setScene(scene4);
    });

    Text error = new Text("Input exceeds available funds.");
    error.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
    error.setFill(Color.WHITESMOKE);
    GridPane.setConstraints(error, 3, 35);

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

    // Creating the list of budgets that you can select
    listView = new ListView<>();
    listView.getItems().addAll("Rent", "Food", "Bills", "Entertainment", "Clothing", "Insurance", "Extras");
    GridPane.setConstraints(listView, 2, 20);

    // Create account button
    Button button1 = new Button("Create Account");
    GridPane.setConstraints(button1, 2, 30);



    /*
    This is the main menu of the application.
    It displays the all the available options to the user.
     */
    GridPane layout3 = new GridPane();
    layout3.setPadding(new Insets(20,20,20,20));
    layout3.setVgap(8);
    layout3.setHgap(10);

    Text userName = new Text("Current User: " );
    userName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
    GridPane.setConstraints(userName, 4, 25);

    Button manageBudgets = new Button("Manage Budgets");
    GridPane.setConstraints(manageBudgets, 4, 30);
    manageBudgets.setOnAction(i -> {
      window.setScene(scene4);
    });

    HBox menuButtons = new HBox();
    menuButtons.setSpacing(10);
    GridPane.setConstraints(menuButtons, 4, 30);

    Button addIncome = new Button("Add Income");
    addIncome.setOnAction(op -> {
      window.setScene(income);
    });

    Button showExpense = new Button("Display transactions");

    Button createNewAccount = new Button("Create New User");
    createNewAccount.setOnAction(q -> {
      window.setScene(scene1);
    });

    /*
    Screen that allows the user to switch accounts.
     */

    GridPane switchLayout = new GridPane();
    switchLayout.setPadding(new Insets(20,20,20,20));
    switchLayout.setVgap(8);
    switchLayout.setHgap(10);

    Text blank = new Text("--------------------------------");
    blank.setFill(Color.WHITESMOKE);
    GridPane.setConstraints(blank, 1, 25);

    accountNames = new ListView<>();
    GridPane.setConstraints(accountNames, 2, 20);

    HBox switchButtons = new HBox();
    switchButtons.setSpacing(20);
    GridPane.setConstraints(switchButtons, 2, 25);

    Button cancel = new Button("Cancel");
    cancel.setOnAction(ab -> {
      window.setScene(scene3);
    });
    Button switchAccounts = new Button("Switch");
    switchAccounts.setOnAction(ty -> {
      currentAccount = accountNames.getSelectionModel().getSelectedItem();
      userName.setText("Current User: " + currentAccount);

      rentBudg.setText("Your current rent budget: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
      entertainmentBudg.setText("Your current entertainment budget: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
      clothingBudg.setText("Your current clothing budget: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
      billsBudg.setText("Your current bills budget: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
      foodBudg.setText("Your current food budget: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
      extrasBudg.setText("Your current budget for extras: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
      insuranceBudg.setText("Your current insurance budget: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());

      window.setScene(scene3);
    });

    switchButtons.getChildren().addAll(cancel, switchAccounts);


    HBox user = new HBox();
    GridPane.setConstraints(user, 4, 25);
    user.setSpacing(15);

    Button switchButton = new Button("Switch User");
    switchButton.setOnAction(r -> {
      window.setScene(userSwitch);
    });

    user.getChildren().addAll(userName, switchButton);

    menuButtons.getChildren().addAll(addIncome, showExpense, manageBudgets, createNewAccount);

    Label menuText = new Label("Welcome to the Virtual Piggy Bank Applicaton!");
    GridPane.setConstraints(menuText, 4, 20);


    // This layout displays options on how a user can manage their budgets.
    GridPane layout4 = new GridPane();
    HBox horizontalButtons = new HBox();
    horizontalButtons.setSpacing(5);
    layout4.setPadding(new Insets(20,20,20,20));
    layout4.setVgap(8);
    layout4.setHgap(10);
    GridPane.setConstraints(horizontalButtons, 4, 35);

    Label rentBudg1 = new Label("Your current rent budget: " + 0.0);

    Label entertainmentBudg1 = new Label("Your current entertainment budget: " + 0.0);

    Label billsBudg1 = new Label("Your current bills budget: " + 0.0);

    Label clothingBudg1 = new Label("Your current clothing budget: " + 0.0);

    Label insuranceBudg1 = new Label("Your current insurance budget: " + 0.0);

    Label extrasBudg1 = new Label("Your current budget for extras: " + 0.0);

    Label foodBudg1 = new Label("Your current food budget: " + 0.0);

    VBox budgetText = new VBox();
    budgetText.setSpacing(10);
    budgetText.getChildren().addAll(rentBudg1, entertainmentBudg1, billsBudg1, foodBudg1, insuranceBudg1, clothingBudg1, extrasBudg1);
    GridPane.setConstraints(budgetText, 4, 14);

    Button addToBudg = new Button("Allocate");
    addToBudg.setOnAction(o -> {
      availIncome.setText("Your current available funds: " + userAccounts.get(currentAccount).getIncome().getAmount());
      window.setScene(scene2);
    });

    Button returnM = new Button("Return to Main Menu");
    GridPane.setConstraints(returnM, 4, 40);
    returnM.setOnAction(r -> {
      window.setScene(scene3);
    });

    Button transfer = new Button("Transfer Budgets");

    horizontalButtons.getChildren().addAll(addToBudg, transfer);


    Text options = new Text("Budget Options");
    options.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
    options.setUnderline(true);
    GridPane.setConstraints(options, 4, 30);

    /*
    This screen prompts the user to add any additional income to their account
     */

    GridPane incomeLayout = new GridPane();
    incomeLayout.setPadding(new Insets(20,20,20,20));
    incomeLayout.setVgap(8);
    incomeLayout.setHgap(10);

    incomeLayout.getChildren().addAll();



    /*
    When the button is clicked, it will take the information in the text field and create an Account object.
    Once an Account object is created, it will be put inside of a HashMap which essentially stores all created accounts.
     */
    button1.setOnAction(e -> {
      userAccounts.put(nameInput.getText(), new Accounts(nameInput.getText(), Double.parseDouble(incomeInput.getText())));
      accountNames.getItems().add(nameInput.getText());
      double temp = Double.parseDouble(incomeInput.getText());
      userAccounts.get(nameInput.getText()).getUnallocatedFunds().setBudgAmount(temp);
      currentAccount = nameInput.getText();
      userName.setText("Current User: " + currentAccount);
      window.setScene(scene3);
      for(String names : userAccounts.keySet()) {
        System.out.println(names);
      }


    });


    button2.setOnAction(a -> {
      System.out.print(currentAccount);
      String selection = listView.getSelectionModel().getSelectedItem();
      double allocationAmount = Double.parseDouble(budgetInput.getText());
      double currentBalance = userAccounts.get(currentAccount).getIncome().getAmount();
      System.out.println(selection);
      System.out.println(allocationAmount);

      if (userAccounts.get(currentAccount).checkBudg(selection, allocationAmount, currentBalance)) {

        error.setFill(Color.WHITESMOKE);
        window.setScene(scene2);

        if (selection.equals("Rent")) {
          userAccounts.get(currentAccount).getRent().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          rentBudg.setText("Your current rent budget: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
        }

        if (selection.equals("Entertainment")) {
          userAccounts.get(currentAccount).getEntertainment().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          entertainmentBudg.setText("Your current entertainment budget: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
        }

        if (selection.equals("Clothing")) {
          userAccounts.get(currentAccount).getClothing().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          clothingBudg.setText("Your current clothing budget: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
        }

        if (selection.equals("Bills")) {
          userAccounts.get(currentAccount).getBills().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          billsBudg.setText("Your current bills budget: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
        }

        if (selection.equals("Food")) {
          userAccounts.get(currentAccount).getFood().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          foodBudg.setText("Your current food budget: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
        }

        if (selection.equals("Extras")) {
          userAccounts.get(currentAccount).getExtras().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          extrasBudg.setText("Your current budget for extras: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
        }

        if (selection.equals("Insurance")) {
          userAccounts.get(currentAccount).getInsurance().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          insuranceBudg.setText("Your current insurance budget: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
        }


        availIncome.setText("Your current available funds: " + Math.round(userAccounts.get(currentAccount).getIncome().getAmount() * 100) / 100.0);


        System.out.println(currentBalance);


      } else {

        error.setFill(Color.RED);
        window.setScene(scene2);
      }

      System.out.println(listView.getSelectionModel().getSelectedItem());
      System.out.println(userAccounts.get(currentAccount).getRent().getBudgAmount());

    });




    layout1.getChildren().addAll(titleLabel, incomeLabel, incomeInput, nameLabel, nameInput, button1);

    layout2.getChildren().addAll(button2, budgetLabel, budgetInput, listView, availIncome, budgetTexts, backButton, error);

    layout3.getChildren().addAll(menuText, menuButtons, user);

    layout4.getChildren().addAll(options, horizontalButtons, budgetText, returnM);

    switchLayout.getChildren().addAll(blank, switchButtons, accountNames);

    scene1 = new Scene(layout1, 650, 700);
    scene2 = new Scene(layout2, 650, 700);
    scene3 = new Scene(layout3, 650, 700);
    scene4 = new Scene(layout4, 650, 700);
    userSwitch = new Scene(switchLayout, 650, 700);
    income = new Scene(incomeLayout, 650, 700);

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
