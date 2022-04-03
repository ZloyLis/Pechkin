package com.zloylis.service.alphabets;

import java.util.Scanner;

public class SelectAlphabet {
    private static char[] alphabetLanguage = getAlphabetLanguage();

    public static char[] getAlphabetLanguage() {
        return alphabetLanguage;
    }

    public static void setAlphabetLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                * Выберите язык чтения/шифрования:
                1) Русский язык
                2) Английский язык
                """);
        System.out.print("> ");
        try {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> {
                    alphabetLanguage = RuAlphabet.getRuAlphabet();
                }
                case 2 -> alphabetLanguage = EnAlphabet.getEnAlphabet();
                default -> throw new Exception();
            } ;
        } catch (Exception e) {
            System.out.println("ОШИБКА! Введите номер из списка!");
        }

    }
}


