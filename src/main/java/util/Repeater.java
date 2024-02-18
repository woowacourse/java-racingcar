package util;

import java.util.function.Supplier;

public class Repeater {
    public static <T> T repeatUntilNoException(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
