package utils;

import java.util.Scanner;

public class ScannerInputReader implements InputReader {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}
