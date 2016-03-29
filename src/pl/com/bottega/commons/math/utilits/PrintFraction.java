package pl.com.bottega.commons.math.utilits;

import pl.com.bottega.commons.math.model.Fraction;

import static pl.com.bottega.commons.math.utilits.PrintUtilits.fractionWithWholePart;
import static pl.com.bottega.commons.math.utilits.PrintUtilits.fractionWithoutChanges;
import static pl.com.bottega.commons.math.utilits.PrintUtilits.simplifiedFractionWithWholePart;

/**
 * Sergej Povzaniuk
 * 2016-03-28.
 */
public class PrintFraction {
    public static String print(Fraction fraction, int flag) {
        if (flag == 1)
            return fractionWithoutChanges(fraction);
        else if(flag == 2)
            return fractionWithWholePart(fraction);
        else if(flag == 3)
            return simplifiedFractionWithWholePart(fraction);
        else
            return fractionWithWholePart(fraction);
    }
    public static String print(Fraction fraction) {
        return print(fraction, 2);
    }
}
