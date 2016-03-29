package pl.com.bottega.commons.math.console_app;

import pl.com.bottega.commons.math.model.Fraction;

public class FractionTestConsoleApp {
    public static void main(String[] args) {
        Fraction f1;

        try {
            f1 = new Fraction("205/10");
        }
        catch(IllegalArgumentException ex){
            System.out.println("Złe dane wejściowe! " + ex.getMessage());
            return;
        }


        //Fraction sum = ONE.add(f1);

        //Fraction sum = f1.add(f2).add(Fraction.ONE).add(Fraction.ZERO);  ;//wzorzec projektowy: Value Object (immutability)


        System.out.println(f1.toString());
        System.out.println("======================================");
        System.out.println(f1.toString(1));//Fraction Without Changes
        System.out.println("======================================");
        System.out.println(f1.toString(2));//Fraction With Whole Part
        System.out.println("======================================");
        System.out.println(f1.toString(3));//Simplified Fraction With Whole Part
    }
}
