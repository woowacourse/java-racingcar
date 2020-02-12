package racingGame;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public static void validateInput(String name) {
        if(name == null || name.isEmpty() || name.length() > 5){
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
        }
    }

    public static List<String> splitInput(String value) {
        String[] names = value.split(",");
        return Arrays.asList(names);
    }

    public static void validateInputList(List<String> values) {
        values.stream().forEach((x)->validateInput(x));
    }
}
