package carracinggame.domain;

import carracinggame.view.OutputView;

public class CarNames {



    private static final String REGEX = ",+[\\s\\t],+|^[\\s\\t]*,.*|.*,[\\s\\t]*$";
    public static final int NAME_MAX_LENGTH = 6;
    public static final int NAME_MIN_LENGTH = 0;
    public static final String NAME_LENGTH_ERROR = "[ERROR] 이름의 길이가 " + NAME_MIN_LENGTH + "이하 또는 " +
            NAME_MAX_LENGTH + "이상이면 안됩니다. 다시 입력해주세요.";
    public static final String NAME_BLANK_ERROR = "[ERROR] 이름이 공백이면 안됩니다. 다시 입력해주세요.";

    public static void checkBlank(final String checking) throws IllegalArgumentException {
        if (checking.matches(REGEX)) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    public static void checkRightLength(String name) throws IllegalArgumentException {
        if (isRightLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private static boolean isRightLength(String name) {
        return name.length() <= NAME_MIN_LENGTH || name.length() >= NAME_MAX_LENGTH;
    }
}
