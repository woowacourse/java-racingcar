package racing;

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
}
