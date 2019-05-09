package racinggame.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final int NAME_EMPTY = 0;
    public static final int NAME_LENTH_BOUND = 5;
    public static void checkCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() == NAME_EMPTY) {
                throw new IllegalArgumentException("공백은 입력할 수 없습니다");
            }
            if (carName.length() > NAME_LENTH_BOUND) {
                throw new IllegalArgumentException("이름 길이 제한은 5자 이하입니다");
            }
        }
        if (checkNameDuplication(carNames)) {
            throw new IllegalArgumentException("중복되는 이름은 입력할 수 없습니다.");
        }
    }

    public static boolean checkNameDuplication(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);

        return nameSet.size() != carNames.size();
    }
}
