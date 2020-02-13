package application.racingGame;

import java.util.Scanner;

public class InputRacingInformation {

    public static String getRacingValue() {
        Scanner scanner = new Scanner(System.in);
        String racingGameValue = scanner.nextLine();
        return racingGameValue;
    }
}
