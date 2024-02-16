package view;

import java.util.function.Supplier;

public class IterativeReader {

    // TODO: ErrorHandler로 대체하는 작업 진행하기
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
