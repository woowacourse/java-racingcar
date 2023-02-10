package utils;

import java.util.Scanner;

public class ScannerUtil {
    public static String readLine() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static int readNumber() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
