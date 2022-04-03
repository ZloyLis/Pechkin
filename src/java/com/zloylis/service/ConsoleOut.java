package com.zloylis.service;

import com.zloylis.cryptors.CaesarCodec;

import java.util.Map;
import java.util.Scanner;


public class ConsoleOut {
    public static void startPechkin() {
        // получаем имя пользователя операционной системы
        Map<String, String> map = System.getenv();
        String name = map.get("USERNAME");

        // вывод в консоли
        String[] dot = {"▮▯▯▯▯▯", "▮▮▯▯▯▯", "▮▮▮▯▯▯", "▮▮▮▮▯▯", "▮▮▮▮▮▯", "▮▮▮▮▮▮"};
        for (String s : dot) {
            System.out.print("Загрузка системы " + s);
            pauseOut(500);
            System.out.print("\r");
        }
        pauseOut(500);

        System.out.println("Добро пожаловать в систему, " + name + ".");
        System.out.println();
        pauseOut(1000);

        System.out.println("Выберите операцию:");
        pauseOut(700);
        System.out.println("1. Шифрование из консоли(в файл):");
        pauseOut(200);
        System.out.println("2. Шифрование файла");
        pauseOut(200);
        System.out.println("3. Дешифровка файла через ключ");
        pauseOut(200);
        System.out.println("4. Дешифровка файла через BruteForce");
        pauseOut(200);
        System.out.println();
        pauseOut(200);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите номер операции:");
            System.out.print("> ");
            try {
                switch (Integer.parseInt(scanner.nextLine())) {

                    case 1 -> {
                        System.out.println("1");
                    }
                    case 2 -> {
                        System.out.println("---");
                        System.out.println("Операция: шифрование файла.");
                        CaesarCodec.caesarCodec(Algorithms.ENCODE);
                    }
                    case 3 -> {
                        System.out.println("---");
                        CaesarCodec.caesarCodec(Algorithms.DECODE_FOR_KEY);
                    }
                    case 4 -> {
                        System.out.println("---");
                        CaesarCodec.bruteForce(Algorithms.DECODE_BRUTEFORCE, 0);
                    }

                    default -> throw new Exception();


                }
            } catch (Exception e) {
                System.out.println("ОШИБКА! Введите числовое значение!");
            }
        }
    }


    private static void pauseOut(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

