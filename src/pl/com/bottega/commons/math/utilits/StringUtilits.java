package pl.com.bottega.commons.math.utilits;

/**
 * Sergej Povzaniuk
 * 2016-03-29.
 */
public class StringUtilits {

    static String buildSymbolLine(int lenght, String symbol) {
        if (lenght == 0) {
            return "";
        } else {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < lenght; i++)
                s.append(symbol);
            return s.toString();
        }
    }

}
