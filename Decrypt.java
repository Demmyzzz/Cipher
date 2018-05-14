package ru.vkd.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "";
        char[] chars;
        StringBuilder test2;
        int h =0;
        int repeat;

        String encryptFile;
        System.out.println("Введите путь к файлу - ");
        encryptFile = sc.nextLine();

        System.out.print("Введите максимальное количевство сдвигов - ");
        repeat = sc.nextInt();

        System.out.println("");

        while (h != repeat) {
            h++;
            try (BufferedReader read = new BufferedReader(new FileReader(encryptFile))) {
                while ((str = read.readLine()) != null) {
                    chars = str.toCharArray();
                    test2 = new StringBuilder();
                    for (byte g = 0; g < chars.length; g++) {
                        chars[g] = (char) (chars[g] + h);
                        test2.append(chars[g]);
                    }
                    System.out.println(test2);

                }

                System.out.println("___________________________________________");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}