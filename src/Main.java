

import java.util.Scanner;





public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int length = 0;

        while (true) {
            System.out.print("Введите длину пароля (должно быть целым числом): ");
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length >= 10000 && length <= 1000000) {
                    break;
                } else {
                    System.out.println("Длина пароля должна быть целым числом от 10000 до 1000000.");
                }
            } else {
                System.out.println("Ошибка: введите целое число от 10000 до 1000000.");
            }
            scanner.next();
        }






        System.out.print("Выберите язык (русский / английский / оба): ");
        String language = scanner.next().toLowerCase();

        System.out.print("Введите да/yes, если генератор будет использовать строчные буквы: ");
        String useLowercase = scanner.next().toLowerCase();

        System.out.print("Введите да/yes, если генератор будет использовать прописные буквы: ");
        String useUppercase = scanner.next().toLowerCase();

        System.out.print("Введите да/yes, если генератор будет использовать цифры: ");
        String useDigits = scanner.next().toLowerCase();

        System.out.print("Введите да/yes, если генератор будет использовать специальные символы: ");
        String useSpecialChars = scanner.next().toLowerCase();


        String characterSet = CharacterSetBuilder.buildCharacterSet(useLowercase, useUppercase, useDigits, useSpecialChars, language);


        PasswordGenerator passwordGenerator = new PasswordGenerator();
        long startTime = System.nanoTime();
        String password = passwordGenerator.generatePassword(length, characterSet);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        String strength = passwordGenerator.getPasswordStrength(length, useLowercase, useUppercase, useDigits, useSpecialChars);

        System.out.printf("Сгенерированный пароль: %s%n", password);
        System.out.printf("Уровень сложности пароля: %s%n", strength);
        System.out.printf("Время генерации пароля длиной %d: %.2f ms%n", length, duration / 1_000_000.0);

        scanner.close();
    }
}
