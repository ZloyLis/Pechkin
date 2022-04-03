package com.zloylis.cryptors;

import com.zloylis.service.Algorithms;
import com.zloylis.service.alphabets.RuAlphabet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BruteForce {
    private static int key; // шаг сдвига
    private static String pathReadFile; // путь к файлу для чтения
    private static String pathWriteFile; // путь к файлу для записи
    private static boolean registerLetters; // флаг игнорирования заглавных букв
    private static Algorithms algorithms;
    static int index = 0;
    static int newIndex = 0;

    private static void bruteForce() {
        for (int bKey = 0; bKey < RuAlphabet.getRuAlphabet().length; bKey++) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resources/crypt_files/Encrypt"));
                 FileWriter fileWriter = new FileWriter("src/resources/crypt_files/Decrypt", true)) {

                while (bufferedReader.ready()) {
                    char c = (char) bufferedReader.read();
                    if (c == '\r') {
                        continue;
                    } else {
                        for (int i = 0; i < RuAlphabet.getRuAlphabet().length; i++) {
                            //подключаю нужный алфавит
                            if (c == RuAlphabet.getRuAlphabet()[i]) {
                                index = i;
                                break;
                            }
                        }
                    }
                    newIndex = (RuAlphabet.getRuAlphabet().length - bKey + index) % RuAlphabet.getRuAlphabet().length;
                    String str = String.valueOf(RuAlphabet.getRuAlphabet()[newIndex]);
                    fileWriter.append(str.toLowerCase());


                }
                fileWriter.append('\n');
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
    public static void main(String[] args) {
        bruteForce();
    }

}

