package com.zloylis.service.alphabets;

import java.util.ArrayList;
import java.util.List;

public class RuAlphabet {

    private static final List<Character> alphabet = new ArrayList<>();
    private static final char[] ruAlphabet = ruAlphabetChar();

    //генерируем русский алфавит
    private static void createRuAlphabet() {
        for (char c = '\u0410'; c <= '\u044F'; c++) {
            if (c == '\u0415') {
                alphabet.add(c);
                alphabet.add('\u0401');
            } else if (c == '\u0435') {
                alphabet.add(c);
                alphabet.add('\u0451');
            } else {
                alphabet.add(c);
            }
        }
        alphabet.addAll(OtherSymbols.getOtherAlphabet());
    }

    // перегоняем русский алфавит в массив char'ов
    private static char[] ruAlphabetChar() {
        createRuAlphabet();
        char[] ruAlphabetChar = new char[alphabet.size()];
        for (int i = 0; i < ruAlphabetChar.length; i++) {
            ruAlphabetChar[i] = alphabet.get(i);
        }
        return ruAlphabetChar;
    }

    //получаем русский алфавит
    public static char[] getRuAlphabet() {
        return ruAlphabet;
    }

}
