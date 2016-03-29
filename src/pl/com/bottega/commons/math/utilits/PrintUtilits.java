package pl.com.bottega.commons.math.utilits;

import pl.com.bottega.commons.math.model.Fraction;

import static pl.com.bottega.commons.math.utilits.MathUtilits.getSymbolCount;
import static pl.com.bottega.commons.math.utilits.StringUtilits.buildSymbolLine;


/**
 * Sergej Povzaniuk
 * 2016-03-28.
 */
public class PrintUtilits {

    static String fractionWithoutChanges(Fraction fraction) {
        return getFractionBody(fraction.getNominator(), fraction.getDenominator());
    }

    static String fractionWithWholePart(Fraction fraction) {
        return getFraction(fraction.getWholePartOfFraction(), fraction.getNominatorWithoutWholePart(), fraction.getDenominator());
    }

    static String simplifiedFractionWithWholePart(Fraction fraction) {
        return getFraction(fraction.getWholePartOfFraction(), fraction.getSimplifiedNominator(), fraction.getSimplifiedDenominator());
    }

    private static String getFraction(int wholePart, int nominator, int denominator) {
        if (nominator == 0) {
            return wholePart + ".0";
        } else if (wholePart == 0) {
            return getFractionBody(nominator, denominator);
        } else {
            return getFractionBody(wholePart, nominator, denominator);
        }
    }

    private static String getFractionBody(int nominator, int denominator) {

        int nominatorLong = getSymbolCount(nominator);
        int denominatorLong = getSymbolCount(denominator);

        StringBuilder s = new StringBuilder();
        if (nominatorLong > denominatorLong) {
            s.append(nominator).append("\n");
            s.append(buildSymbolLine(nominatorLong, "-")).append("\n");
            s.append(buildSymbolLine(nominatorLong - denominatorLong, " ")).append(denominator);
        } else {
            s.append(buildSymbolLine(denominatorLong - nominatorLong, " ")).append(nominator).append("\n");
            s.append(buildSymbolLine(denominatorLong, "-")).append("\n");
            s.append(denominator);
        }
        return s.toString();

    }

    private static String getFractionBody(int wholePart, int nominator, int denominator) {

        StringBuilder s = new StringBuilder();

        int countSymbolWholePart = getSymbolCount(wholePart);
        int nominatorLong = getSymbolCount(nominator);
        int denominatorLong = getSymbolCount(denominator);

        s.append(buildSymbolLine(countSymbolWholePart + 1, " ")).append(buildSymbolLine(denominatorLong - nominatorLong, " ")).append(nominator).append("\n");
        s.append(wholePart).append(" ").append(buildSymbolLine(denominatorLong, "-")).append("\n");
        s.append(buildSymbolLine(countSymbolWholePart + 1, " ")).append(denominator);

        return s.toString();
    }
}
