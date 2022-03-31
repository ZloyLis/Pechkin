package com.zloylis.cryptors;

import com.zloylis.service.Alphabets.RuAlphabet;

import java.io.*;


public class CaesarCipher {
    private static String pathWriteFile = "src/resources/FileForCrypt";
    private static String pathReadFile = "src/resources/FromStirlitz";
    private static int keyValue = 4;
    private static int blockSize;
    private static boolean toLowercase = false;
    private static int index = 0;
    private static int t = RuAlphabet.getRuAlphabet().length;


    private static void CaesarCoder() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathReadFile));
             FileWriter fileWriter = new FileWriter(pathWriteFile)) {


            while (bufferedReader.ready()) {
                char c = (char) bufferedReader.read();
                for (int i = 0; i < t; i++) {
                    if (c == RuAlphabet.getRuAlphabet()[i]) {
                        index = i;
                        break;
                    }
                }
                int newIndex = (t + keyValue + index) % t;
                String str = String.valueOf(RuAlphabet.getRuAlphabet()[newIndex]);
                fileWriter.append(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void CaesarDecoder() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathWriteFile));
             FileWriter fileWriter = new FileWriter("src/resources/decodeFile")) {
            while (bufferedReader.ready()) {
                char c = (char) bufferedReader.read();
                for (int i = 0; i < t; i++) {
                    if (c == RuAlphabet.getRuAlphabet()[i]) {
                        index = i;
                        break;
                    }
                }
                int newIndex = (t - keyValue + index) % t;
                String str = String.valueOf(RuAlphabet.getRuAlphabet()[newIndex]);
                fileWriter.append(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CaesarCoder();
        CaesarDecoder();
    }
}
