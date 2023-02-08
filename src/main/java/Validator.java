import java.util.List;

public class Validator {

    private static boolean isCorrectLength(List<String> carNames) {
        return carNames.stream()
                .allMatch(carName -> 1 <= carName.length() && carName.length() <= 5);
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
