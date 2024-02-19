package view;

import domain.Car;
import domain.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Car> requestCarName(Game game) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return setCarName(game);
    }

    public static int requestAttemptLimit(Game game) {
        System.out.println("시도할 회수는 몇회인가요?");
        return setInputAttemptLimit(game);
    }

    private static List<Car> setCarName(Game game) {
        try {
            return game.setCars(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestCarName(game);
        }
    }

    private static int setInputAttemptLimit(Game game) {
        try {
            return game.setAttemptLimit(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestAttemptLimit(game);
        }
    }
}
