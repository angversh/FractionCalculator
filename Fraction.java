public class Fraction {
    private int numerator = 0;
    private int denominator = 0;

    //2 parameter constructor
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) { //check 4 zero
            throw new IllegalArgumentException(Integer.toString(denominator));
        } else if (denominator < 0) {
            this.numerator *= -1;
            this.denominator = (-1) * denominator;
        } else {
            this.denominator = denominator;
        }
    }

    //1 parameter constructor
    public Fraction(int numerator) {
        this(numerator, 1);
    }


    public int getNumer() {
        return this.numerator;
    }

    public int getDenom() {
        return this.denominator;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    //result of numerator / denominator
    public double toDouble() {
        return (double) numerator / denominator; //change type to double so that integer division won't happen
    }

    //Greatest Common Divisor
    private static int gcd(int num, int den) {
        if (den == 0) {
            return num;
        }
        return gcd(den, num % den);
    }

    //Lowest Common Multiple
    private static int lcm(int den1, int den2) {
        int numGCD = gcd(den1, den2);
        return (den1 * den2) / numGCD;
    }

    public Fraction add(Fraction other) {
        int fracDenominator = lcm(this.denominator, other.denominator);
        int fracNumerator = ((fracDenominator / this.denominator) * this.numerator) + ((fracDenominator / other.denominator) * other.numerator);
        Fraction result = new Fraction(fracNumerator, fracDenominator);
        return result;
    }


    public Fraction subtract(Fraction other) {
        int fracDenominator = lcm(this.denominator, other.denominator);
        int fracNumerator = ((fracDenominator / this.denominator) * this.numerator) - ((fracDenominator / other.denominator) * other.numerator);
        Fraction result = new Fraction(fracNumerator, fracDenominator);
        return result;
    }


    public Fraction multiply(Fraction other) {
        int fracNumerator = this.numerator * other.numerator;
        int fracDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(fracNumerator, fracDenominator);
        return result;
    }


    public Fraction divide(Fraction other) {
        if (other.denominator == 0) { //check 4 zero
            throw new IllegalArgumentException(Integer.toString(denominator));
        }
        int fracNumerator = this.numerator * other.denominator;
        int fracDenominator = this.denominator * other.numerator;
        Fraction result = new Fraction(fracNumerator, fracDenominator);
        return result;
    }

    //lower terms
    public void toLowestTerms() {
        int numGCD = gcd(this.numerator, this.denominator);
        this.numerator /= numGCD;
        this.denominator /= numGCD;
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }
}
