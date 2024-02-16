package exception;

import java.util.List;

public class DuplicateCarNameException extends RuntimeException {
    private static final String DUPLICATE_CAR_NAME_EXCEPTION = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

    public DuplicateCarNameException(List<String> names) {
        super(DUPLICATE_CAR_NAME_EXCEPTION
                + "\nduplicated names: " + String.join(", ", names));
    }
}
