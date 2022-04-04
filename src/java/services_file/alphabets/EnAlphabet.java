package services_file.alphabets;

import java.util.ArrayList;
import java.util.List;

public class EnAlphabet {
    private static final List<Character> alphabet = new ArrayList<>();
    private static final char[] enAlphabet = enAlphabetChar();

    //генерируем английский алфавит
    private static void createEnAlphabet() {
        for (char c = '\u0041'; c <= '\u005a'; c++) {
            alphabet.add(c);
        }
        for (char c = '\u0061'; c <= '\u007a'; c++) {
            alphabet.add(c);
        }
    }

    // перегоняем английский алфавит в массив char'ов
    private static char[] enAlphabetChar() {
        createEnAlphabet();
        char[] enAlphabetChar = new char[alphabet.size()];
        for (int i = 0; i < alphabet.size(); i++) {
            enAlphabetChar[i] = alphabet.get(i);
        }
        return enAlphabetChar;
    }

    // получаем английский алфавит
    public static char[] getEnAlphabet() {
        return enAlphabet;
    }
}
