import java.math.BigInteger;
import java.math.BigDecimal;

public class Rational extends Number implements Comparable<Rational> {
  // Data fields for numerator and denominator
  private BigInteger numerator;
  private BigInteger denominator;

  /** Construct a rational with default properties */
  public Rational() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }

  /** Construct a rational with specified numerator and denominator */
  public Rational(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = gcd(numerator, denominator);
    //this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
    this.numerator = ((denominator.compareTo(BigInteger.ZERO) > 0) ? BigInteger.ONE : BigInteger.valueOf(-1)).multiply(numerator.divide(gcd));
    this.denominator = denominator.abs().divide(gcd);
  }

  /** Find GCD of two numbers */
  private static BigInteger gcd(BigInteger n, BigInteger d) {
    BigInteger n1 = n.abs();
    BigInteger n2 = d.abs();
    BigInteger gcd = BigInteger.ONE;
    
    for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0 ; k = k.add(BigInteger.ONE)) {
      if (n1.mod(k).equals(BigInteger.ZERO) && n2.mod(k).equals(BigInteger.ZERO))
        gcd = k;
    }

    return gcd;
  }

  /** Return numerator */
  public BigInteger getNumerator() {
    return numerator;
  }

  /** Return denominator */
  public BigInteger getDenominator() {
    return denominator;
  }

  /** Add a rational number to this rational */
  public Rational add(Rational secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  /** Subtract a rational number from this rational */
  public Rational subtract(Rational secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  /** Multiply a rational number to this rational */
  public Rational multiply(Rational secondRational) {
    BigInteger n = numerator.multiply(secondRational.getNumerator());
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  /** Divide a rational number from this rational */
  public Rational divide(Rational secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator());
    BigInteger d = denominator.multiply(secondRational.numerator);
    return new Rational(n, d);
  }

  @Override  
  public String toString() {
    if (denominator.equals(BigInteger.ONE))
      return numerator + "";
    else
      return numerator + "/" + denominator;
  }

  @Override // Override the equals method in the Object class 
  public boolean equals(Object other) {
    if ((this.subtract((Rational)(other))).getNumerator().equals(BigInteger.ZERO))
      return true;
    else
      return false;
  }

  @Override // Implement the abstract intValue method in Number 
  public int intValue() {
    return (int)doubleValue();
  }

  @Override // Implement the abstract floatValue method in Number 
  public float floatValue() {
    return (float)doubleValue();
  }

  @Override // Implement the doubleValue method in Number 
  public double doubleValue() {
    BigDecimal decimalNumerator= new BigDecimal(numerator);
    BigDecimal decimalDenominator = new BigDecimal(denominator);

    // Take the BigDecimal numerator and divide by the BigDecimal denominator
    return decimalNumerator.divide(decimalDenominator, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
  }

  @Override // Implement the abstract longValue method in Number
  public long longValue() {
    return (long)doubleValue();
  }

  @Override // Implement the compareTo method in Comparable
  public int compareTo(Rational o) {
    if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
      return 1;
    else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
      return -1;
    else
      return 0;
  }
}