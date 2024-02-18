package racingcar.util;

import java.util.Scanner;
import java.util.function.Supplier;

public class ConsoleReader implements Supplier<String> {
    @Override
    public String get() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
