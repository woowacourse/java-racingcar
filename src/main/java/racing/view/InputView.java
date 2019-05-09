package racing.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로구분)");
        String carNames = scanner.nextLine();

        try {
            checkIdentifier(carNames);
            return carNames;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputCarNames();
        }
    }

    protected static void checkIdentifier(String carNames) {
        if (!carNames.contains(",")) throw new IllegalArgumentException("이름은 쉼표를 기준으로 구분합니다.");
    }
}
