package com.zloylis.service.Alphabets;

import java.util.ArrayList;
import java.util.List;

public class OtherAlphabet {
    private static final List<Character> alphabet = new ArrayList<>();

    public static List<Character> getAlphabet() {
        otherCharAlphabet();
        return alphabet;
    }

    protected static void otherCharAlphabet() {
        alphabet.add('\n');
        alphabet.add('«');
        alphabet.add('»');
        alphabet.add('№');
        for (char c = ' '; c <= '/'; c++) {
            alphabet.add(c);
        }

        for (char c = ':'; c <= '@'; c++) {
            alphabet.add(c);
        }

        for (char c = '['; c <= '`'; c++) {
            alphabet.add(c);
        }

        for (char c = '{'; c <= '~'; c++) {
            alphabet.add(c);
        }

        for (char c = '0'; c <= '9'; c++) {
            alphabet.add(c);
        }
    }
}