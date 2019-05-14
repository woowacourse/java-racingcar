package racingcar.view;

import racingcar.model.RacingGame;
import racingcar.model.WinningCars;

import java.util.Scanner;

public final class View {

    private static final Scanner scanner = new Scanner(System.in);

    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    public static String[] inputNameOfCar() {
        outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine().split(",");
    }

    public static int inputNumberOfTry() {
        outputLine("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void printWinningCars(WinningCars winningCars) {
        outputLine(winningCars.toString());
    }
}

