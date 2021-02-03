package calculator;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {

    public int stringSum(String str) {
        Optional<Character> customSeparator = getCustomSeparator(str);
        if (!customSeparator.equals(Optional.empty())) {
            str = str.substring(4);
        }

        // 커스텀 구분자 null
        if (!customSeparator.isPresent()) {
            return 0;
        }

        String separatorRegex = "[" + "," + ":" + customSeparator.get() + "]";
        String[] numbers = str.split(separatorRegex);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private Optional<Character> getCustomSeparator(String str) {
        if (str.charAt(0) == '/') {
            return Optional.of(str.charAt(2));
        }
        return Optional.empty();
    }
}
