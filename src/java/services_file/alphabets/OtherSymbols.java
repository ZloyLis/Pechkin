package services_file.alphabets;

import java.util.ArrayList;
import java.util.List;

public class OtherSymbols {

    private static final List<Character> alphabet = new ArrayList<>();
    private static final char[] otherSymbols = otherSymbolsChar();

    private static void createOtherSymbols() {
        alphabet.add('\n');
        alphabet.add('\r');
        alphabet.add('\u00AB');
        alphabet.add('\u00BB');
        alphabet.add('\u2116');
        alphabet.add('\u00D7');
        alphabet.add('\u00F7');
        for (char c = '\u00A0'; c <= '\u00Bf'; c++) {
            alphabet.add(c);
        }
        for (char c = '\u0020'; c <= '\u002f'; c++) {
            alphabet.add(c);
        }

        for (char c = '\u003a'; c <= '\u0040'; c++) {
            alphabet.add(c);
        }

        for (char c = '\u005b'; c <= '\u0060'; c++) {
            alphabet.add(c);
        }

        for (char c = '\u007b'; c <= '\u007e'; c++) {
            alphabet.add(c);
        }

        for (char c = '\u0030'; c <= '\u0039'; c++) {
            alphabet.add(c);
        }
    }

    private static char[] otherSymbolsChar() {
        createOtherSymbols();
        char[] otherSymbolsChar = new char[alphabet.size()];
        for (int i = 0; i < alphabet.size(); i++) {
            otherSymbolsChar[i] = alphabet.get(i);
        }
        return otherSymbolsChar;
    }

    public static char[] getOtherSymbols() {
        createOtherSymbols();
        return otherSymbols;
    }
}
