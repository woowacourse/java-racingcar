package racingcar.utils;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;
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
        return !scanner.hasNext();
    }

}
