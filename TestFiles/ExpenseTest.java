import static org.junit.Assert.*;
import org.junit.Test;

public class ExpenseTest
{
	
	// tests valid name
	@Test
	public void test_valid_budget_name()
	{
		
		Expense e = new Expense("Sharif", 500.0, "My Account");
		e.getBudgetName();
		assertEquals("set name = Sharif, amount = 500.0, myAccount = My Account", "Sharif", e.getBudgetName());
	}
	
	
	// tests numbers as budget name
	@Test
	public void test_number_value_for_name_account()
	{
		
		Expense e = new Expense("1234", 500.0, "4321");
		e.getBudgetName();
		assertEquals("set name = 1234, amount = 500.0, myAccount = 4321", "4321", e.getAccountName());
	}
	
	// tests numbers as name and account
	@Test
	public void test_valid_number_account_name()
	{
		
		Expense e = new Expense("1234", 500.0, "4321");
		e.getBudgetName();
		assertEquals("set name = 1234, amount = 500.0, myAccount = 4321", "4321", e.getAccountName());
	}
	
	// tests valide amount
	@Test
	public void test_valid_amount()
	{
		
		Expense e = new Expense("Sharif", 500.0, "Rent");
		e.getBudgetName();
		assertEquals("set name = Sharif, amount = 500.0, myAccount = Rent", 500.0, e.getAmount(),0.0001);
	}
	
	
	
	
	
}