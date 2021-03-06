package pl.com.bottega.commons.math.model;

import static pl.com.bottega.commons.math.utilits.MathUtilits.getSymbolCount;
import static pl.com.bottega.commons.math.utilits.PrintFraction.print;

public class Fraction {

    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ZERO = new Fraction(0, 1);


    private final int nominator;
    private final int denominator;

    /**
     * Klasa modeluje ułamek
     *
     * @param nominator   licznik ułamka
     * @param denominator mianownik ułamka
     * @throws IllegalArgumentException gdy mianownik jest równy 0
     */
    public Fraction(int nominator, int denominator) throws IllegalArgumentException {
        if (denominator == 0)
            throw new IllegalArgumentException("Denominator can not be zero");

        this.nominator = nominator;
        this.denominator = denominator;
    }

    public Fraction(int nominator) {
        //this(nominator, 10);   //nie chcemy walidować (sprawdzać poprawność) liczby 10
        this.nominator = nominator;
        this.denominator = 10;
    }

    /**
     * @param literal ułamek w preprezentacji licznik/mianownik, np: 3/4
     */
    public Fraction(String literal) throws IllegalArgumentException {
        String[] parts = literal.split("/");
        if (parts.length != 2)
            throw new IllegalArgumentException("To nie jest ułamek");

        try {
            this.nominator = Integer.parseInt(parts[0]);
            this.denominator = Integer.parseInt(parts[1]);
            if (this.denominator == 0)
                throw new IllegalArgumentException("Zero w mianowniku jest niedozwolone");
        } catch (NumberFormatException ex) {//nie musimy przepakować tego, mozemy rzucić NFE
            throw new IllegalArgumentException("To nie jest ułamek", ex);
            //System.out.println("dskjbvakjsdbvjkhsdavb");
        }
    }

    public Fraction add(Fraction addend) {
        if (this.denominator == addend.denominator) {
            int nominatorSum = this.nominator + addend.nominator;
            return new Fraction(nominatorSum, this.denominator);
        } else {
            int thisNominator = this.nominator * addend.denominator;
            int addendNominator = addend.nominator * this.denominator;
            int commonDenominator = this.denominator * addend.denominator;

            return new Fraction(thisNominator + addendNominator,
                    commonDenominator);
        }
    }

    public Fraction reverseV2() throws IllegalStateException {
        if (this.nominator == 0)
            throw new IllegalStateException("Can not reverse zero");
        return new Fraction(this.denominator, this.nominator);
    }

    public Fraction reverse() throws IllegalStateException {
        try {
            return new Fraction(this.denominator, this.nominator);
        } catch (IllegalArgumentException ex) {
            throw new IllegalStateException("Zero can not be reserved", ex);
        }
    }

    public String toString() {
        return print(this);
    }

    public String toString(int flag) {
        return print(this, flag);
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNominator() {
        return nominator;
    }

    public int getWholePartOfFraction() {
        if (nominator == 0)
            return nominator;
        else
            return nominator / denominator;
    }

    private int getGreatestCommonDivisor() {
        if (nominator == 0) {
            return 1;
        } else {
            int[] ints = new int[30];
            ints[0] = denominator;
            ints[1] = nominator;
            int count = 0;
            do {
                ints[(count + 2)] = ints[count] % ints[(count + 1)];
                count++;
            } while (ints[(count + 1)] != 0);
            return ints[count];
        }
    }

    public int getNominatorLong() {
        return getSymbolCount(nominator);
    }

    public int getDenominatorLong() {
        return getSymbolCount(denominator);
    }

    public int getNominatorWithoutWholePart() {
        return (nominator - getWholePartOfFraction() * denominator);
    }

    public int getSimplifiedNominator() {
        return (nominator - getWholePartOfFraction() * denominator) / getGreatestCommonDivisor();
    }

    public int getSimplifiedDenominator() {
        return denominator / getGreatestCommonDivisor();
    }

}
