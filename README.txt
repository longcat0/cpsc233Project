**Authors**
> Sharif
> Aron 
> Song
> Mustafa
> Mihailo

**Usage** 
1. In the command prompt, type 'git clone https://github.com/GomenNasai9/cpsc233Project.git' to clone the cpsc233Project repository.
2. Change the directory using 'cd [folder name]'.
3. Change the directory to the folder named cpsc233Project (the cloned repository), then to the folder named 'ProjectGUI2'.
4. In order to run the program, you will first need to compile the java files. To do that, type 'javac *.java' into the command prompt.
5. Type 'java Main' to run the program. 

**Program Instructions**
- Clicking the "Continue" button will load all the previously saved accounts.
- Begin by creating an account with a name and amount of income. 
- In the main menu, the user is presented with various options to manipulate their account.
- In order to exit the program, the user can click on the exit button in the top right corner of the window. This will save the             current states of all the accounts.

**Features**
- Creation of multiple accounts
- Each account contains seven default budgets
- Transferring funds between budgets
- Adding an expense towards a budget. That expense will be saved to a transactions list
- Users have the option to add any additional incomes to their accounts, which they can allocate towards their current budgets



**Issues (To be addressed)**
> Users are able to put input String into text fields where a double is supposed to be taken.
> Clicking "Continue" when there are no accounts saved in the binary file.
> Adding more visual indicators to notify the user about invalid inputs, illegal actions, etc.
> NullPointerExceptions
> Accounts in transaction list is not displayed.

**JUnitTest**
> There are three main tests
  - Budgets
  - Expense
  - Income1

> When testing the files, make sure you have unit-4.12.jar and hamcrest-core-1.3.jar in the same folder as the JUnit Tests.
1. Change the directory to a folder called TestFiles using the 'cd [folder name]' command
2. Run the command: javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
3. Run this command along with the file you want to test: java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test class>


