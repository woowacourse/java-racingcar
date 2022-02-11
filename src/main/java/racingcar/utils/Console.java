package racingcar.utils;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    private Console() {

    }

    private static Scanner getInstance() {
        if(Objects.isNull(scanner) || isClosed()) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    private static boolean isClosed() {
        try {
            System.err.close();
            Field sourceClosed = Scanner.class.getDeclaredField("sourceClosed");
            sourceClosed.setAccessible(true);
            return sourceClosed.getBoolean(scanner);
        } catch (Exception e) {
        }
        return true;
    }

}
