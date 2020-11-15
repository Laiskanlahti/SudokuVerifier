import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
	public static final String correctString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	public static final String incorrectStringR1 = "417369825632150947958724316825437169791586432346912758289643571573291684164875293";
	public static final String incorrectStringR2 = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	public static final String incorrectStringR3 = "417369825632158947958724316825434169791586432346912758289643571573291684164875293";
	public static final String incorrectStringR4 = "416379825632158947958724316825437169791586432346912758289643571573291684164875293";
	
	@Test
	public void testCorrectString() {
		SudokuVerifier verifier = new SudokuVerifier();
		String candidateresult = correctString;
		int result = verifier.verify(candidateresult);
		System.out.println("return of correctstring:"+result);
		assertTrue(result == 0);
	}
	
	@Test
	public void testVerifyFailR1() {
		SudokuVerifier n = new SudokuVerifier();
		String fail = incorrectStringR1;
		int result = n.verify(fail);
		System.out.println("return of IncorrectStringR1:"+result);
		assertTrue("result is incorrect", result == -1);
	}
	
	@Test
	public void testVerifyFailR2() {
		SudokuVerifier n = new SudokuVerifier();
		String fail = incorrectStringR2;
		int result = n.verify(fail);
		System.out.println("return of IncorrectStringR2:"+result);
		assertTrue("result is incorrect", result == -2);
	}
	@Test
	public void testVerifyFailR3() {
		SudokuVerifier n = new SudokuVerifier();
		String fail = incorrectStringR3;
		int result = n.verify(fail);
		System.out.println("return of IncorrectStringR3:"+result);
		assertTrue("result is incorrect", result == -3);
	}
	@Test
	public void testVerifyFailR4() {
		SudokuVerifier n = new SudokuVerifier();
		String fail = incorrectStringR4;
		int result = n.verify(fail);
		System.out.println("return of IncorrectStringR4:"+result);
		assertTrue("result is incorrect", result == -4);
	}
}
