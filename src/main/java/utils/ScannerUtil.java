package utils;

import java.util.Scanner;

public class ScannerUtil {
    public static String readLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int readNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
