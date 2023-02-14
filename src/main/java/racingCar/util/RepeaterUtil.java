package racingCar.util;

import racingCar.view.OutputView;
import java.util.function.Supplier;

public class RepeaterUtil {

    public static <T> void run(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            run(runnable);
        }
    }

    public static <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
            return repeat(reader);
        }
    }
}
