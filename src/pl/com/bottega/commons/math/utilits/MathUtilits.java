package pl.com.bottega.commons.math.utilits;

/**
 * Sergej Povzaniuk
 * 2016-03-28.
 */
public class MathUtilits {

    private static int getAbsValueOfNumber(int Number) {
        return Math.abs(Number);
    }

    static int getLongOfNumberByString(int Number) {
        return (Integer.toString(getAbsValueOfNumber(Number))).length();
    }

    static int getLongOfNumberByLoop(int Number) {
        Number = getAbsValueOfNumber(Number);
        int count = (Number == 0) ? 1 : 0;
        while (Number != 0) {
            count++;
            Number *= 0.1;
        }
        return count;
    }

    static int getLongOfNumberByLog(int Number) {
        Number = getAbsValueOfNumber(Number);
        return (Number == 0) ? 1 : (int) Math.ceil(Math.log10(Number + 0.5));
    }

    public static int getSymbolCount(int Number) {
        Number = getAbsValueOfNumber(Number);
        int count = 0;
        if (Number < 10 || Number == 0) {
            count = 1;
        } else if (Number < 100) {
            count = 2;
        } else if (Number < 1000) {
            count = 3;
        } else if (Number < 10000) {
            count = 4;
        } else if (Number < 100000) {
            count = 5;
        } else if (Number < 1000000) {
            count = 6;
        } else if (Number < 10000000) {
            count = 7;
        } else if (Number < 100000000) {
            count = 8;
        } else if (Number < 2147483647) {
            count = 9;
        }
        return count;
    }

}
