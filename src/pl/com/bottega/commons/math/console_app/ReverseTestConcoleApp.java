package pl.com.bottega.commons.math.console_app;


import pl.com.bottega.commons.math.model.Fraction;


public class ReverseTestConcoleApp {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        Fraction f = new Fraction(a, b);


        try {
            Fraction fReversed = f.reverse();
            System.out.println("reversed " + fReversed);
        } catch (IllegalStateException ex) {
            System.out.println("Nie mogę odwrócić bo " + ex.getMessage());
        }

    }
}