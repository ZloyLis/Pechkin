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
import java.util.regex.Pattern;

/*[+\S]{12,}*/
public class Bruteforce {

    private static String pathReadFile;
    private static String pathWriteFile;
    private static String pathControlFile;
    private static boolean isRegister;
    private static Algorithms type = Algorithms.BRUTEFORCE;
    private static char []alphabet;

    private static void bruteForce(String pathReadFile, String pathWriteFile){

        int index = 0;
        int newIndex = 0;

        for (int bKey = 0; bKey < SelectLanguage.getAlphabetLanguage().length; bKey++) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathReadFile));
                 FileWriter fileWriter = new FileWriter(pathWriteFile, true)) {

                while (bufferedReader.ready()) {
                    char c = (char) bufferedReader.read();
                    if (c == '\r') {
                        continue;
                    } else {
                        for (int i = 0; i < SelectLanguage.getAlphabetLanguage().length; i++) {
                            if (c == SelectLanguage.getAlphabetLanguage()[i]) {
                                index = i;
                                break;
                            }
                        }
                    }

                    newIndex = (SelectLanguage.getAlphabetLanguage().length - bKey + index) % SelectLanguage.getAlphabetLanguage().length;
                    String str = String.valueOf(SelectLanguage.getAlphabetLanguage()[newIndex]);
                    boolean pattern = Pattern.matches("[^\\w]{3,}", str);
                    if (!pattern) {
                        fileWriter.append(str.toLowerCase());
                    } else {
                        break;
                    }


                }
                fileWriter.append('\n').append(String.valueOf(SelectLanguage.getAlphabetLanguage()[bKey])).append(") ");
            } catch(IOException e){
                e.printStackTrace();
            }
        }

    }


    public static void bruteForce(){
        SelectLanguage.setAlphabetLanguage();
        setPathReadFile();
        setPathWriteFile();
        Bruteforce.bruteForce(getPathReadFile(), getPathWriteFile());
    }

    public static void setPathWriteFile() {
        System.out.println("* Введите путь к файлу для записи:");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of(scanner.nextLine());
        try {
            if (Files.exists(path)) {
                Bruteforce.pathWriteFile = String.valueOf(path);
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
                Bruteforce.pathReadFile = String.valueOf(path);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА! Файл не найден!");
            System.out.println("---");
            setPathReadFile();
        }
    }

    public static String getPathReadFile() {
        return pathReadFile;
    }

    public static String getPathWriteFile() {
        return pathWriteFile;
    }

    public static String getPathControlFile() {
        return pathControlFile;
    }

    public static boolean isIsRegister() {
        return isRegister;
    }

    public static Algorithms getType() {
        return type;
    }

    public static char[] getAlphabet() {
        return alphabet;
    }

    public static void setPathReadFile(String pathReadFile) {
        Bruteforce.pathReadFile = pathReadFile;
    }

    public static void setPathWriteFile(String pathWriteFile) {
        Bruteforce.pathWriteFile = pathWriteFile;
    }

    public static void setPathControlFile(String pathControlFile) {
        Bruteforce.pathControlFile = pathControlFile;
    }

    public static void setIsRegister(boolean isRegister) {
        Bruteforce.isRegister = isRegister;
    }

    public static void setType(Algorithms type) {
        Bruteforce.type = type;
    }

    public static void setAlphabet(char[] alphabet) {
        Bruteforce.alphabet = alphabet;
    }
}
