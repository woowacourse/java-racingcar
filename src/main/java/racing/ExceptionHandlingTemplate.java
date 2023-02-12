package racing;

import java.util.function.Function;
import java.util.function.Supplier;
import racing.view.OutputView;

public interface ExceptionHandlingTemplate {
    OutputView outputView  = new OutputView();
    static  <T, R> R repeatUntilSucceed(Function<T, R> object, Supplier<T> input) {
        while (true) {
            try {
                return object.apply(input.get());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
