package racingcar.view;

import racingcar.utils.NameGenerator;
import racingcar.utils.TrialNumberGenerator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner in = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분).");
        try {
            return NameGenerator.generateCarNames(in.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getCarNames();
        }
    }

    public static int getTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return TrialNumberGenerator.generateTrialNumber(in.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getTrialNumber();
        }
    }
}
