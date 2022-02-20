public class Fraction {
    private int numer = 0;
    private int denom = 0;

    //2 parameter constructor
    public Fraction(int numerator, int denominator) {
        this.numer = numerator;
        if (denominator == 0) { //check 4 zero
            throw new IllegalArgumentException(Integer.toString(denominator));
        } else if(denominator < 0) {
            this.numer *= -1;
            this.denom = (-1) * denominator;
        } else {
            this.denom = denominator;
        }
    }
    //1 parameter constructor
    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public int getNumer(){
        return this.numer;
    }

    public int getDenom(){
        return this.denom;
    }

    // Greatest Common Divisor
    private static int gcd(int num, int den){
        if (den == 0) {
            return num;
        }
        return gcd(den, num % den);
    }

    //Lowest Common Multiple
    private static int lcm(int den1, int den2){
        int numGCD = gcd(den1, den2);
        return (den1 * den2)/ numGCD;
    }

    public Fraction add(Fraction other){
        int fracDenom = lcm(this.denom, other.denom);
        int fracNumer = ((fracDenom/ this.denom) * this.numer) + ((fracDenom/ other.denom) * other.numer);
        Fraction result = new Fraction(fracNumer, fracDenom);
        return result;
    }

    public Fraction subtract(Fraction other){
        int fracDenom = lcm(this.denom, other.denom);
        int fracNumer = ((fracDenom/ this.denom) * this.numer) - ((fracDenom/ other.denom) * other.numer);
        Fraction result = new Fraction(fracNumer, fracDenom);
        return result;
    }

    public Fraction multiply(Fraction other){
        int fracNumer =  this.numer * other.numer;
        int fracDenom = this.denom * other.denom;
        Fraction result = new Fraction(fracNumer, fracDenom);
        return result;
    }

    public Fraction divide(Fraction other){
        if(other.denom == 0){ //check 4 zero
            throw new IllegalArgumentException(Integer.toString(denom));
        }
        int fracNumer =  this.numer * other.denom;
        int fracDenom = this.denom * other.numer;
        Fraction result = new Fraction(fracNumer, fracDenom);
        return result;
    }

    public void toLowestTerms(){
        int numGCD = gcd(this.numer, this.denom);
        this.numer /= numGCD;
        this.denom /= numGCD;
        if(this.denom < 0) {
            this.numer *= -1;
            this.denom *= -1;
        }
    }
}