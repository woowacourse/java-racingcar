package racingcar.view;

import racingcar.model.Cars;
import racingcar.model.WinningCars;

import java.util.Scanner;

public final class View {
    private static final Scanner sc = new Scanner(System.in);

    /* String matches에 사용할 숫자 REGEX 정의*/
    private static final String NUMBER_REGEX = "[1-9][0-9]*$";

    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    public static String[] inputNameOfCar() {
        outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine().split(",");
    }

    public static int inputNumberOfTry() {
        String scannedNumberOfTry;
        outputLine("시도할 횟수는 몇회인가요?");

        do {
            scannedNumberOfTry = sc.nextLine();
        } while (!isValidTryNumber(scannedNumberOfTry));

        return Integer.parseInt(scannedNumberOfTry);
    }

    public static boolean isValidTryNumber(String scannedNumberOfTry) {
        if (scannedNumberOfTry.matches(NUMBER_REGEX)) {
            return true;
        }
        outputLine("잘못된 입력입니다. 1이상의 정수만 입력하세요.");    // 올바른 수가 아니면
        return false;
    }

    public static void printCars(Cars cars) {
        outputLine(cars.toString());
    }

    public static void printWinningCars(WinningCars winningCars) {
        outputLine(winningCars.toString());
    }
}

