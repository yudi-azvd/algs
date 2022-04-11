package AlgorithmsPrincetonCourse.chap01.sec1_2.AbstractData.Exercises;

/**
 * <code>exercise-1.2.16</code>
 */
public class Rational {
  private long numerator;
  private long denominator;

  public Rational(long num, long den) {
    long commomDenominator = gcd(num, den);
    numerator = num/commomDenominator;
    if (den == 0)
      throw new IllegalArgumentException("denominator cannot be 0");
    denominator = den/commomDenominator;
  }

  @Override
  public String toString() {
    return numerator + " / " + denominator;
  }

  public static long gcd(long p, long q) {
    if (q == 0) return p;
    long r = p % q;
    return gcd(q, r);
  }

  public Rational rationalGcd(long num, long den) {
    long commomDenominator = gcd(num, den);
    return new Rational(num/commomDenominator, den/commomDenominator);
  }

  public Rational plus(Rational b) {
    if (this.denominator != b.denominator) {
      long newDenominator = this.denominator*b.denominator;
      long bFactor = b.denominator;
      long thisFactor = this.denominator;
      long newNumerator = this.numerator*bFactor + b.numerator*thisFactor;
      
      return rationalGcd(newNumerator, newDenominator);
    }
    
    return rationalGcd(this.numerator+b.numerator, this.denominator);
  }

  public Rational minus(Rational b) {
    Rational negativeB = new Rational(-b.numerator, b.denominator);
    return this.plus(negativeB);
  }

  public Rational times(Rational b) {
    return rationalGcd(this.numerator*b.numerator,
      this.denominator*b.denominator);
  }

  public Rational divides(Rational b) {
    return rationalGcd(this.numerator*b.denominator, this.denominator*b.numerator);
  }

  public boolean equals(Rational b) {
    return this.numerator == b.numerator && this.denominator == b.denominator;
  }

  public static void main(String[] args) {
    System.out.println(new Rational(3, 5).plus(new Rational(2, 4)));
    System.out.println(new Rational(1, 4).plus(new Rational(2, 4)));
    System.out.println(new Rational(1, 1).plus(new Rational(1, 1)));
    System.out.println();
    
    System.out.println(new Rational(1, 1).minus(new Rational(1, 1)));
    System.out.println(new Rational(1, 1).minus(new Rational(2, 1)));
    System.out.println(new Rational(1, 10).minus(new Rational(2, 3)));
    System.out.println();

    System.out.println(new Rational(1, 10).times(new Rational(2, 3)));
    System.out.println();

    System.out.println(new Rational(4, 6).divides(new Rational(7, 8)));
    System.out.println();


    System.out.println(new Rational(1, 1)
               .equals(new Rational(1, 1)));
    System.out.println(new Rational(1, 2)
               .equals(new Rational(1, 1)));
    System.out.println(new Rational(1, 2)
               .equals(new Rational(2, 4)));
    System.out.println(new Rational(3, 7)
               .equals(new Rational(2, 8)));
  }
}
