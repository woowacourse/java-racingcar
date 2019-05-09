package racingcar.view;

import racingcar.model.CarList;
import racingcar.model.WinningCars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class View {

    private static final Scanner sc = new Scanner(System.in);

    /* String matches에 사용할 알파벳 REGEX 정의 */
    private static final String ALPHABET_REGEX = "^[a-zA-Z]*$";

    /* String matches에 사용할 숫자 REGEX 정의*/
    private static final String NUMBER_REGEX = "[1-9][0-9]*$";

    private static final int VALID_NAME_LENGTH = 5;

    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    public static String[] inputNameOfCar() {
        String[] scannedName;
        do {
            outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            scannedName = sc.nextLine().split(",");                     // ','을 기준으로 나눔
        } while (!isNamesValid(scannedName));
        return scannedName;
    }

    public static boolean isNamesValid(String[] scannedName) {
        int index = 0;
        while (index < scannedName.length && isNameValid(scannedName[index])) {
            index++;                                                                    // 이름이 5보다 크거나, 알파벳 이외의 문자가 있으면
        }
        if (index < scannedName.length) {
            return false;
        }
        return !isNameOverlap(scannedName);
    }

    private static boolean isNameValid(String name) {
        if ((name.length() > VALID_NAME_LENGTH) || (!name.matches(ALPHABET_REGEX))) {
            outputLine("잘못 입력하였습니다.(5글자 이하 영문자 이름을 입력하세요)");
            return false;
        }
        return true;
    }

    private static boolean isNameOverlap(String[] scannedName) {
        Set<String> hashSet = new HashSet<>(Arrays.asList(scannedName));
        if (scannedName.length != hashSet.size()) {
            outputLine("중복된 이름이 있습니다. 다시 입력하세요.");
            return true;
        }
        return false;
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

    public static void printCars(CarList carList) {
        outputLine(carList.toString());
    }

    public static void printWinningCars(WinningCars winningCars) {
        outputLine(winningCars.toString());
    }
}

