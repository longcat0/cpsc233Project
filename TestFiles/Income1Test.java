import static org.junit.Assert.*;
import org.junit.Test;

public class Income1Test
{
	
	// tests valid value
	@Test
	public void test_valid_value()
	{
		Income1 income = new Income1();
		income.setAmount(200.0);
		assertEquals("allocate valid icnome value 200.0", 200.0,income.getAmount(),0.000001);
	}
	
	// tests invalid value
	@Test
	public void test_negative_value()
	{
		Income1 income = new Income1();
		income.setAmount(-2000.0);
		assertEquals("allocate invalid negative icnome value -2000.0", 0.0,income.getAmount(),0.000001);
	}
	
	// test if romoval is possible
	@Test
	public void test_remove_Amount()
	{
		Income1 income = new Income1();
		income.setAmount(1000);
		income.removeAmount(100);
		assertEquals("Removed 100 from 1000, expected 900.", 900,income.getAmount(),0.000001);
	}
	
	// set an amount and then add to it
	@Test
	public void test_add_Amount()
	{
		Income1 income = new Income1();
		income.setAmount(1000);
		income.addAmount(100);
		assertEquals("Added 100 to 1000, expected 1100.", 1100,income.getAmount(),0.000001);
	}
		
	// set an amount and add an invalid amount
	@Test
	public void test_add_Amount_invalid()
	{
		Income1 income = new Income1();
		income.setAmount(1000);
		income.addAmount(-100);
		assertEquals("Added -100 to 1000, which is not possible. Expected nothing to change.", 1000,income.getAmount(),0.000001);
	}
	
	
}