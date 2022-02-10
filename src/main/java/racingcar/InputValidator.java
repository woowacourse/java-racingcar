package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    //TO-DO 검증 나누기
    public void isValidPattern(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z,]*$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR]: 잘못된 입력입니다.(입력은 영어 소문자와 쉼표로만 이루어져있습니다.)");
        }
    }

    public void isValidLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR]: 잘못된 입력입니다.(입력은 5자 이하만 가능합니다.)");
            }
        }
    }

    public void isDuplicate(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        if (uniqueNames.size() != names.length) {
            throw new IllegalArgumentException("[ERROR]: 잘못된 입력입니다.(같은 이름의 자동차는 두번 사용할 수 없습니다.)");
        }
    }
}
