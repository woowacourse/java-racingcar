import java.util.List;

public class Validator {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 5;

    private static boolean isCorrectLength(List<String> carNames) {
        return carNames.stream()
                .allMatch(carName -> LOWER_BOUND <= carName.length() && carName.length() <= UPPER_BOUND);
    }

    public static void carNameLength(List<String> carNames){
        if (!isCorrectLength(carNames)) {
            throw new IllegalArgumentException("자동차명은 1 ~ 5 글자로 입력해야합니다.");
        }
    }

    public static void numberOfTimesRange(int number){
        if (number <= 0) {
            throw new IllegalArgumentException("1 이상만 가능합니다.");
        }
    }
}
