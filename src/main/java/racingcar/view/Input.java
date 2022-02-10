package racingcar.view;

import java.util.Scanner;

import static racingcar.view.Output.*;

public class Input {
    Scanner scan = new Scanner(System.in);

    private Input() {
    }

    public String carName() {
        try {
            Output.getCarName();
            String names = scan.nextLine();
            if (names.isBlank() ) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            return carName();
        }
    }
}
