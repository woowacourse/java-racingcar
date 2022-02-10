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

    private Input() {
    }

    public String carName() {
        try {
            Output.getCarName();
            String inputValue = scan.nextLine();
            if (inputValue.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            String[] names = inputValue.split(",");
            if (names.length < 2) {
                throw new IllegalArgumentException("자동차를 두 개 이상 입력해주세요.");
            }

            Set<String> carNames = new HashSet<>(Arrays.asList(names));
            if (carNames.size() != names.length) {
                throw new IllegalArgumentException("자동차 이름을 모두 다르게 입력해주세요.");
            }

            for (String name : names) {
                if (name.length() > 5) {
                    throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            return carName();
        }
    }
}
