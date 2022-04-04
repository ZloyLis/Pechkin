package cryptors;

import services_file.Algorithms;
import services_file.alphabets.SelectLanguage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CaesarCoder {

    private static int key = 0;
    private static String pathReadFile = "";
    private static String pathWriteFile = "";
    private static boolean isRegister = true;
    private static Algorithms type = Algorithms.CAESAR_CODER;

    private static void caesarCoder(Algorithms type, int key, String pathReadFile, String pathWriteFile, boolean isRegister){

        int newIndex = 0;
        int index = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathReadFile));
             FileWriter fileWriter = new FileWriter(pathWriteFile)){

            while (bufferedReader.ready()){

                char c = (char) bufferedReader.read();
                if(c == '\r'){
                    continue;
                } else {
                    for (int i = 0; i < SelectLanguage.getAlphabetLanguage().length; i++) {
                        if(c == SelectLanguage.getAlphabetLanguage()[i]){
                            index = i;
                            break;
                        }
                    }
                }

                if(type == Algorithms.CAESAR_CODER){
                    newIndex = (SelectLanguage.getAlphabetLanguage().length + key + index) % SelectLanguage.getAlphabetLanguage().length;
                } else  if( type == Algorithms.CAESAR_DECODER){
                    newIndex = (SelectLanguage.getAlphabetLanguage().length - key + index) % SelectLanguage.getAlphabetLanguage().length;
                }

                String str = String.valueOf(SelectLanguage.getAlphabetLanguage()[newIndex]);
                if(!isRegister){
                    fileWriter.append(str.toLowerCase());
                } else {
                    fileWriter.append(str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //** Service area **//
    public CaesarCoder() {
    }

    //****//

    public static void setKey() {
        System.out.println("* Введите ключ:");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        try {
            CaesarCoder CaesarCodec;
            CaesarCoder.key = Integer.parseInt(scanner.nextLine());
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
                CaesarCoder.pathWriteFile = String.valueOf(path);
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
                CaesarCoder.pathReadFile = String.valueOf(path);
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
        return CaesarCoder.isRegister = answer;
    }

    public static Algorithms type() {
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
                case 1 -> algorithms = Algorithms.CAESAR_CODER;
                case 2 -> algorithms = Algorithms.CAESAR_DECODER;
                /*case 3 -> algorithms = Algorithms.BRUTEFORCE;*/
                default -> throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА! Выберите номер из списка!");
            System.out.println("---");
            type();

        }
        return CaesarCoder.type = algorithms;
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

    public static void caesarCoder(Algorithms type) {
        //algorithms(); // отключено, применено принудительное включение.
        setKey();
        setPathReadFile();
        setPathWriteFile();
        SelectLanguage.setAlphabetLanguage();
        caesarCoder(type, getKey(), getPathReadFile(), getPathWriteFile(), isRegisterLetters());
    }

 /*public static void bruteForce(Algorithms type, int key) {
        //algorithms(); // отключено, применено принудительное включение.
        setPathReadFile();
        setPathWriteFile();
        SelectAlphabet.setAlphabetLanguage();
        bruteForce(type, getKey(), isRegisterLetters(), getPathReadFile(), getPathWriteFile());
    }*/

}
