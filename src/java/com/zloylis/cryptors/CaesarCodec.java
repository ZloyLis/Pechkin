package com.zloylis.cryptors;

import com.zloylis.service.Algorithms;
import com.zloylis.service.alphabets.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static com.zloylis.service.Algorithms.*;

public class CaesarCodec {
    private static int key; // шаг сдвига
    private static String pathReadFile; // путь к файлу для чтения
    private static String pathWriteFile; // путь к файлу для записи
    private static boolean registerLetters; // флаг игнорирования заглавных букв
    private static Algorithms algorithms;
    private static char c;
    private static int index = 0;
    private static int newIndex = 0;


    private static void caesarCodec(Algorithms type, int key, boolean registerLetters, String pathReadFile, String pathWriteFile) {



        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathReadFile));
             FileWriter fileWriter = new FileWriter(pathWriteFile)) {

            while (bufferedReader.ready()) {
                c = (char) bufferedReader.read();
                if (c == '\r') {
                    continue;
                } else {
                    for (int i = 0; i < SelectAlphabet.getAlphabetLanguage().length; i++) {
                        //подключаю нужный алфавит
                        if (c == SelectAlphabet.getAlphabetLanguage()[i]) {
                            index = i;
                            break;
                        }
                    }
                }

                // кодируем или расшифровываем, зависит от флага
                if (type == ENCODE) {
                    newIndex = (SelectAlphabet.getAlphabetLanguage().length + key + index) % SelectAlphabet.getAlphabetLanguage().length;
                } else if (type == DECODE_FOR_KEY) {
                    newIndex = (SelectAlphabet.getAlphabetLanguage().length - key + index) % SelectAlphabet.getAlphabetLanguage().length;
                }
                String str = String.valueOf(SelectAlphabet.getAlphabetLanguage()[newIndex]);

                // если `toLowerCase = true` - всё пишем прописными буквами
                if (!registerLetters) {
                    fileWriter.append(str.toLowerCase());
                } else {
                    fileWriter.append(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bruteForce(Algorithms type, int key, boolean registerLetters, String pathReadFile, String pathWriteFile ) {
        for (int bKey = 0; bKey < SelectAlphabet.getAlphabetLanguage().length; bKey++) {
            key = bKey;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathReadFile));
             FileWriter fileWriter = new FileWriter(pathWriteFile)) {

                while (bufferedReader.ready()) {

                    c = (char) bufferedReader.read();
                    if (c == '\r') {
                        continue;
                    } else {
                        for (int i = 0; i < SelectAlphabet.getAlphabetLanguage().length; i++) {
                            //подключаю нужный алфавит
                            if (c == SelectAlphabet.getAlphabetLanguage()[i]) {
                                index = i;
                                break;
                            }
                        }
                    }
                    newIndex = (SelectAlphabet.getAlphabetLanguage().length - key + index) % SelectAlphabet.getAlphabetLanguage().length;
                    String str = String.valueOf(SelectAlphabet.getAlphabetLanguage()[newIndex]);

                    // если `toLowerCase = true` - всё пишем прописными буквами
                    if (!registerLetters) {
                        fileWriter.append(str.toLowerCase());
                    } else {
                        fileWriter.append(str);
                    }

                }

            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    public static void setKey() {
        System.out.println("* Введите ключ:");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        try {
            CaesarCodec.key = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Введите числовое значение!");
            System.out.println("---");
            setKey();
        }
    }

    public static void setPathWriteFile() {
        System.out.println("* Введите путь к файлу для записи:");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of(scanner.nextLine());
        try {
            if (Files.exists(path)) {
                CaesarCodec.pathWriteFile = String.valueOf(path);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ошибка пути или создания файла!");
            System.out.println("---");
            setPathWriteFile();
        }
    }

    public static void setPathReadFile() {
        System.out.println("* Введите путь к файлу для чтения:");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of(scanner.nextLine());
        try {
            if (Files.exists(path)) {
                CaesarCodec.pathReadFile = String.valueOf(path);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА! Файл не найден!");
            System.out.println("---");
            setPathReadFile();
        }
    }

    public static boolean isRegisterLetters() {
        System.out.println("""
                * Учитывать регистр?"
                1) Да
                2) Нет
                """);
        System.out.print("> ");


        boolean answer = true;
        Scanner scanner = new Scanner(System.in);
        try {
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1 -> answer = true;
                case 2 -> answer = false;
                default -> throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА! Выберите номер из списка!");
            System.out.println("---");
            isRegisterLetters();
        }
        return CaesarCodec.registerLetters = answer;
    }

    public static Algorithms algorithms() {
        System.out.println("""
                * Выберите тип операции:
                1) Шифрование
                2) Дешифровка
                """);
        System.out.println("> ");

        Algorithms algorithms = null;
        Scanner scanner = new Scanner(System.in);
        try {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> algorithms = ENCODE;
                case 2 -> algorithms = DECODE_FOR_KEY;
                case 3 -> algorithms = DECODE_BRUTEFORCE;
                default -> throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА! Выберите номер из списка!");
            System.out.println("---");
            algorithms();

        }
        return CaesarCodec.algorithms = algorithms;
    }


    public static String getPathWriteFile() {
        return pathWriteFile;
    }

    public static int getKey() {
        return key;
    }

    public static String getPathReadFile() {
        return pathReadFile;
    }

    public static void caesarCodec(Algorithms type) {
        //algorithms(); // отключено, применено принудительное включение.
        setKey();
        setPathReadFile();
        setPathWriteFile();
        SelectAlphabet.setAlphabetLanguage();
        caesarCodec(type, getKey(), isRegisterLetters(), getPathReadFile(), getPathWriteFile());
    }

    public static void bruteForce(Algorithms type, int key) {
        //algorithms(); // отключено, применено принудительное включение.
        setPathReadFile();
        setPathWriteFile();
        SelectAlphabet.setAlphabetLanguage();
        bruteForce(type, getKey(), isRegisterLetters(), getPathReadFile(), getPathWriteFile());
    }



    public static void main(String[] args) {
        SelectAlphabet.setAlphabetLanguage();
        System.out.println(Arrays.toString(SelectAlphabet.getAlphabetLanguage()));
    }
}
