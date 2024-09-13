/**
 * A class that represents a rational number in normal form where the numerator
 * and the denominator share no common factors and only the numerator
 * can be negative.
 * 
 * @author Charles Hoot 
 * @version 4.0
*/

public class Rational
{
    // PUT PRIVATE DATA FIELDS HERE

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    private int num;
    private int den;


    public Rational()
    {       
        num=1;
        den=1;
        
        // ADD CODE TO THE CONSTRUCTOR
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     * @throws ZeroDenominatorException 
     */    
    public Rational(int n, int d) throws ZeroDenominatorException
    {

        if (d==0)
        {
            throw new ZeroDenominatorException("invalid");
        }

        if (d < 0) {
            n = -n;
            d = -d;
        }

        if (n<=0){
            num = n;
            den = d;
            num/=gcd(-n, d);
            den/=gcd(-n, d);
            return;
        }

        num = n;
        den = d;

        num /= gcd(n, d);
        den /= gcd(n,d);
            // ADD CODE TO THE ALTERNATE CONSTRUCTOR
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return num;
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return den;
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate() throws ZeroDenominatorException
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        Rational r = new Rational(-num,den);
        return r;
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     * @throws ZeroDenominatorException 
     */    
    public Rational invert() throws ZeroDenominatorException
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        Rational r = new Rational(den,num);
        if (r.den<=0)
        {
            r.den *= -1;
            r.num *= -1;
        }
        return r;
    }





    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other) throws ZeroDenominatorException
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
        Rational r = new Rational(this.num*other.den+other.num*this.den, den * other.den);
        if (r.num<=0) {
            int gcd = gcd(-r.num,r.den);
            r.num/=gcd;
            r.den/=gcd;
            return r;
        }
        int gcd = gcd(r.num,r.den);
        r.num/=gcd;
        r.den/=gcd;
        return r;
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other) throws ZeroDenominatorException
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        Rational r = this.add(other.negate());
        return r;
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other) throws ZeroDenominatorException
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
        Rational r = new Rational(this.num*other.num, other.den*this.den);
        if (r.num<=0) {
            int gcd = gcd(-r.num,r.den);
            r.num/=gcd;
            r.den/=gcd;
            return r;
        }
        int gcd = gcd(r.num,r.den);
        r.num/=gcd;
        r.den/=gcd;
        return r;
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other)
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return this.multiply(other.invert());
        
    }
     
      
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * can be negative.
     *
     */
    private void normalize()
    {
        // ADD CODE TO NORMALIZE THE RATIONAL NUMBER
        if (this.num<=0) {
            int gcd = gcd(-this.num,this.den);
            this.num/=gcd;
            this.den/=gcd;
            return;
        }
        int gcd = gcd(this.num,this.den);
        this.num/=gcd;
        this.den/=gcd;
    }
    
    /**
     * Recursively compute the greatest common divisor of two *positive* integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   
    
    
}
