import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.util.Duration;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import java.util.*;


/*
Please not before going through the code that the entire second half of the code is simply setting up the grid. 
The upper half is the part that sets the conditions and such.
  
*/

public class Main extends Application
{

  public static void main(String[] args)  //The main method that will run everything.
  {
    launch(args);
  } 

        

    public void start(Stage primaryStage) throws Exception
    {
    

        //setting up the GridPane. 
        GridPane gridPane = new GridPane(); //creating it.
        gridPane.setMinSize(900,300); //setting its size.
        gridPane.setPadding(new Insets(10,10,10,10)); //setting the padding.
        gridPane.setVgap(5);//Vertical gap between the coloumns of the grid.
        gridPane.setHgap(5);//Horizontal gap between the coloumns of the grid.
        gridPane.setAlignment(Pos.TOP_CENTER);// setting the position.




        Label welcomeLabel = new Label("Welcome to your virtual piggy banking app!");
        welcomeLabel.setPrefWidth(800);
        welcomeLabel.setStyle("-fx-font: 24 arial;");
        
        Label userName = new Label("Please enter your name, or a user name: ");
        userName.setPrefWidth(800);
        userName.setStyle("-fx-font: 18 arial;");

        TextField userNameTF = new TextField("Name");
        userNameTF.setPrefWidth(300);

        Label  incomeLabel = new Label("Pleas enter your income (make sure its a positive number!) : ");
        incomeLabel.setPrefWidth(800);
        incomeLabel.setStyle("-fx-font: 18 arial;");

        TextField incomeField = new TextField("0.00");
        incomeField.setPrefWidth(800);
        
        double incomeReader = Double.parseDouble(incomeField.getText());

        Button proceed = new Button("Proceed");

        proceed.setOnAction(new EventHandler<ActionEvent>() //Proceed to continue to the next part. 
        {
          public void handle(ActionEvent event) //In this part we are just setting up everything. All the values are still initialized to 0, and its literally just a starting point.
          {
              GridPane gridPane = new GridPane();
              gridPane.setMinSize(900,300);
              gridPane.setPadding(new Insets(10,10,10,10));
              gridPane.setVgap(5);
              gridPane.setHgap(5);
              gridPane.setAlignment(Pos.TOP_LEFT);
              double incomeReader = Double.parseDouble(incomeField.getText());
              String userNameStr = String.valueOf(userNameTF.getText());
              Label netIncome = new Label("Your income is: "+ incomeReader);
              netIncome.setStyle("-fx-font: 20 arial;");
              netIncome.setTextFill(Color.WHITE);
              Label accountName = new Label("Account User: "+ userNameStr);
              accountName.setStyle("-fx-font: 20 arial;");
              accountName.setTextFill(Color.WHITE);
              Label allTheBudgets = new Label("Rent Budget: 0.00 \nFood Budget: 0.00 \nEntertainment Budget: 0.00 \nBills Budget: 0.00 \nInsurance Budget: 0.00 \nClothing Budget: 0.00 \nExtras Budget: 0.00");
              allTheBudgets.setStyle("-fx-font: 18 arial;");
              Label unallocatedFunds = new Label("Unallocated Funds: "+ incomeReader);
              unallocatedFunds.setStyle("-fx-font: 18 arial;"); 
              Button add = new Button("+");
              add.setStyle("-fx-background-color: MediumSeaGreen");
              Button exit = new Button("Exit"); //Button exit will be always there. Whenever you press it it will exit.
              exit.setStyle("-fx-background-color: Red");
              Label addButton = new Label("You can add to your budget: ");
              unallocatedFunds.setStyle("-fx-font: 16 arial;"); 
              BackgroundImage myBI= new BackgroundImage(new Image("bw2.png",950,150,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
              gridPane.setBackground(new Background(myBI)); 

              exit.setOnAction(new EventHandler<ActionEvent>()
              {
                public void handle(ActionEvent event)
                {
                    GridPane gridPane = new GridPane();
                    gridPane.setMinSize(900,400);
                    gridPane.setPadding(new Insets(10,10,10,10));
                    gridPane.setVgap(5);
                    gridPane.setHgap(5);
                    gridPane.setAlignment(Pos.TOP_LEFT);


                    Scene scene = new Scene(gridPane);
                    primaryStage.setScene(scene);
                    primaryStage.close();
                }


              }
              );

                      add.setOnAction(new EventHandler<ActionEvent>() //In this part, the button will allow the user to Start the process of adding. Note that this isnt the button that will actually add them.
                      {
                          public void handle(ActionEvent event)
                          {
                                    GridPane gridPane = new GridPane(); 
                                    gridPane.setMinSize(900,400);
                                    gridPane.setPadding(new Insets(10,10,10,10));
                                    gridPane.setVgap(5);
                                    gridPane.setHgap(5);
                                    gridPane.setAlignment(Pos.TOP_LEFT);

                                    Label firstMessage = new Label("Please enter a budget for each of the following categories.");
                                    firstMessage.setStyle("-fx-font: 18 arial;");
                                    String userNameStr = String.valueOf(userNameTF.getText());
                                    double incomeReader = Double.parseDouble(incomeField.getText());
                                    Label netIncome = new Label("Your income is: "+ incomeReader);
                                    netIncome.setStyle("-fx-font: 20 arial;");
                                    netIncome.setTextFill(Color.WHITE);
                                    Label accountName = new Label("Account User: "+ userNameStr);
                                    accountName.setStyle("-fx-font: 20 arial;");
                                    accountName.setTextFill(Color.WHITE);

                                    Label rentLabel = new Label("Rent");
                                    rentLabel.setStyle("-fx-font: 18 arial;");
                                    TextField rentTextField = new TextField("0.00");

                                    Label foodLabel = new Label("Food");
                                    foodLabel.setStyle("-fx-font: 18 arial;");
                                    TextField foodTextField = new TextField("0.00");


                                    Label enterLabel = new Label("Entertainment");
                                    enterLabel.setStyle("-fx-font: 18 arial;");
                                    TextField enterTextField = new TextField("0.00");


                                    Label billsLabel = new Label("Bills");
                                    billsLabel.setStyle("-fx-font: 18 arial;");
                                    TextField billsTextField = new TextField("0.00");


                                    Label insuLabel = new Label("Insurance");
                                    insuLabel.setStyle("-fx-font: 18 arial;");
                                    TextField insuTextField = new TextField("0.00");


                                    Label extrasLabel = new Label("Extras");
                                    extrasLabel.setStyle("-fx-font: 18 arial;");
                                    TextField extrasTextField = new TextField("0.00");


                                    Label clothLabel = new Label("Clothing");
                                    clothLabel.setStyle("-fx-font: 18 arial;");
                                    TextField clothTextField = new TextField("0.00");

                                    Button add3 = new Button("Add to Budget");
                                    add3.setStyle("-fx-background-color: MediumSeaGreen");

                                    BackgroundImage myBI= new BackgroundImage(new Image("bw2.png",950,150,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                                    gridPane.setBackground(new Background(myBI)); 

                                    double checker1 = Double.parseDouble(rentTextField.getText());
                                    double checker2 = Double.parseDouble(foodTextField.getText());
                                    double checker3 = Double.parseDouble(enterTextField.getText());
                                    double checker4 = Double.parseDouble(billsTextField.getText());
                                    double checker5 = Double.parseDouble(insuTextField.getText());
                                    double checker6 = Double.parseDouble(extrasTextField.getText());
                                    double checker7 = Double.parseDouble(clothTextField.getText());
                                    Double sum = checker1 + checker2 + checker3 + checker4 + checker5 + checker6 + checker7;


                                    add3.setOnAction(new EventHandler <ActionEvent>() //This is the button that will actually add everything up once the user presses it.
                                    {
                                      public void handle(ActionEvent event)
                                      {
                                        GridPane gridPane = new GridPane();
                                        gridPane.setMinSize(900,300);
                                        gridPane.setPadding(new Insets(10,10,10,10));
                                        gridPane.setVgap(5);
                                        gridPane.setHgap(5);
                                        gridPane.setAlignment(Pos.TOP_LEFT);

                                        String userNameStr = String.valueOf(userNameTF.getText());
                                        double incomeReader = Double.parseDouble(incomeField.getText());
                                        Label netIncome = new Label("Your income is: "+ incomeReader);
                                        netIncome.setStyle("-fx-font: 20 arial;");
                                        netIncome.setTextFill(Color.WHITE);
                                        Label accountName = new Label("Account User: "+ userNameStr);
                                        accountName.setStyle("-fx-font: 20 arial;");
                                        accountName.setTextFill(Color.WHITE);

                                        firstMessage.setText("");

                                        Double rentTaker = Double.parseDouble(rentTextField.getText());
                                        rentLabel.setText("Your budget for rent is: " + rentTaker);
                                        rentTextField.setText("");

                                        Double foodTaker = Double.parseDouble(foodTextField.getText());
                                        foodLabel.setText("Your budget for food is: " + foodTaker);
                                        foodTextField.setText("");

                                        Double enterTaker = Double.parseDouble(enterTextField.getText());
                                        enterLabel.setText("Your budget for entertainment is: " + enterTaker);
                                        enterTextField.setText("");

                                        Double billsTaker = Double.parseDouble(billsTextField.getText());
                                        billsLabel.setText("Your budget for bills is: " + billsTaker);
                                        billsTextField.setText("");

                                        Double insuTaker = Double.parseDouble(insuTextField.getText());
                                        insuLabel.setText("Your budget for insurance is: " + insuTaker);
                                        insuTextField.setText("");

                                        Double extrasTaker = Double.parseDouble(extrasTextField.getText());
                                        extrasLabel.setText("Your budget for extras is: " + extrasTaker);
                                        extrasTextField.setText("");

                                        Double clothTaker = Double.parseDouble(clothTextField.getText());
                                        clothLabel.setText("Your budget for clothes is: " + clothTaker);
                                        clothTextField.setText("");

                                        BackgroundImage myBI= new BackgroundImage(new Image("bw2.png",950,150,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                                        gridPane.setBackground(new Background(myBI)); 

                                        Double sum = rentTaker + foodTaker + enterTaker + billsTaker + insuTaker + extrasTaker + clothTaker;
                                        Double remainder = incomeReader - sum;

                                        if(remainder < 0) //Checks for invalid entries or errors.
                                        {   

                                            Label warning = new Label("Careful! Your budget is more than your income! Please change the budget.");
                                            warning.setStyle("-fx-font: 18 arial;");
                                            Label addAgain = new Label("Please enter your budget again.");
                                            addAgain.setStyle("-fx-font: 18 arial;");

                                            rentTextField.setText("");
                                            foodTextField.setText("");
                                            enterTextField.setText("");
                                            billsTextField.setText("");
                                            insuTextField.setText("");
                                            extrasTextField.setText("");
                                            clothTextField.setText("");
                                            warning.setTextFill(Color.RED);
                                            gridPane.add(warning, 0,14);
                                            gridPane.add(addAgain, 0,15);
                                            gridPane.add(add3, 1, 14);
                                            gridPane.add(rentTextField, 1,4);
                                            gridPane.add(foodTextField, 1,5);
                                            gridPane.add(enterTextField, 1,6);
                                            gridPane.add(billsTextField, 1,7);
                                            gridPane.add(insuTextField, 1,8);
                                            gridPane.add(extrasTextField, 1,10);
                                            gridPane.add(clothTextField, 1,9);
                                        }

                                        Label unallocatedFunds = new Label("Your Unallocated funds: " + remainder);
                                        unallocatedFunds.setStyle("-fx-font: 18 arial;");

                                        Label userReminder = new Label("Now you can add whatever expenses that you have spent too.");
                                        userReminder.setStyle("-fx-font: 18 arial;");
                                        Button addExpenses = new Button("Input Expenses");
                                        addExpenses.setStyle("-fx-background-color: MediumSeaGreen");

                                        addExpenses.setOnAction(new EventHandler<ActionEvent>() //Now we move on from the budget to expenses. Note you can only set the budget once, but change expenses as many times as you want. Again, this button is only initialization.
                                        {
                                          public void handle(ActionEvent event)
                                          {

                                              GridPane gridPane = new GridPane();
                                              gridPane.setMinSize(900,300);
                                              gridPane.setPadding(new Insets(10,10,10,10));
                                              gridPane.setVgap(5);
                                              gridPane.setHgap(5);
                                              gridPane.setAlignment(Pos.TOP_LEFT);


                                              String userNameStr = String.valueOf(userNameTF.getText());
                                              double incomeReader = Double.parseDouble(incomeField.getText());
                                              Label netIncome = new Label("Your income is: "+ incomeReader);
                                              netIncome.setStyle("-fx-font: 20 arial;");
                                              netIncome.setTextFill(Color.WHITE);
                                              Label accountName = new Label("Account User: "+ userNameStr);
                                              accountName.setStyle("-fx-font: 20 arial;");
                                              accountName.setTextFill(Color.WHITE);

                                              rentTextField.setText("0.00");
                                              foodTextField.setText("0.00");
                                              enterTextField.setText("0.00");
                                              billsTextField.setText("0.00");
                                              insuTextField.setText("0.00");
                                              extrasTextField.setText("0.00");
                                              clothTextField.setText("0.00");
                                              
                                              BackgroundImage myBI= new BackgroundImage(new Image("bw2.png",950,150,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                                              gridPane.setBackground(new Background(myBI)); 

                                              Button addActualExpenses = new Button("Add Expenses");
                                              addActualExpenses.setStyle("-fx-background-color: MediumSeaGreen");

                                              addActualExpenses.setOnAction(new EventHandler<ActionEvent>() //This is the button where it actually adds expenses.
                                              {
                                                public void handle(ActionEvent event)
                                                {
                                                    GridPane gridPane = new GridPane();
                                                    gridPane.setPadding(new Insets(10,10,10,10));
                                                    gridPane.setVgap(5);
                                                    gridPane.setHgap(5);
                                                    gridPane.setAlignment(Pos.TOP_LEFT);

                                                    double spentOnRent = Double.parseDouble(rentTextField.getText());
                                                    Label rentAfterSpent = new Label("You have spent "+ spentOnRent + " on rent.");
                                                    rentAfterSpent.setStyle("-fx-font: 18 arial;");
                                                    double percentRent = ( (spentOnRent / rentTaker) * 100 );
                                                    Label percentCounterR = new Label("You have spent " + percentRent + "% from your rent budget!");
                                                    if(percentRent > 100)
                                                    {
                                                      percentCounterR.setTextFill(Color.RED);
                                                    }else
                                                    {
                                                      percentCounterR.setTextFill(Color.GREEN);
                                                    }

                                                    double spentOnFood = Double.parseDouble(foodTextField.getText());
                                                    Label foodAfterSpent = new Label("You have spent "+ spentOnFood + " on food.");
                                                    foodAfterSpent.setStyle("-fx-font: 18 arial;");
                                                    double percentFood = ( (spentOnFood / foodTaker) * 100 );
                                                    Label percentCounterF = new Label("You have spent " + percentFood + "% from your food budget!");
                                                    if(percentFood> 100)
                                                    {
                                                      percentCounterF.setTextFill(Color.RED);
                                                    }else
                                                    {
                                                      percentCounterF.setTextFill(Color.GREEN);
                                                    }

                                                    double spentOnEnter = Double.parseDouble(enterTextField.getText());
                                                    Label enterAfterSpent = new Label("You have spent "+ spentOnEnter + " on entertainment.");
                                                    enterAfterSpent.setStyle("-fx-font: 18 arial;");
                                                    double percentEnter = ( (spentOnEnter / enterTaker) * 100 );
                                                    Label percentCounterEnter = new Label("You have spent " + percentEnter + "% from your entertainment budget!");
                                                    if(percentEnter > 100)
                                                    {
                                                      percentCounterEnter.setTextFill(Color.RED);
                                                    }else
                                                    {
                                                      percentCounterEnter.setTextFill(Color.GREEN);
                                                    }

                                                    double spentOnBills = Double.parseDouble(billsTextField.getText());
                                                    Label billsAfterSpent = new Label("You have spent "+ spentOnBills + " on bills.");
                                                    billsAfterSpent.setStyle("-fx-font: 18 arial;");
                                                    double percentBills = ( (spentOnBills/ billsTaker) * 100 );
                                                    Label percentCounterB = new Label("You have spent " + percentBills + "% from your bills budget!");
                                                    if(percentBills > 100)
                                                    {
                                                      percentCounterB.setTextFill(Color.RED);
                                                    }else
                                                    {
                                                      percentCounterB.setTextFill(Color.GREEN);
                                                    }

                                                    double spentOnInsu = Double.parseDouble(insuTextField.getText());
                                                    Label insuAfterSpent = new Label("You have spent "+ spentOnInsu + " on insurance.");
                                                    insuAfterSpent.setStyle("-fx-font: 18 arial;");
                                                    double percentInsu = ( (spentOnInsu / insuTaker) * 100 );
                                                    Label percentCounterI = new Label("You have spent " + percentInsu + "% from your insurance budget!");
                                                    if(percentInsu > 100)
                                                    {
                                                      percentCounterI.setTextFill(Color.RED);
                                                    }else
                                                    {
                                                      percentCounterI.setTextFill(Color.GREEN);
                                                    }

                                                    double spentOnExtras = Double.parseDouble(extrasTextField.getText());
                                                    Label extrasAfterSpent = new Label("You have spent "+ spentOnExtras + " on extras.");
                                                    extrasAfterSpent.setStyle("-fx-font: 18 arial;");
                                                    double percentExtras = ( (spentOnExtras / extrasTaker) * 100 );
                                                    Label percentCounterEx = new Label("You have spent " + percentExtras + "% from your extras budget!");
                                                    if(percentExtras > 100)
                                                    {
                                                      percentCounterEx.setTextFill(Color.RED);
                                                    }else
                                                    {
                                                      percentCounterEx.setTextFill(Color.GREEN);
                                                    }

                                                    double spentOnCloth = Double.parseDouble(clothTextField.getText());
                                                    Label clothAfterSpent = new Label("You have spent "+ spentOnCloth + " on cloth.");
                                                    clothAfterSpent.setStyle("-fx-font: 18 arial;");
                                                    double percentCloth = ( (spentOnCloth / clothTaker) * 100 );
                                                    Label percentCounterC = new Label("You have spent " + percentCloth + "% from your clothes budget!");
                                                    if(percentCloth > 100)
                                                    {
                                                      percentCounterC.setTextFill(Color.RED);
                                                    }else
                                                    {
                                                      percentCounterC.setTextFill(Color.GREEN);
                                                    }


                                                    BackgroundImage myBI= new BackgroundImage(new Image("bw2.png",950,150,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                                                    gridPane.setBackground(new Background(myBI)); 

                                                    double newSum = spentOnRent + spentOnFood + spentOnEnter + spentOnBills + spentOnInsu + spentOnExtras + spentOnCloth;
                                                    double newRemainder = sum - newSum;

                                                    if( (newRemainder < 0)  && (newSum <= incomeReader) ) // This time testing if expenses more than budget. Note user can still input the expense even if its above budget if he/she insist.
                                                    {
                                                      Label newWarning = new Label("Your expenses are more than your budget. Are you sure you want to do this? If you are not sure you can change the expenses now and try again. \nIf you are sure then press yes.");
                                                      newWarning.setStyle("-fx-font: 18 arial;");
                                                      newWarning.setTextFill(Color.RED);
                                                      Button heSaidYes = new Button("Yes");
                                                     heSaidYes.setStyle("-fx-background-color: MediumSeaGreen");                                                    


                                                      heSaidYes.setOnAction(new EventHandler<ActionEvent>()
                                                      {
                                                        public void handle(ActionEvent event)
                                                        {
                                                    GridPane gridPane = new GridPane();
                                                    gridPane.setMinSize(1000,300);
                                                    gridPane.setPadding(new Insets(10,10,10,10));
                                                    gridPane.setVgap(5);
                                                    gridPane.setHgap(5);
                                                    gridPane.setAlignment(Pos.TOP_LEFT);
                                                    Label youCanAddMore2 = new Label("If you spent more, or want to change your expenses, you can do so by typing your new expenses in the textbox's.\nKeep in mind that changing the value of an expense will change its whole value, and not add it to the previous value!");
                                                    youCanAddMore2.setStyle("-fx-font: 18 arial;");


                                                    Image image2 = new Image("fiaa.png")  ;
                                                    ImageView imageView = new ImageView();
                                                    Timeline timeline = new Timeline(
                                                            new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), image2)),
                                                            new KeyFrame(Duration.seconds(5), new KeyValue(imageView.imageProperty(), null))
                                                            );
                                                    timeline.play();

                                                    gridPane.getChildren().add(imageView);
                                                    gridPane.add(accountName, 0,0);
                                                    gridPane.add(netIncome, 0,1);
                                                    gridPane.add(firstMessage,0,28);
                                                    gridPane.add(rentLabel, 0,4);
                                                    gridPane.add(rentAfterSpent, 0,5);
                                                    gridPane.add(percentCounterR, 0,6);
                                                    gridPane.add(rentTextField, 1,5);
                                                    gridPane.add(foodLabel, 0,7);
                                                    gridPane.add(foodAfterSpent, 0,8);
                                                    gridPane.add(foodTextField, 1,8);
                                                    gridPane.add(percentCounterF, 0,9);
                                                    gridPane.add(enterLabel, 0,10);
                                                    gridPane.add(enterAfterSpent, 0,11);
                                                    gridPane.add(enterTextField, 1,11);
                                                    gridPane.add(percentCounterEnter, 0,12);
                                                    gridPane.add(billsLabel, 0,13);
                                                    gridPane.add(billsAfterSpent, 0,14);
                                                    gridPane.add(billsTextField, 1,14);
                                                    gridPane.add(percentCounterB, 0,15);
                                                    gridPane.add(insuLabel, 0,16);
                                                    gridPane.add(insuAfterSpent, 0,17);
                                                    gridPane.add(insuTextField, 1,17);
                                                    gridPane.add(percentCounterI, 0,18);
                                                    gridPane.add(extrasLabel, 0,19);
                                                    gridPane.add(extrasAfterSpent, 0,20);
                                                    gridPane.add(extrasTextField, 1,20);
                                                    gridPane.add(percentCounterEx, 0,21);
                                                    gridPane.add(clothLabel, 0,22);
                                                    gridPane.add(clothAfterSpent, 0,23);
                                                    gridPane.add(clothTextField, 1,23);
                                                    gridPane.add(percentCounterC, 0,24);
                                                    gridPane.add(unallocatedFunds, 0,25);
                                                    gridPane.add(addActualExpenses, 0, 27);
                                                    gridPane.add(youCanAddMore2, 0,28);
                                                    gridPane.add(exit, 1,28);

                                                    BackgroundImage myBI= new BackgroundImage(new Image("bw2.png",450,150,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                                                    gridPane.setBackground(new Background(myBI)); 

                                                    Scene scene = new Scene(gridPane);
                                                    primaryStage.setScene(scene);
                                                    primaryStage.show();
                                                      }
                                                    }
                                                      );

    
                                                    rentTextField.setText("0.00");
                                                    foodTextField.setText("0.00");
                                                    enterTextField.setText("0.00");
                                                    billsTextField.setText("0.00");
                                                    insuTextField.setText("0.00");
                                                    extrasTextField.setText("0.00");
                                                    clothTextField.setText("0.00");

                                                    Label youCanAddMore = new Label("If you spent more, or want to change your expenses, you can do so by typing your new expenses in the textbox's.\nKeep in mind that changing the value of an expense will change its whole value, and not add it to the previous value!");

                                                    gridPane.add(accountName, 0,0);
                                                    gridPane.add(netIncome, 0,1);
                                                    gridPane.add(firstMessage,0,14);
                                                    gridPane.add(rentLabel, 0,4);
                                                    gridPane.add(rentTextField, 2,4);
                                                    gridPane.add(foodLabel, 0,5);
                                                    gridPane.add(foodTextField, 2,5);
                                                    gridPane.add(enterLabel, 0,6);
                                                    gridPane.add(enterTextField, 2,6);
                                                    gridPane.add(billsLabel, 0,7);
                                                    gridPane.add(billsTextField, 2,7);
                                                    gridPane.add(insuLabel, 0,8);
                                                    gridPane.add(insuTextField, 2,8);
                                                    gridPane.add(extrasLabel, 0,10);
                                                    gridPane.add(extrasTextField, 2,10);
                                                    gridPane.add(clothLabel, 0,9);
                                                    gridPane.add(clothTextField, 2,9);
                                                    gridPane.add(unallocatedFunds, 0,12);
                                                    gridPane.add(addActualExpenses, 0, 13);
                                                    gridPane.add(newWarning, 0,14);
                                                    gridPane.add(heSaidYes, 1,14);
                                                    gridPane.add(exit, 1,15);

                                                    Scene scene = new Scene(gridPane);
                                                    primaryStage.setScene(scene);
                                                    primaryStage.show();
                                                  }else if(newSum > incomeReader)
                                                  {
                                                    Label newWarning = new Label("Your expenses are more than your income, which is not possible. Please re-enter your expenses.");
                                                    newWarning.setStyle("-fx-font: 18 arial;");
                                                    newWarning.setTextFill(Color.RED);

                                                    gridPane.add(accountName, 0,0);
                                                    gridPane.add(netIncome, 0,1);
                                                    gridPane.add(firstMessage,0,14);
                                                    gridPane.add(rentLabel, 0,4);
                                                    gridPane.add(rentTextField, 2,4);
                                                    gridPane.add(foodLabel, 0,5);
                                                    gridPane.add(foodTextField, 2,5);
                                                    gridPane.add(enterLabel, 0,6);
                                                    gridPane.add(enterTextField, 2,6);
                                                    gridPane.add(billsLabel, 0,7);
                                                    gridPane.add(billsTextField, 2,7);
                                                    gridPane.add(insuLabel, 0,8);
                                                    gridPane.add(insuTextField, 2,8);
                                                    gridPane.add(extrasLabel, 0,10);
                                                    gridPane.add(extrasTextField, 2,10);
                                                    gridPane.add(clothLabel, 0,9);
                                                    gridPane.add(clothTextField, 2,9);
                                                    gridPane.add(unallocatedFunds, 0,12);
                                                    gridPane.add(addActualExpenses, 0, 13);
                                                    gridPane.add(newWarning, 0,14);
                                                    gridPane.add(exit, 1,15);


                                                    Scene scene = new Scene(gridPane);
                                                    primaryStage.setScene(scene);
                                                    primaryStage.show();
                                                  }
                                                    rentTextField.setText("0.00");
                                                    foodTextField.setText("0.00");
                                                    enterTextField.setText("0.00");
                                                    billsTextField.setText("0.00");
                                                    insuTextField.setText("0.00");
                                                    extrasTextField.setText("0.00");
                                                    clothTextField.setText("0.00");

                                                    Label youCanAddMore = new Label("If you spent more, or want to change your expenses, you can do so by typing your new expenses in the textbox's.\nKeep in mind that changing the value of an expense will change its whole value, and not add it to the previous value!");
                                                    youCanAddMore.setStyle("-fx-font: 20 arial;");

                                                    gridPane.add(accountName, 0,0);
                                                    gridPane.add(netIncome, 0,1);
                                                    gridPane.add(firstMessage,0,28);
                                                    gridPane.add(rentLabel, 0,4);
                                                    gridPane.add(rentAfterSpent, 0,5);
                                                    gridPane.add(percentCounterR, 0,6);
                                                    gridPane.add(rentTextField, 1,5);
                                                    gridPane.add(foodLabel, 0,7);
                                                    gridPane.add(foodAfterSpent, 0,8);
                                                    gridPane.add(foodTextField, 1,8);
                                                    gridPane.add(percentCounterF, 0,9);
                                                    gridPane.add(enterLabel, 0,10);
                                                    gridPane.add(enterAfterSpent, 0,11);
                                                    gridPane.add(enterTextField, 1,11);
                                                    gridPane.add(percentCounterEnter, 0,12);
                                                    gridPane.add(billsLabel, 0,13);
                                                    gridPane.add(billsAfterSpent, 0,14);
                                                    gridPane.add(billsTextField, 1,14);
                                                    gridPane.add(percentCounterB, 0,15);
                                                    gridPane.add(insuLabel, 0,16);
                                                    gridPane.add(insuAfterSpent, 0,17);
                                                    gridPane.add(insuTextField, 1,17);
                                                    gridPane.add(percentCounterI, 0,18);
                                                    gridPane.add(extrasLabel, 0,19);
                                                    gridPane.add(extrasAfterSpent, 0,20);
                                                    gridPane.add(extrasTextField, 1,20);
                                                    gridPane.add(percentCounterEx, 0,21);
                                                    gridPane.add(clothLabel, 0,22);
                                                    gridPane.add(clothAfterSpent, 0,23);
                                                    gridPane.add(clothTextField, 1,23);
                                                    gridPane.add(percentCounterC, 0,24);
                                                    gridPane.add(unallocatedFunds, 0,25);
                                                    gridPane.add(addActualExpenses, 0, 27);
                                                    gridPane.add(youCanAddMore, 0,28);
                                                    gridPane.add(exit, 1,28);


                                                    Scene scene = new Scene(gridPane);
                                                    primaryStage.setScene(scene);
                                                    primaryStage.show();
                                                }
                                              }
                                              );

                                              gridPane.add(accountName, 0,0);
                                              gridPane.add(netIncome, 0,1);
                                              gridPane.add(firstMessage,0,14);
                                              gridPane.add(rentLabel, 0,4);
                                              gridPane.add(rentTextField, 1,4);
                                              gridPane.add(foodLabel, 0,5);
                                              gridPane.add(foodTextField, 1,5);
                                              gridPane.add(enterLabel, 0,6);
                                              gridPane.add(enterTextField, 1,6);
                                              gridPane.add(billsLabel, 0,7);
                                              gridPane.add(billsTextField, 1,7);
                                              gridPane.add(insuLabel, 0,8);
                                              gridPane.add(insuTextField, 1,8);
                                              gridPane.add(extrasLabel, 0,10);
                                              gridPane.add(extrasTextField, 1,10);
                                              gridPane.add(clothLabel, 0,9);
                                              gridPane.add(clothTextField, 1,9);
                                              gridPane.add(unallocatedFunds, 0,12);
                                              gridPane.add(addActualExpenses, 0, 13);
                                              gridPane.add(exit, 40,13);


                                        Scene scene = new Scene(gridPane);
                                        primaryStage.setScene(scene);
                                        primaryStage.show();
                                          }
                                        }
                                        );

                                        gridPane.add(accountName, 0,0);
                                        gridPane.add(netIncome, 0,1);
                                        gridPane.add(firstMessage,0,14);
                                        gridPane.add(rentLabel, 0,4);
                                        gridPane.add(foodLabel, 0,5);
                                        gridPane.add(enterLabel, 0,6);
                                        gridPane.add(billsLabel, 0,7);
                                        gridPane.add(insuLabel, 0,8);
                                        gridPane.add(extrasLabel, 0,10);
                                        gridPane.add(clothLabel, 0,9);
                                        gridPane.add(unallocatedFunds, 0,12);
                                        gridPane.add(addExpenses, 0, 14);
                                        gridPane.add(userReminder,0,13);
                                        gridPane.add(exit, 40,14);

                                        Scene scene = new Scene(gridPane);
                                        primaryStage.setScene(scene);
                                        primaryStage.show();
                                      }
                                    }
                                    );

                                    gridPane.add(firstMessage, 0, 4);
                                    gridPane.add(netIncome, 0, 1);
                                    gridPane.add(accountName, 0,0);
                                    gridPane.add(rentLabel, 0,6);
                                    gridPane.add(rentTextField, 1,6);
                                    gridPane.add(foodLabel, 0,7);

                                    gridPane.add(foodTextField, 1, 7);
                                    gridPane.add(enterLabel, 0, 8);
                                    gridPane.add(enterTextField, 1,8);
                                    gridPane.add(billsLabel, 0,9);
                                    gridPane.add(billsTextField, 1,9);
                                    gridPane.add(insuLabel, 0,10);

                                    gridPane.add(insuTextField, 1, 10);
                                    gridPane.add(extrasLabel, 0, 12);
                                    gridPane.add(extrasTextField, 1,12);
                                    gridPane.add(clothLabel, 0,11);
                                    gridPane.add(clothTextField, 1,11);
                                    gridPane.add(add3, 0,13);
                                    gridPane.add(exit, 10,13);


                                    Scene scene = new Scene(gridPane);
                                    primaryStage.setScene(scene);
                                    primaryStage.show();

                          }
                        }
                        );


              gridPane.add(netIncome, 0, 1);
              gridPane.add(accountName, 0, 0);
              gridPane.add(allTheBudgets, 0,5);
              gridPane.add(unallocatedFunds, 2,5);
              gridPane.add(add, 0,10);
              gridPane.add(addButton, 0,9);
              gridPane.add(exit, 70,10);
              Scene scene = new Scene(gridPane);
              primaryStage.setScene(scene);
              primaryStage.show();
          }
        }
        );

        Accounts newVariable = new Accounts();


        gridPane.add(welcomeLabel, 0,0);
        gridPane.add(userName, 0,2);
        gridPane.add(userNameTF, 0,3);
        gridPane.add(incomeLabel, 0,4);
        gridPane.add(incomeField, 0,5);

        gridPane.add(proceed, 1,6);

        BackgroundImage myBI= new BackgroundImage(new Image("piggy.png",450,400,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        gridPane.setBackground(new Background(myBI));        




        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}