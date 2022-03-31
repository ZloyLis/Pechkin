package com.zloylis.service.Alphabets;

import java.util.ArrayList;
import java.util.List;

public class RuAlphabet {
    private static final List<Character> alphabet = new ArrayList<>();
    private static final char[] ruAlphabet = ruAlphabetChar();

    //генерируем русский алфавит
    private static void createAlphabet() {

        for (char c = 'А'; c <= 'я'; c++) {
            if (c == 'Е') {
                alphabet.add(c);
                alphabet.add('Ё');
            } else if (c == 'е') {
                alphabet.add(c);
                alphabet.add('ё');
            } else {
                alphabet.add(c);
            }
        }
        alphabet.addAll(OtherAlphabet.getAlphabet());
    }

    // перегоняем русский алфавит в массив char'ов
    private static char[] ruAlphabetChar() {
        createAlphabet();
        char[] ruAlphabetChar = new char[alphabet.size()];
        for (int i = 0; i < ruAlphabetChar.length; i++) {
            ruAlphabetChar[i] = alphabet.get(i);
        }
        return ruAlphabetChar;
    }

    //получаем
    public static char[] getRuAlphabet() {
        return ruAlphabet;
    }
}