package racing;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import racing.view.OutputView;

public interface ExceptionHandlingTemplate {
    static <T, R> R repeatUntilSucceed(Function<T, R> object, Supplier<T> input) {
        while (true) {
            try {
                return object.apply(input.get());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    static <T, U, R> R repeatUntilSucceed(BiFunction<T, U, R> object, Supplier<T> first, Supplier<U> second) {
        while (true) {
            try {
                return object.apply(first.get(), second.get());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
