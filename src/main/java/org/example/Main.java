package org.example;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод:");
        while (true){
            try {
                String input = scanner.nextLine();
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception exp) {
                System.out.println("Ошибка: " + exp.getMessage());
                break;
            }
        }
    }
    public static String calc(String input) {
        input = input.replaceAll("\\s+","");
        char operation = findOperator(input);
        String[] parts = input.split("\\" + operation);
        if (parts.length != 2) {
            throw new IllegalArgumentException("a операция b.");
        }
        int a = parseNumber(parts[0]);
        int b = parseNumber(parts[1]);
        int result = 0;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        return String.valueOf(result);
    }
    private static int parseNumber(String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 10) {
                throw new IllegalArgumentException("Введите чисто от 1 до 10.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Введите целое число.");
        }
    }

    private static char findOperator(String input) {
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                return c;
            }
        }
        throw new IllegalArgumentException("Неправильная операция.");
    }
}
