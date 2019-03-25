import java.util.*;
import java.io.*;
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
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.util.Duration;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    HashMap<String, Accounts> userAccounts = new HashMap<String, Accounts>();
    ListView<String> accountNames;
    Stage window;
    Scene scene1, scene2, scene3, scene4, userSwitch, income, expense, transactions, transferScene;
    ListView<String> listView, budgets, incomeAccounts, transferBudget1, transferBudget2;
    String currentAccount;
    ObservableList<Expense> expenses = FXCollections.observableArrayList();
    TableView<Expense> expenseTable;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    String fileName = "accounts.bin";

    primaryStage.setTitle("Virtual Piggy Bank");
    window = primaryStage;

    window.setOnCloseRequest(e -> closeProgram());

    System.out.println("running...");
    GridPane layout1 = new GridPane();
    layout1.setPadding(new Insets(10,10,10,10));
    layout1.setVgap(8);
    layout1.setHgap(10);
    BackgroundImage myBI= new BackgroundImage(new Image("piggy.png",950,900,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
    layout1.setBackground(new Background(myBI));


    // Title at the top of the starting scene
    Label titleLabel = new Label("Virtual Piggy Bank Applicaton");
    titleLabel.setTextFill(Color.WHITE);
    titleLabel.setStyle("-fx-font: 24 arial;");
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
    BackgroundImage myBI2= new BackgroundImage(new Image("bw2.png",950,900,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
    layout2.setBackground(new Background(myBI2));

    Button button2 = new Button("Enter");
    button2.setStyle("-fx-background-color: MediumSeaGreen");
    GridPane.setConstraints(button2, 2, 35);


    Button backButton = new Button("Back");
    backButton.setStyle("-fx-background-color: Red");
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


    Label budgetLabel = new Label("Enter amount: ");
    budgetLabel.setPrefWidth(230);
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

    incomeAccounts = new ListView<>();
    GridPane.setConstraints(incomeAccounts, 4, 20);

    GridPane layout3 = new GridPane();
    layout3.setPadding(new Insets(20,20,20,20));
    layout3.setVgap(8);
    layout3.setHgap(10);
    BackgroundImage myBI3= new BackgroundImage(new Image("bw2.png",950,900,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
    layout3.setBackground(new Background(myBI3));

    Label userName = new Label("Current User: " );
    userName.setTextFill(Color.WHITE);
    //userName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
    GridPane.setConstraints(userName, 4, 25);

    Button manageBudgets = new Button("Manage Budgets");
    GridPane.setConstraints(manageBudgets, 4, 30);

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

    // This layout displays options on how a user can manage their budgets.
    GridPane layout4 = new GridPane();
    HBox horizontalButtons = new HBox();
    horizontalButtons.setSpacing(5);
    layout4.setPadding(new Insets(20,20,20,20));
    layout4.setVgap(8);
    layout4.setHgap(10);
    GridPane.setConstraints(horizontalButtons, 4, 35);
    BackgroundImage myBI4= new BackgroundImage(new Image("bw2.png",950,750,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
    layout4.setBackground(new Background(myBI4));

    Label rentBudg1 = new Label("Your current rent budget: " + 0.0);
    rentBudg1.setStyle("-fx-font: 20 arial;");
	rentBudg1.setTextFill(Color.WHITE);

    Label entertainmentBudg1 = new Label("Your current entertainment budget: " + 0.0);
    entertainmentBudg1.setStyle("-fx-font: 20 arial;");
	entertainmentBudg1.setTextFill(Color.WHITE);

    Label billsBudg1 = new Label("Your current bills budget: " + 0.0);
    billsBudg1.setStyle("-fx-font: 20 arial;");
	billsBudg1.setTextFill(Color.WHITE);

    Label clothingBudg1 = new Label("Your current clothing budget: " + 0.0);
    clothingBudg1.setStyle("-fx-font: 20 arial;");
	clothingBudg1.setTextFill(Color.WHITE);

    Label insuranceBudg1 = new Label("Your current insurance budget: " + 0.0);
    insuranceBudg1.setStyle("-fx-font: 20 arial;");
	insuranceBudg1.setTextFill(Color.WHITE);

    Label extrasBudg1 = new Label("Your current budget for extras: " + 0.0);
    extrasBudg1.setStyle("-fx-font: 20 arial;");
	extrasBudg1.setTextFill(Color.WHITE);

    Label foodBudg1 = new Label("Your current food budget: " + 0.0);
    foodBudg1.setStyle("-fx-font: 20 arial;");
	  foodBudg1.setTextFill(Color.WHITE);

    VBox budgetText = new VBox();
    budgetText.setSpacing(10);
    budgetText.getChildren().addAll(rentBudg1, entertainmentBudg1, billsBudg1, foodBudg1, insuranceBudg1, clothingBudg1, extrasBudg1);
    GridPane.setConstraints(budgetText, 4, 14);


    Button addToBudg = new Button("Allocate");
    addToBudg.setStyle("-fx-background-color: MediumSeaGreen");
    addToBudg.setOnAction(o -> {
      availIncome.setText("Your current available funds: " + userAccounts.get(currentAccount).getIncome().getAmount());

      //inputStream.close();
      //outputStream.close();

      rentBudg.setText("Your current rent budget: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
      rentBudg.setStyle("-fx-font: 18 arial;");
	    rentBudg.setTextFill(Color.WHITE);

      entertainmentBudg.setText("Your current entertainment budget: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
      entertainmentBudg.setStyle("-fx-font: 18 arial;");
	    entertainmentBudg.setTextFill(Color.WHITE);
	    entertainmentBudg.setPrefWidth(415);

      clothingBudg.setText("Your current clothing budget: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
      clothingBudg.setStyle("-fx-font: 18 arial;");
	    clothingBudg.setTextFill(Color.WHITE);

      billsBudg.setText("Your current bills budget: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
      billsBudg.setStyle("-fx-font: 18 arial;");
	    billsBudg.setTextFill(Color.WHITE);

      foodBudg.setText("Your current food budget: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
      foodBudg.setStyle("-fx-font: 18 arial;");
	    foodBudg.setTextFill(Color.WHITE);

      extrasBudg.setText("Your current budget for extras: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
      extrasBudg.setStyle("-fx-font: 18 arial;");
	    extrasBudg.setTextFill(Color.WHITE);

      insuranceBudg.setText("Your current insurance budget: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
      insuranceBudg.setStyle("-fx-font: 18 arial;");
	    insuranceBudg.setTextFill(Color.WHITE);

      window.setScene(scene2);
    });

    Button returnM = new Button("Return to Main Menu");
    returnM.setStyle("-fx-background-color: Red");
    GridPane.setConstraints(returnM, 4, 40);
    returnM.setOnAction(r -> {
      window.setScene(scene3);
    });

    Button transfer = new Button("Transfer Budgets");
    transfer.setStyle("-fx-background-color: MediumSeaGreen");

    Button addExpense = new Button("Add an Expense");
    addExpense.setStyle("-fx-background-color: MediumSeaGreen");


    horizontalButtons.getChildren().addAll(addToBudg, transfer, addExpense);



    Text options = new Text("Budget Options");
    options.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
    options.setUnderline(true);
    GridPane.setConstraints(options, 4, 30);


    /*
    Screen that allows the user to switch accounts.
     */

    GridPane switchLayout = new GridPane();
    switchLayout.setPadding(new Insets(20,20,20,20));
    switchLayout.setVgap(8);
    switchLayout.setHgap(10);
    BackgroundImage myBI5= new BackgroundImage(new Image("bw2.png",950,500,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
  	switchLayout.setBackground(new Background(myBI5));

    Text blank = new Text("--------------------------------");
    blank.setFill(Color.WHITESMOKE);
    GridPane.setConstraints(blank, 1, 25);

    accountNames = new ListView<>();
    GridPane.setConstraints(accountNames, 2, 20);

    HBox switchButtons = new HBox();
    switchButtons.setSpacing(20);
    GridPane.setConstraints(switchButtons, 2, 25);

    Button cancel = new Button("Cancel");
    cancel.setStyle("-fx-background-color: Red");
    cancel.setOnAction(ab -> {
      window.setScene(scene3);
    });
    Button switchAccounts = new Button("Switch");
    switchAccounts.setStyle("-fx-background-color: MediumSeaGreen");
    switchAccounts.setOnAction(ty -> {
      currentAccount = accountNames.getSelectionModel().getSelectedItem();
      userName.setText("Current User: " + currentAccount);
      //userName.setTextFill(Color.WHITE);

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
    menuText.setStyle("-fx-font: 20 arial;");
    menuText.setTextFill(Color.WHITE);
    GridPane.setConstraints(menuText, 4, 20);

    /*
    This screen prompts the user to add any additional income to their account
     */

     GridPane incomeLayout = new GridPane();
     incomeLayout.setPadding(new Insets(20,20,20,20));
     incomeLayout.setVgap(8);
     incomeLayout.setHgap(10);
	   BackgroundImage myBI6= new BackgroundImage(new Image("bw2.png",950,500,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
     incomeLayout.setBackground(new Background(myBI6));

     Text currentIncomeAmount = new Text("Current Income: ");
     currentIncomeAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
     GridPane.setConstraints(currentIncomeAmount, 4, 15);

     Text errorMessage = new Text("Invalid Input.");
     errorMessage.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
     errorMessage.setFill(Color.WHITESMOKE);
     GridPane.setConstraints(errorMessage, 5, 25);

     HBox incomeButtons = new HBox();
     incomeButtons.setSpacing(10);
     GridPane.setConstraints(incomeButtons, 4, 25);

     TextField incomeInput2 = new TextField();
     incomeInput2.setPromptText("Enter income");

     Button incomeAdd = new Button("Add Income");
     incomeAdd.setStyle("-fx-background-color: MediumSeaGreen");
     Button returnToMenu = new Button("Back");
     returnToMenu.setStyle("-fx-background-color: Red");

     returnToMenu.setOnAction(back -> window.setScene(scene3));

     incomeButtons.getChildren().addAll(incomeInput2, incomeAdd, returnToMenu);

    /*
    "Adding an Expense" layout
     */

     GridPane expenseLayout = new GridPane();
     expenseLayout.setPadding(new Insets(20,20,20,20));
     expenseLayout.setVgap(8);
     expenseLayout.setHgap(10);
     BackgroundImage myBI7= new BackgroundImage(new Image("bw2.png",950,500,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
     expenseLayout.setBackground(new Background(myBI7));

     VBox stuff = new VBox();
     GridPane.setConstraints(stuff, 2, 17);
     stuff.setSpacing(8);


     budgets = new ListView<>();
     budgets.getItems().addAll("Rent", "Food", "Bills", "Entertainment", "Clothing", "Insurance", "Extras");

     Text initial = new Text("Previous Budget Amount: ");
     initial.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
     Text Final = new Text("New Budget Amount: ");
     Final.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

     addExpense.setOnAction(ex -> {
       initial.setText("Previous Budget Amount: ");
       Final.setText("New Budget Amount: ");
       window.setScene(expense);
     });

     Button addingExpense = new Button("Add Expense");
     addingExpense.setStyle("-fx-background-color: MediumSeaGreen");
     GridPane.setConstraints(addingExpense, 1, 22);

     Button back = new Button("Back");
     back.setStyle("-fx-background-color: Red");
     GridPane.setConstraints(back, 1, 25);




     back.setOnAction(oc -> {
         rentBudg1.setText("Your current rent budget: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
         entertainmentBudg1.setText("Your current entertainment budget: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
         clothingBudg1.setText("Your current clothing budget: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
         billsBudg1.setText("Your current bills budget: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
         foodBudg1.setText("Your current food budget: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
         extrasBudg1.setText("Your current budget for extras: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
         insuranceBudg1.setText("Your current insurance budget: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
         window.setScene(scene4);

     });

     TextField expenseInput = new TextField();
     GridPane.setConstraints(expenseInput, 2, 22);

     stuff.getChildren().addAll(budgets, initial, Final);

     addingExpense.setOnAction(hi -> {
       double expenseAmount = Double.parseDouble(expenseInput.getText());
       String budgetSelection = budgets.getSelectionModel().getSelectedItem();

       if (budgetSelection.equals("Rent")) {
         double rentAmount = userAccounts.get(currentAccount).getRent().getBudgAmount();
         if (userAccounts.get(currentAccount).checkExpense(rentAmount, expenseAmount)) {
           initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
           userAccounts.get(currentAccount).getRent().removeFromBudg(expenseAmount);
           Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
           expenses.add(new Expense("Rent", expenseAmount, currentAccount));
         } else {
           if (Confirmation.display("Alert")) {
             if ((expenseAmount - rentAmount) <= userAccounts.get(currentAccount).getIncome().getAmount()) {
               initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
               userAccounts.get(currentAccount).getIncome().removeAmount(expenseAmount - rentAmount);
               userAccounts.get(currentAccount).getRent().setBudgAmount(0);
               expenses.add(new Expense("Rent", expenseAmount, currentAccount));
               Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
             }
           }
         }
       } else if (budgetSelection.equals("Food")) {
         double expenseAmount2 = Double.parseDouble(expenseInput.getText());
         double foodAmount = userAccounts.get(currentAccount).getFood().getBudgAmount();
         if (userAccounts.get(currentAccount).checkExpense(foodAmount, expenseAmount2)) {
           initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
           userAccounts.get(currentAccount).getFood().removeFromBudg(expenseAmount2);
           Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
           expenses.add(new Expense("Food", expenseAmount2, currentAccount));
         } else {
           if (Confirmation.display("Alert")) {
             if ((expenseAmount2 - foodAmount) <= userAccounts.get(currentAccount).getIncome().getAmount()) {
               initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
               userAccounts.get(currentAccount).getIncome().removeAmount(expenseAmount2 - foodAmount);
               userAccounts.get(currentAccount).getFood().setBudgAmount(0);
               expenses.add(new Expense("Food", expenseAmount2, currentAccount));
               Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
             }
           };
         }

       } else if (budgetSelection.equals("Bills")) {
         double expenseAmount3 = Double.parseDouble(expenseInput.getText());
         double billsAmount = userAccounts.get(currentAccount).getBills().getBudgAmount();
         if (userAccounts.get(currentAccount).checkExpense(billsAmount, expenseAmount3)) {
           initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
           userAccounts.get(currentAccount).getBills().removeFromBudg(expenseAmount3);
           Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
           expenses.add(new Expense("Bills", expenseAmount3, currentAccount));
         } else {
           if (Confirmation.display("Alert")) {
             if ((expenseAmount3 - billsAmount) <= userAccounts.get(currentAccount).getIncome().getAmount()) {
               initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
               userAccounts.get(currentAccount).getIncome().removeAmount(expenseAmount3 - billsAmount);
               userAccounts.get(currentAccount).getBills().setBudgAmount(0);
               expenses.add(new Expense("Bills", expenseAmount3, currentAccount));
               Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
             }
           }
         }

       } else if (budgetSelection.equals("Entertainment")) {
         double expenseAmount4 = Double.parseDouble(expenseInput.getText());
         double entertainmentAmount = userAccounts.get(currentAccount).getEntertainment().getBudgAmount();
         if (userAccounts.get(currentAccount).checkExpense(entertainmentAmount, expenseAmount4)) {
           initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
           userAccounts.get(currentAccount).getEntertainment().removeFromBudg(expenseAmount4);
           Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
           expenses.add(new Expense("Entertainment", expenseAmount4, currentAccount));
         } else {
           if (Confirmation.display("Alert")) {
             if ((expenseAmount4 - entertainmentAmount) <= userAccounts.get(currentAccount).getIncome().getAmount()) {
               initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
               userAccounts.get(currentAccount).getIncome().removeAmount(expenseAmount4 - entertainmentAmount);
               userAccounts.get(currentAccount).getEntertainment().setBudgAmount(0);
               expenses.add(new Expense("Entertainment", expenseAmount4, currentAccount));
               Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
             }
           }
         }

       } else if (budgetSelection.equals("Clothing")) {
         double expenseAmount5 = Double.parseDouble(expenseInput.getText());
         double clothingAmount = userAccounts.get(currentAccount).getClothing().getBudgAmount();
         if (userAccounts.get(currentAccount).checkExpense(clothingAmount, expenseAmount5)) {
           initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
           userAccounts.get(currentAccount).getClothing().removeFromBudg(expenseAmount5);
           Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
           expenses.add(new Expense("Clothing", expenseAmount5, currentAccount));
         } else {
           if (Confirmation.display("Alert")) {
             if ((expenseAmount5 - clothingAmount) <= userAccounts.get(currentAccount).getIncome().getAmount()) {
               initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
               userAccounts.get(currentAccount).getIncome().removeAmount(expenseAmount5 - clothingAmount);
               userAccounts.get(currentAccount).getClothing().setBudgAmount(0);
               expenses.add(new Expense("Clothing", expenseAmount5, currentAccount));
               Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
             }
           }
         }
       } else if (budgetSelection.equals("Insurance")) {
         double expenseAmount6 = Double.parseDouble(expenseInput.getText());
         double insuranceAmount = userAccounts.get(currentAccount).getInsurance().getBudgAmount();
         if (userAccounts.get(currentAccount).checkExpense(insuranceAmount, expenseAmount6)) {
           initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
           userAccounts.get(currentAccount).getInsurance().removeFromBudg(expenseAmount6);
           Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
           expenses.add(new Expense("Insurance", expenseAmount6, currentAccount));
         } else {
           if (Confirmation.display("Alert")) {
             if ((expenseAmount6 - insuranceAmount) <= userAccounts.get(currentAccount).getIncome().getAmount()) {
               initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
               userAccounts.get(currentAccount).getIncome().removeAmount(expenseAmount6 - insuranceAmount);
               userAccounts.get(currentAccount).getInsurance().setBudgAmount(0);
               expenses.add(new Expense("Insurance", expenseAmount6, currentAccount));
               Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
             }
           }
         }
       } else if (budgetSelection.equals("Extras")) {
         double expenseAmount7 = Double.parseDouble(expenseInput.getText());
         double extrasAmount = userAccounts.get(currentAccount).getExtras().getBudgAmount();
         if (userAccounts.get(currentAccount).checkExpense(extrasAmount, expenseAmount7)) {
           initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
           userAccounts.get(currentAccount).getExtras().removeFromBudg(expenseAmount7);
           Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
           expenses.add(new Expense("Extras", expenseAmount7, currentAccount));
         } else {
           if (Confirmation.display("Alert")) {
             if ((expenseAmount7 - extrasAmount) <= userAccounts.get(currentAccount).getIncome().getAmount()) {
               initial.setText("Previous Budget Amount: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
               userAccounts.get(currentAccount).getIncome().removeAmount(expenseAmount7 - extrasAmount);
               userAccounts.get(currentAccount).getExtras().setBudgAmount(0);
               expenses.add(new Expense("Extras", expenseAmount7, currentAccount));
               Final.setText("New Budget Amount: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
             }
           }
         }
       }

    });

    /*
    Recent Transactions layout
     */

    // BudgetName column
    TableColumn nameColumn = new TableColumn("Budget");
    nameColumn.setMinWidth(100);
    nameColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("budgetName"));

    // Amount column
    TableColumn amountColumn = new TableColumn("Amount");
    amountColumn.setMinWidth(100);
    amountColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("amount"));

    // BudgetName column
    TableColumn timeColumn = new TableColumn("Time");
    timeColumn.setMinWidth(200);
    timeColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("time"));

    // Account name column
    TableColumn accountColumn = new TableColumn("Account");
    accountColumn.setMinWidth(200);
    accountColumn.setCellValueFactory(new PropertyValueFactory<Expense, String>("currentAccount"));

    expenseTable = new TableView<>();
    expenseTable.getColumns().addAll(accountColumn, nameColumn, amountColumn, timeColumn);

    Button returnBack = new Button("Return to Main Menu");
    returnBack.setOnAction(bac -> {
      window.setScene(scene3);
    });

    VBox transactionLayout = new VBox();
    transactionLayout.setSpacing(10);
    transactionLayout.getChildren().addAll(expenseTable, returnBack);

    /*
    Budget Transfer layout
    */

    transferBudget1 = new ListView<>();
    GridPane.setConstraints(transferBudget1, 1, 25);
    transferBudget2 = new ListView<>();
    GridPane.setConstraints(transferBudget2, 2, 25);

    transferBudget1.getItems().addAll("Rent", "Food", "Bills", "Entertainment", "Clothing", "Insurance", "Extras");
    transferBudget2.getItems().addAll("Rent", "Food", "Bills", "Entertainment", "Clothing", "Insurance", "Extras");

    GridPane transferLayout = new GridPane();
    transferLayout.setPadding(new Insets(20,20,20,20));
    transferLayout.setVgap(8);
    transferLayout.setHgap(10);

    HBox transferButtons = new HBox();
    transferButtons.setSpacing(10);
    GridPane.setConstraints(transferButtons, 1, 30);

    TextField transferAmount = new TextField();

    Button transferButton = new Button("Transfer");
    transferButton.setStyle("-fx-background-color: MediumSeaGreen");

    Button goBack = new Button("<-");
    goBack.setStyle("-fx-background-color: Red");
    goBack.setOnAction(bac -> {
      rentBudg1.setText("Your current rent budget: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
      entertainmentBudg1.setText("Your current entertainment budget: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
      clothingBudg1.setText("Your current clothing budget: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
      billsBudg1.setText("Your current bills budget: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
      foodBudg1.setText("Your current food budget: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
      extrasBudg1.setText("Your current budget for extras: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
      insuranceBudg1.setText("Your current insurance budget: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
      window.setScene(scene4);
    });

    Label transferBudgAmount1 = new Label("Current Balance for Sender: ");
    transferBudgAmount1.setTextFill(Color.WHITE);
    transferBudgAmount1.setStyle("-fx-font: 17 arial;");

    transferBudgAmount1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 11));
    GridPane.setConstraints(transferBudgAmount1, 1, 20);

    Label transferBudgAmount2 = new Label("Current Balance for Recipient: ");
    transferBudgAmount2.setTextFill(Color.WHITE);
    transferBudgAmount2.setStyle("-fx-font: 17 arial;");
    transferBudgAmount2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 11));
    GridPane.setConstraints(transferBudgAmount2, 2, 20);

    transferButtons.getChildren().addAll(transferAmount, transferButton, goBack);


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
      incomeAccounts.getItems().add(nameInput.getText());
      userName.setText("Current User: " + currentAccount);
      //userName.setTextFill(Color.WHITE);


      window.setScene(scene3);
      for(String names : userAccounts.keySet()) {
        System.out.println(names);
      }


    });


    button2.setOnAction(a -> {
      String selection = listView.getSelectionModel().getSelectedItem();
      double allocationAmount = Double.parseDouble(budgetInput.getText());
      double currentBalance = userAccounts.get(currentAccount).getIncome().getAmount();

      if (userAccounts.get(currentAccount).checkBudg(selection, allocationAmount, currentBalance)) {

        error.setFill(Color.WHITESMOKE);
        window.setScene(scene2);

        if (selection.equals("Rent")) {
          userAccounts.get(currentAccount).getRent().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          rentBudg.setText("Your current rent budget: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
          rentBudg1.setText("Your current rent budget: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
        }

        if (selection.equals("Entertainment")) {
          userAccounts.get(currentAccount).getEntertainment().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          entertainmentBudg.setText("Your current entertainment budget: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
          entertainmentBudg1.setText("Your current entertainment budget: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
        }


        if (selection.equals("Clothing")) {
          userAccounts.get(currentAccount).getClothing().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          clothingBudg.setText("Your current clothing budget: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
          clothingBudg1.setText("Your current clothing budget: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
        }


        if (selection.equals("Bills")) {
          userAccounts.get(currentAccount).getBills().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          billsBudg.setText("Your current bills budget: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
          billsBudg1.setText("Your current bills budget: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
        }

        if (selection.equals("Food")) {
          userAccounts.get(currentAccount).getFood().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          foodBudg.setText("Your current food budget: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
          foodBudg1.setText("Your current food budget: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
        }

        if (selection.equals("Extras")) {
          userAccounts.get(currentAccount).getExtras().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          extrasBudg.setText("Your current budget for extras: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
          extrasBudg1.setText("Your current budget for extras: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
        }

        if (selection.equals("Insurance")) {
          userAccounts.get(currentAccount).getInsurance().addToBudg(allocationAmount);
          userAccounts.get(currentAccount).getIncome().removeAmount(allocationAmount);
          insuranceBudg.setText("Your current insurance budget: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
          insuranceBudg1.setText("Your current insurance budget: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());

        }
        availIncome.setText("Your current available funds: " + Math.round(userAccounts.get(currentAccount).getIncome().getAmount() * 100) / 100.0);



      } else {

        error.setFill(Color.RED);
        window.setScene(scene2);
      }

    });

    showExpense.setOnAction(ex -> {
      System.out.println(expenses);
      expenseTable.setItems(expenses);
      window.setScene(transactions);
    });

    /*
    Will open each text file and display whats in it upon clicking the "Continue" button.
    Keep in mind that for some reason it saves the label name and number with the label's value in the text file,
    so we are splitting it to get only the part that we want.
    */
    Button continueNewButton = new Button("Continue");
    layout1.add(continueNewButton, 4, 30);
    continueNewButton.setOnAction(new EventHandler<ActionEvent>() //Proceed to continue to the next part.
        {
          public void handle(ActionEvent event) //In this part we are just setting up everything. All the values are still initialized to 0, and its literally just a starting point.
          {

            boolean cont = true;

            try {
              ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
              while (cont) {
                Accounts anAccount = (Accounts) is.readObject();
                if (anAccount != null) {
                  userAccounts.put(anAccount.getName(), anAccount);
                  System.out.println("User " + anAccount.getName());
                } else {
                  cont = false;
                }
              }

              is.close();
            } catch(Exception f) {
              System.out.println(f);
            }

            for (String key : userAccounts.keySet()) {
              accountNames.getItems().add(key);
              incomeAccounts.getItems().add(key);
              currentAccount = key;
              userName.setText("Current User: " + currentAccount);

            }

            layout1.getChildren().remove(continueNewButton);

            window.setScene(scene3);

          }});

    manageBudgets.setOnAction(i -> {

      rentBudg1.setText("Your current rent budget: " + userAccounts.get(currentAccount).getRent().getBudgAmount());
      entertainmentBudg1.setText("Your current entertainment budget: " + userAccounts.get(currentAccount).getEntertainment().getBudgAmount());
      clothingBudg1.setText("Your current clothing budget: " + userAccounts.get(currentAccount).getClothing().getBudgAmount());
      billsBudg1.setText("Your current bills budget: " + userAccounts.get(currentAccount).getBills().getBudgAmount());
      foodBudg1.setText("Your current food budget: " + userAccounts.get(currentAccount).getFood().getBudgAmount());
      extrasBudg1.setText("Your current budget for extras: " + userAccounts.get(currentAccount).getExtras().getBudgAmount());
      insuranceBudg1.setText("Your current insurance budget: " + userAccounts.get(currentAccount).getInsurance().getBudgAmount());
      window.setScene(scene4);
    });

    addIncome.setOnAction(op -> {
     currentIncomeAmount.setText("Current Income for " + currentAccount + ": " + userAccounts.get(currentAccount).getIncome().getAmount());
     window.setScene(income);
    });

    incomeAdd.setOnAction(add -> {
      try {
        Double incomeAmount = Double.parseDouble(incomeInput2.getText());
        userAccounts.get(incomeAccounts.getSelectionModel().getSelectedItem()).getIncome().addAmount(incomeAmount);
        currentIncomeAmount.setText("Current Income for " + incomeAccounts.getSelectionModel().getSelectedItem() + ": " +  userAccounts.get(incomeAccounts.getSelectionModel().getSelectedItem()).getIncome().getAmount());
        errorMessage.setFill(Color.WHITESMOKE);
      } catch(Exception e) {
        errorMessage.setFill(Color.RED);
      }
    });

    transfer.setOnAction(transferAction -> {
      transferBudgAmount1.setText("Current Balance for Sender: ");
      transferBudgAmount2.setText("Current Balance for Recipient: ");

      window.setScene(transferScene);
    });

    transferButton.setOnAction(trans ->{
      String recipient = transferBudget2.getSelectionModel().getSelectedItem();
      String sender = transferBudget1.getSelectionModel().getSelectedItem();
      double transferTotal = Double.parseDouble(transferAmount.getText());
      System.out.println(userAccounts.get(currentAccount).returnAllBudgets(sender).getBudgAmount());
        System.out.println(userAccounts.get(currentAccount).returnAllBudgets(recipient).getBudgAmount());


      userAccounts.get(currentAccount).returnAllBudgets(sender).transferToBudget(userAccounts.get(currentAccount).returnAllBudgets(recipient), transferTotal);
      transferBudgAmount1.setText("Current Balance for Sender: " + userAccounts.get(currentAccount).returnAllBudgets(sender).getBudgAmount());
      transferBudgAmount1.setTextFill(Color.WHITE);
      transferBudgAmount2.setText("Current Balance for Recipient: " + userAccounts.get(currentAccount).returnAllBudgets(recipient).getBudgAmount());
      transferBudgAmount2.setTextFill(Color.WHITE);

    });




    layout1.getChildren().addAll(titleLabel, incomeLabel, incomeInput, nameLabel, nameInput, button1);

    layout2.getChildren().addAll(button2, budgetLabel, budgetInput, listView, availIncome, budgetTexts, backButton, error);

    layout3.getChildren().addAll(menuText, menuButtons, user);

    layout4.getChildren().addAll(options, horizontalButtons, budgetText, returnM);

    switchLayout.getChildren().addAll(blank, switchButtons, accountNames);

    expenseLayout.getChildren().addAll(stuff, addingExpense, expenseInput, back);

    incomeLayout.getChildren().addAll(incomeAccounts, incomeButtons, currentIncomeAmount, errorMessage);

    transferLayout.getChildren().addAll(transferButtons, transferBudget1, transferBudget2, transferBudgAmount1, transferBudgAmount2);

    scene1 = new Scene(layout1, 650, 700);
    scene2 = new Scene(layout2, 650, 700);
    scene3 = new Scene(layout3, 650, 700);
    scene4 = new Scene(layout4, 650, 700);
    userSwitch = new Scene(switchLayout, 650, 700);
    income = new Scene(incomeLayout, 650, 700);
    expense = new Scene(expenseLayout, 650, 700);

    transactions = new Scene(transactionLayout, 650, 700);
    BackgroundImage myBI8= new BackgroundImage(new Image("transac.png",630,550,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
    transactionLayout.setBackground(new Background(myBI8));

    transferScene = new Scene(transferLayout, 650, 700);
    BackgroundImage myBI9= new BackgroundImage(new Image("bw2.png",630,550,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
    transferLayout.setBackground(new Background(myBI9));

    window.setScene(scene1);

    window.show();


  }

  public void closeProgram() {
    try {
      String fileName = "accounts.bin";
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
      for (String key : userAccounts.keySet()) {
        os.writeObject(userAccounts.get(key));
      }
      os.close();
    } catch (FileNotFoundException e) {

    } catch(IOException e) {

    }

    System.out.println("Saving accounts...");
  }

}
