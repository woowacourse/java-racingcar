package util;

import java.util.List;

public class CarNameValidator {
    public void validate(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("2개 이상의 자동차를 입력해 주세요.");
        }
    }
}
