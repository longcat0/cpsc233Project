import static org.junit.Assert.*;
import org.junit.Test;

public class BudgetsTest
{
	// tests for valid name
	@Test
	public void test_valid_name()
	{
		Budgets b = new Budgets("Sharif");
		assertEquals("set budget name to 'Sharif'", "Sharif",b.getBudgName());
	}
	
	// tests valid value
	@Test
	public void test_valid_value()
	{
		Budgets b = new Budgets();
		b.setBudgAmount(200.0);
		assertEquals("allocate valid budget value 200", 200.0,b.getBudgAmount(),0.000001);
	}
	
	// Tests zero value
	@Test
	public void test_zero_value()
	{
		Budgets b = new Budgets();
		b.setBudgAmount(0.0);
		assertEquals("allocate zero budget value 0.0", 0.0,b.getBudgAmount(),0.000001);
	}
	
	// Tests negative value
	@Test
	public void test_negative_value()
	{
		Budgets b = new Budgets();
		b.setBudgAmount(-2000.0);
		assertEquals("allocate negative budget value -2000.0", 0.0,b.getBudgAmount(),0.000001);
	}
	
	// tests amount after adding a positive amount
	@Test
	public void tes_after_adding_to_amount()
	{
		Budgets b = new Budgets();
		b.setBudgAmount(500.0);
		b.addToBudg(50.0);
		assertEquals("Added 50 to 500, expected 550. ", 550.0, b.getBudgAmount(),0.000001);
	}

	// tests for negative amount added to current amount
	@Test
	public void tes_after_adding_to_amount_negative()
	{
		Budgets b = new Budgets();
		b.setBudgAmount(500.0);
		b.addToBudg(-50.0);
		assertEquals("Added negative amount, which is not possible. ", 500.0, b.getBudgAmount(),0.000001);
	}
	// tests for zero amount added to current amount
	@Test
	public void tes_after_adding_to_amount_zero()
	{
		Budgets b = new Budgets();
		b.setBudgAmount(500.0);
		b.addToBudg(0.0);
		assertEquals("Added negative amount, which is not possible. ", 500.0, b.getBudgAmount(),0.000001);
	}

	// test for removing  amount from current amount
	@Test
	public void tes_after_removing_from_amount()
	{
		Budgets b = new Budgets();
		b.setBudgAmount(500.0);
		b.removeFromBudg(50.0);
		assertEquals("Removed 50 from 500, expected 450. ", 450.0, b.getBudgAmount(),0.000001);
	}

	// test for removing negative amount from current amount
	@Test
	public void tes_after_removing_from_amount_negative()
	{
		Budgets b = new Budgets();
		b.setBudgAmount(500.0);
		b.removeFromBudg(-50.0);
		assertEquals("Removed negative amount, which is not possible.", 500.0, b.getBudgAmount(),0.000001);
	}

	// tests for transfering from 
	@Test
	public void transfer_to_budget_method()
	{
		Budgets b = new Budgets("Rent", 5000.0);
		Budgets c = new Budgets("Extras", 1000.0);
		c.transferToBudget(b, 500.0);
		assertEquals("Added 500 to Rent account.", 5500.0, b.getBudgAmount(),0.000001);
	}

	// test for transfer greater than the valid amount
	@Test
	public void transfer_to_budget_method_invalid_transfer()
	{
		Budgets b = new Budgets("Rent", 5000.0);
		Budgets c = new Budgets("Extras", 1000.0);
		c.transferToBudget(b, 1500.0);
		assertEquals("Invalid transfer, expected nothing to change. ", 5000.0, b.getBudgAmount(),0.000001);
	}

	// test transfer for a negative amount
	@Test
	public void transfer_to_budget_method_invalid_transfer_negative()
	{
		Budgets b = new Budgets("Rent", 5000.0);
		Budgets c = new Budgets("Extra", 1000.0);
		c.transferToBudget(b, -1500.0);
		assertEquals("Invalid transfer, expected nothing to change. ", 5000.0, b.getBudgAmount(),0.000001);
	}
}