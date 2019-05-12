package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {
    private static Race race;

    public static void main(String[] args) {
        while (!initRace()) ;
        startRace(getNumOfRounds());
        OutputView.printWinners(race.getWinners());
    }

    private static void startRace(int numOfRounds) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numOfRounds; i++) {
            OutputView.printRound(race.startRound());
        }
    }

    private static boolean initRace() {
        try {
            race = new Race(InputView.inputCarNames());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
            return false;
        }
    }

    private static int getNumOfRounds() {
        try {
            int numOfTrials = InputView.inputNumberOfTrial();
            validateNumOfTrial(numOfTrials);
            return numOfTrials;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
            return getNumOfRounds();
        }
    }

    private static void validateNumOfTrial(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }
    }
}