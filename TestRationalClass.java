import java.util.Scanner; // Import the Scanner class to read the two numbers entered by the user
import java.math.BigInteger;

public class TestRationalClass {
  /** Main method */
  public static void main(String[] args) {
    // Create and initialize two rational numbers r1 and r2.

    Scanner input = new Scanner(System.in);
    System.out.println("Enter the first rational number: ");
    long firstNumerator = input.nextLong();
    long firstDenominator = input.nextLong();
    System.out.println("Enter the second rational number: ");
    long secondNumerator = input.nextLong();
    long secondDenominator = input.nextLong();
    Rational r1 = new Rational(BigInteger.valueOf(firstNumerator), BigInteger.valueOf(firstDenominator));
    Rational r2 = new Rational(BigInteger.valueOf(secondNumerator), BigInteger.valueOf(secondDenominator));

    // Display results
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}
