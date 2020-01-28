package unit.arithmetic.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ArithmeticCalculation.ArithmeticCalculation;

public class ArithmeticCalculationTest {

	private ArithmeticCalculation arithmeticCalculation;

	@BeforeClass
	public void setUp() {
		arithmeticCalculation = new ArithmeticCalculation();
	}

	@Test
	public void testAdd() {
		int a = 11;
		int b = 20;
		int expectedResult = 31;
		long result = arithmeticCalculation.add(a, b);
		Assert.assertEquals(expectedResult, result);

	}

	@Test
	public void testSubtract() {
		int a = 250;
		int b = 200;
		int expectedResult = 50;
		long result = arithmeticCalculation.subtract(a, b);
		Assert.assertEquals(expectedResult, result);
		;
	}

	@Test
	public void testMultiply() {
		int a = 2;
		int b = 25;
		long expectedResult = 50;
		long result = arithmeticCalculation.multiply(a, b);
		Assert.assertEquals(expectedResult, result);

	}

	@Test
	public void testDivide() {
		int a = 66;
		int b = 10;
		double expectedResult = 6.6;
		double result = arithmeticCalculation.divide(a, b);
		Assert.assertEquals(expectedResult, result, 0.00005);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDivideByZero() {
		int a = 15;
		int b = 0;
		arithmeticCalculation.divide(a, b);
	}

	@Test
	public void addAsciiChar() {
		int a = 11;
		int b = 'A';
		int expectedResult = 76;
		long result = arithmeticCalculation.add(a, b);
		Assert.assertEquals(expectedResult, result);

	}

	@Test
	public void addNegativeNumbers() {
		int a = -11;
		int b = -2;
		int expectedResult = -13;
		long result = arithmeticCalculation.add(a, b);
		Assert.assertEquals(expectedResult, result);

	}

	@Test
	public void subtractFunNegativeTest() {
		int a = -11;
		int b = -2;
		int expectedResult = -13;
		long result = arithmeticCalculation.subtract(a, b);
		Assert.assertNotEquals(expectedResult, result);

	}

}
