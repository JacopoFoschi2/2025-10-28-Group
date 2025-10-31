class ComplexNumber {
    private final double real;
    private final double imaginary;

    public ComplexNumber(final double real, final double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    public ComplexNumber plus(final ComplexNumber other) {
        return new ComplexNumber(this.getReal() + other.getReal() , this.getImaginary() + other.getImaginary());
    }

    public ComplexNumber sub(final ComplexNumber other) {
        return new ComplexNumber(this.getReal() - other.getReal() , this.getImaginary() - other.getImaginary());
    }

    public ComplexNumber times(final ComplexNumber other) {
        return new ComplexNumber( (this.getReal()*other.getReal()) - (this.getImaginary()*other.getImaginary()) , (this.getReal()* other.getImaginary()) + (this.getImaginary()* other.getReal()));
    }


    @Override
    public String toString(){
        return  this.real + " + " + this.imaginary;
    }

    public ComplexNumber div(final ComplexNumber other) {
        final double commonDenominator = other.getReal() * other.getReal() + other.getImaginary() * other.getImaginary();
        final double realNumerator = this.getReal() * other.getReal() + this.getImaginary() * other.getImaginary();
        final double imaginaryNumerator = other.getReal() * this.getImaginary() - this.getReal() * other.getImaginary();
        return new ComplexNumber(realNumerator / commonDenominator, imaginaryNumerator / commonDenominator);
    }

    public static void main() {
        ComplexNumber number1 = new ComplexNumber(4, 8);
        ComplexNumber number2 = new ComplexNumber(7, 1);
        //Test for toString method
        System.out.println(number1.toString());
        //Test for sum
        ComplexNumber sum = number1.plus(number2);
        System.out.println(sum.toString()); //11+9i
        //Test for subtraction
        ComplexNumber sub = number1.sub(number2);
        System.out.println(sub.toString()); //-3+7i
        //Test for multiplication
        ComplexNumber mult = number1.times(number2);
        System.out.println(mult.toString()); //28+8i
        //Test for division
        ComplexNumber div = number1.div(number2);
        System.out.println(div.toString()); //0.72+1.04i

    }
}