package racingcar.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Repeat {

    private Repeat() {
    }

    public static <T> T repeatIfError(Supplier<T> result, Consumer<String> errorCallback) {
        try {
            return result.get();
        } catch (Exception e) {
            errorCallback.accept(e.getMessage());
            return repeatIfError(result, errorCallback);
        }
    }
}
