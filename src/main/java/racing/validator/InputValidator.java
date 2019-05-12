package racing.validator;

public class InputValidator {
    private static final String NAME_EXCEPTION_MESSAGE = "양식에 맞는 이름을 입력해주세요 !";
    private static final String INPUT_TIMES_EXCEPTION = "이동 횟수는 양수입니다 !";
    private static final int MIN_EXECUTION = 0;

    public static void checkValidName(String name) {
        if (!name.matches("[0-9a-zA-Z]{1,5}")) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
    }

    public static int checkValidExecution(int execution) {
        if (execution <= MIN_EXECUTION) {
            throw new IllegalArgumentException(INPUT_TIMES_EXCEPTION);
        }
        return execution;
    }
}
