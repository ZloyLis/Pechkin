package services_file.alphabets;

import java.util.Scanner;

public class SelectLanguage {

    private static char[] alphabetLanguage;

    public static char[] getAlphabetLanguage() {
        return alphabetLanguage;
    }

    public static void setAlphabetLanguage() {
     selectAlphabet();
    }

    // выбираем алфавит, комбинируя основные алфавиты с символами
    private static void selectAlphabet() {
        System.out.println("""
                * Выберите язык чтения/шифрования:
                1) Русский язык
                2) Английский язык
                """);
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        try {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> alphabetLanguage = combineAlphabet(RuAlphabet.getRuAlphabet(), OtherSymbols.getOtherSymbols());
                case 2 -> alphabetLanguage = combineAlphabet(EnAlphabet.getEnAlphabet(), OtherSymbols.getOtherSymbols());
                default -> throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА! Введите номер из списка!");
            selectAlphabet();
        }
    }

    private static char[] combineAlphabet(char[] firstAlphabets, char[] secondAlphabets){
        char[] alphabet = new char[firstAlphabets.length + secondAlphabets.length];
        int count = 0;

        for (char firstAlphabet : firstAlphabets) {
            alphabet[count++] = firstAlphabet;

        }
        for (char secondAlphabet : secondAlphabets) {
            alphabet[count++] = secondAlphabet;
        }

        return alphabet;
    }
}
