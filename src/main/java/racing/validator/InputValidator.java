package racing.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 입력값에 대한 예외확인을 하는 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 2.0.0
 */
public class InputValidator {
    private static final String NAME_EXCEPTION_MESSAGE = "양식에 맞는 이름을 입력해주세요 !";
    private static final String INPUT_TIMES_EXCEPTION = "이동 횟수는 양수입니다 !";
    private static final String NAME_DUPLICATE_MESSAGE = "중복이름은 허용할 수 없습니다 !";
    private static final int MIN_EXECUTION = 0;

    public static void checkValidName(String name) {
        if (!name.matches("[0-9a-zA-Z]{1,5}")) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
    }
    public static String[] checkDuplication(String[] names) {
        Set<String> setName = new HashSet<>(Arrays.asList(names));
        if(setName.size() != names.length) {
            throw new IllegalArgumentException(NAME_DUPLICATE_MESSAGE);
        }
        return names;
    }

    public static int checkValidExecution(int tryNo) {
        if (tryNo <= MIN_EXECUTION) {
            throw new IllegalArgumentException(INPUT_TIMES_EXCEPTION);
        }
        return tryNo;
    }
}
