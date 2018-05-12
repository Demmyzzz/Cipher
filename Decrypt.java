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

        String encryptFile;
        encryptFile = sc.nextLine();

        try(BufferedReader read = new BufferedReader(new FileReader(encryptFile))){
            while ( ( str = read.readLine() ) !=null ) {
                chars = str.toCharArray();
                test2 = new StringBuilder();
                for ( byte g = 0; g < chars.length; g++) {
                    chars[g] = (char) (chars[g] + 2);
                    test2.append(chars[g]);
                }
                System.out.println(test2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
