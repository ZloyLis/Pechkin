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
        System.out.print("Загрузка системы...");
        //pauseOut(1500);
        System.out.print("\r");

        System.out.print("Личность подтверждена...");
        //pauseOut(1500);
        System.out.print("\r");

        System.out.println("Добро пожаловать в систему, " + name + ".");
        //pauseOut(800);

        System.out.println();
        System.out.print("""               
                Выберите тип операции:
                1. Шифрование из консоли(в файл)
                2. Шифрование файла
                3. Дешифровка файла через ключ
                4. Дешифровка файла через BruteForce
                """);
        System.out.println();


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
                        CaesarCodec.caesarCodec(Algorithms.DECODE_BRUTEFORCE);
                    }

                    default -> throw new Exception();


                }
                scanner.nextLine();
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

