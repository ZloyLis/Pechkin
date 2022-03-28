package com.zloylis.service;

import java.util.Map;
import java.util.Scanner;

public class ConsoleOut {
    /**
     * стартовый метод программы
     */
    public static void startPechkin() {
        Scanner scanner = new Scanner(System.in);

        // получаем имя пользователя операционной системы
        Map<String, String> map = System.getenv();
        String name = map.get("USERNAME");

        System.out.println("Личность подтверждена. Вход разрешён.");
        System.out.println("Добро пожаловать в систему, " + name + ".");

        scanner.close();
    }
}