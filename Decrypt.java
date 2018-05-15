package ru.vkd.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс Decrypt предназначен для расшифровки текстового файла с расширением .txt зашифрованного шифром Цезаря
 * В качевстве входных данных принимается путь к зашифрованному файлу и максимальное количевство сдвигов
 * конечный результат выведенный в консоль текст со сдвигом
 */
public class Decrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "";
        char[] chars;
        StringBuilder test2;
        int h =0;

        String encryptFile;
        System.out.println("Введите путь к файлу - ");
        encryptFile = sc.nextLine();

        int repeat;
        System.out.print("Введите максимальное количевство сдвигов - ");

        while ( ( repeat = sc.nextInt() ) < 0 ){
            System.out.println("Макисмальное количевство сдвигов не может принимать отрицательное значение");
        }

        System.out.println("");

        while (h != repeat) {
            try (BufferedReader read = new BufferedReader(new FileReader(encryptFile))) {
                while ((str = read.readLine()) != null) {
                    chars = str.toCharArray();
                    test2 = new StringBuilder();
                    for (byte g = 0; g < chars.length; g++) {
                        chars[g] = (char) (chars[g] - h);
                        test2.append(chars[g]);
                    }
                    System.out.println(test2);
                }
                System.out.println("___________________________________________");
            } catch (IOException e) {
                e.printStackTrace();
            }
            h++;
        }
    }
}