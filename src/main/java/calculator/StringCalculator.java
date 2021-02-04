package calculator;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {

    public int stringSum(String str) {
        if (str == null) {
            return 0;
        }
        String separatorRegex = getSeparatorRegex(str);

        if (isCustomSeparatorExists(str)) {
            str = str.substring(4);
        }

        String[] numbers = str.split(separatorRegex);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isCustomSeparatorExists(String str) {
        return str.startsWith("//") && str.charAt(3) == '\n';
    }

    private String getSeparatorRegex(String str) {
        Optional<String> customSeparator = getCustomSeparator(str);

        String separatorRegex = "[,:%s]";

        if (!customSeparator.isPresent()) {
            // 커스텀 구분자 없음
            return String.format(separatorRegex, "");
        }

        return String.format(separatorRegex, customSeparator.get());
    }

    private Optional<String> getCustomSeparator(String str) {
        if (isCustomSeparatorExists(str)) {
            return Optional.of(str.substring(2, 3));
        }
        return Optional.empty();
    }
}
