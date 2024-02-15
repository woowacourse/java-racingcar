package view;

import java.util.function.Supplier;

public class IterativeReader {

    public static <T> T readUntilNoError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
