package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static racingcar.view.Output.*;

/**
 * - [ ] [ 예외 ] : `공백` - *(입력받은 문자열의 앞 뒤를 제거해준다.)*
 * - [ ] [ 예외 ] : 자동차가 `2대 미만`
 * - [ ] [ 예외 ] : 이름이 `중복`
 * - [ ] [ 예외 ] : `5글자 초과`
 */
public class Input {
    Scanner scan = new Scanner(System.in);

    public Input() {
    }

    public String[] carName() {
        try {
            Output.getCarName();
            String inputValue = scan.nextLine();
            allCarsValid(inputValue);
            return inputValue.split(",");
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return carName();
        }
    }

    private void allCarsValid(String names) {
        if (isBlank(names)) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        String[] cars = names.split(",");
        if (!isCars(cars)) {
            throw new IllegalArgumentException("자동차를 두 개 이상 입력해주세요.");
        }
        if (isDuplicated(cars)) {
            throw new IllegalArgumentException("자동차 이름을 모두 다르게 입력해주세요.");
        }
        nameValid(cars);
    }

    private void nameValid(String[] cars) {
        for (String name : cars) {
            if (isBlank(name)) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            if (!isValidLength(name)) {
                throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
            }
        }
    }

    private boolean isBlank(String name) {
        return name.trim().isEmpty();
    }

    private boolean isCars(String[] names) {
        return names.length >= 2;
    }

    private boolean isDuplicated(String[] names) {
        Set<String> carNames = new HashSet<>(Arrays.asList(names));
        return carNames.size() != names.length;
    }

    private boolean isValidLength(String name) {
        return name.length() <= 5;
    }
}
