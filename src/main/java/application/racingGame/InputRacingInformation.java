package application.racingGame;

import java.util.*;

public class InputRacingInformation {
    private static Scanner scanner = new Scanner(System.in);

    public static int getRacingLab() {
        OutputRacingView.getRacingLabMessage();
        String racingLabs = scanner.nextLine();
        return RacingInformationValidator.checkRacingLab(racingLabs);
    }

    public static List<String> getCarNames() {
        OutputRacingView.startRacingGameMessage();
        String carNames = scanner.nextLine();
        return RacingInformationValidator.checkCarNames(carNames);
    }
}
