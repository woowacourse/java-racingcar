package racinggame.domain.data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {
    private String names;

    private static final String LENGTH_ERROR_MESSAGE = "이름의 길이는 1자 이상, 5자 이하만 가능합니다.";
    private static final String SPLIT_DELIMITER = ",";

    /**
     * 생성자 메서드의 파라미터로 이름목록과 횟수가 전달될 경우,
     * 이를 Input 인스턴스의 필드값으로 옮겨 저장한다.
     * 이후 데이터에 대한 예외처리를 수행하여,
     * 만약 올바르지 않은 값임이 확인된다면 예외를 발생시킨다.
     *
     * @param inputName   이름의 목록을 저장하는 String 값이다.
     * @param inputRepeat 횟수를 저장하는 String 값이다.
     */
    public Names(String inputName) {
        this.names = inputName;
        validateNames();
    }

    public List<String> splitNamesByComma() {
        String[] splitName = names.split(SPLIT_DELIMITER);
        return Arrays.asList(splitName);
    }

    /**
     * validateNameLength 는 이름에 대한 예외처리 사항을 확인하고, 문제 시 예외를 발생시킨다.
     * 이름의 길이가 1글자 미만이거나, 혹은 5글자 초과이거나, 혹은 문자열이 비어있을 경우 예외처리된다.
     *
     * @param name 검증을 위해 전달되는, 이름을 담은 String 인스턴스이다.
     */
    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    /**
     * validateNames 는 이름의 목록 데이터를 분석하여, 목록 자체가 비어있거나 null인 경우 예외를 발생시킨다.
     * 또한, 각각의 이름 데이터에 문제가 있는지 validateNameLength를 호출하여 검사한다.
     */
    private void validateNames() {
        List<String> splitName = splitNamesByComma();
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        for (String name : splitName) {
            validateNameLength(name);
        }
    }
}
