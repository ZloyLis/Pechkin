package com.zloylis.service.alphabets;

import java.util.ArrayList;
import java.util.List;

public class OtherSymbols {

    private static final List<Character> otherAlphabet = new ArrayList<>();

    private static void createOtherSymbols() {
        otherAlphabet.add('\n');
        otherAlphabet.add('\r');
        otherAlphabet.add('\u00AB');
        otherAlphabet.add('\u00BB');
        otherAlphabet.add('\u2116');
        otherAlphabet.add('\u00D7');
        otherAlphabet.add('\u00F7');
        for (char c = '\u0080'; c <= '\u00Bf'; c++) {
            otherAlphabet.add(c);
        }
        for (char c = '\u0020'; c <= '\u002f'; c++) {
            otherAlphabet.add(c);
        }

        for (char c = '\u003a'; c <= '\u0040'; c++) {
            otherAlphabet.add(c);
        }

        for (char c = '\u005b'; c <= '\u0060'; c++) {
            otherAlphabet.add(c);
        }

        for (char c = '\u007b'; c <= '\u007e'; c++) {
            otherAlphabet.add(c);
        }

        for (char c = '\u0030'; c <= '\u0039'; c++) {
            otherAlphabet.add(c);
        }
    }

    public static List<Character> getOtherAlphabet() {
        createOtherSymbols();
        return otherAlphabet;
    }
}
