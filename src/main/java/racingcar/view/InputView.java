package racingcar.view;

import racingcar.utils.NameGenerator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분).");
        Scanner in = new Scanner(System.in);
        try {
            return NameGenerator.generateCarNames(in.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getCarNames();
        }
    }
}
