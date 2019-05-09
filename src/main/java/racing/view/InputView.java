package racing.view;

import racing.domain.RepeatNumber;

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

    public static RepeatNumber inputRepeatNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return getRepeatNumber(scanner.nextLine());
    }

    private static RepeatNumber getRepeatNumber(String repeatNumber) {
        try {
            return new RepeatNumber(repeatNumber);
        } catch (NumberFormatException e) {
            System.err.println("반복 횟수는 숫자만 가능합니다.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return inputRepeatNumber();
    }

    protected static void checkIdentifier(String carNames) {
        if (!carNames.contains(",")) throw new IllegalArgumentException("이름은 쉼표를 기준으로 구분합니다.");
    }


}
