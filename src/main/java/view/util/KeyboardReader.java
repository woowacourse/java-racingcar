package view.util;

import java.util.Scanner;

public class KeyboardReader {

    // TODO 지금과 같은 환경이 아니라 멀티스레드(?) 등의 환경이면 스캐너를 static 변수로 저장해두고 쓰는 게 어떤 영향을 끼치는지?
    private static final Scanner scanner = new Scanner(System.in);

    private KeyboardReader() {
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력받은 값이 숫자가 아닙니다.");
        }
    }

    public static int readNaturalNumber() {
        int readValue = readInt();
        if (readValue <= 0) {
            throw new IllegalArgumentException("입력받은 값이 자연수가 아닙니다.");
        }
        return readValue;
    }
}
