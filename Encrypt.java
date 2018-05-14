package ru.vkd.one;

import java.io.*;
import java.util.Scanner;

/**
 * Класс Encrypt предназначен для шфрования текстового файла
 * В качевстве входных данных принимается путь к файлу с расщирение .txt который нужно зашифровать и путь к файлу в который будет записан зашифрованный текст.
 * конечный результат зашифрованный файл с расширением .txt
 */
public class Encrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "";
        char[] chars;
        StringBuilder test2;

        String fileDirect;
        System.out.print("путь к файлу для шифрования - ");
        fileDirect = sc.nextLine();

        String encryptFile;
        System.out.print("куда зашифровать ? - ");
        encryptFile = sc.nextLine();

        try(BufferedReader read  = new BufferedReader(new FileReader(fileDirect)); BufferedWriter write = new BufferedWriter(new FileWriter(encryptFile))) {
            while ( (str = read.readLine()) != null  ){
                chars = str.toCharArray();
                test2 = new StringBuilder();
                for ( byte g = 0 ; chars.length > g ; g++ ){
                    chars[g] = (char) (chars[g] - 2);
                    test2.append(chars[g]);
                }
                write.write(String.valueOf(test2+"\n"));
                System.out.println(test2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


