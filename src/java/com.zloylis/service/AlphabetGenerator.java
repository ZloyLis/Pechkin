package com.zloylis.service;

import java.util.ArrayList;
import java.util.List;


public class AlphabetGenerator {

    private static List<Character> alphabet = new ArrayList<>();

    //генерируем русский алфавит
    private static void ruAlphabet() {
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
        otherCharAlphabet();
    }

    //генерируем английский алфавит
    private static void enAlphabet() {
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
        otherCharAlphabet();
    }

    //генерируем цифры, пунктуацию и прочие символы
    private static void otherCharAlphabet() {
        alphabet.add('«');
        alphabet.add('»');
        alphabet.add('№');
        alphabet.add('\n');

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

    /* ПУБЛИЧНЫЕ МЕТОДЫ */

    // получаем русский алфавит в массиве char'ов
    public static char[] getRuAlphabet() {
        ruAlphabet();
        int t = alphabet.size();
        char[] ruAlphabetChar = new char[t];
        for (int i = 0; i < t; i++) {
            ruAlphabetChar[i] = alphabet.get(i);
        }
        return ruAlphabetChar;
    }

    // получаем английский алфавит в массиве char'ов
    public static char[] getEnAlphabet() {
        enAlphabet();
        int t = alphabet.size();
        char[] enAlphabetChar = new char[t];
        for (int i = 0; i < t; i++) {
            enAlphabetChar[i] = alphabet.get(i);
        }
        return enAlphabetChar;
    }

    // очищаем сгенерированный алфавит
    public static void clearAlphabet() {
        alphabet.clear();
    }
}
