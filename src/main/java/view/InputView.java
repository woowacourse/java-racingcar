package view;

import domain.Car;
import domain.CarFactory;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int readNumber() {
        return sc.nextInt();
    }

    public static String readString() {
        return sc.nextLine();
    }

    public static List<Car> readCarsUntilSucceed(CarFactory carFactory) {
        try {
            OutputView.printMassage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
            return carFactory.newCars(InputView.readString());
        } catch (Exception e) {
            OutputView.printMassage(String.format("각 차의 이름은 %d 글자의 길이여야합니다.", Car.MAX_NAME_LEN));
            OutputView.printMassage(e.getMessage());
            return readCarsUntilSucceed(carFactory);
        }
    }

    public static int readNumTrialsUntilSucceed() {
        int numTrials;
        try {
            OutputView.printMassage("시도할 회수는 몇회인가요?\n");
            numTrials = InputView.readNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printMassage("올바르지 않은 입력입니다. 숫자를 입력해주세요.\n");
            return readNumTrialsUntilSucceed();
        }

        if (numTrials < 0) {
            OutputView.printMassage("입력 값이 음수입니다. 다시 입력해주세요.");
            return readNumTrialsUntilSucceed();
        }
        return numTrials;
    }
}
