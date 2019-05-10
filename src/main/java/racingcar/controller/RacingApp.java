package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingApp {
    private static Race race;

    public static void main(String[] args) {
        initRace();
        OutputView.printRounds(getNumOfTrials(), race);
        OutputView.printWinners(race.getWinners());
    }

    private static void initRace() {
        try {
            race = new Race(filterTypos(InputView.inputCarNames()));
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
            initRace();
        }
    }

    private static List<String> filterTypos(String arg) {
        return new ArrayList<>(
                Arrays.stream(arg.split(","))
                        .map(x -> x.trim())
                        .filter(x -> (!x.equals("")) && (!x.equals(" ")) && (!x.equals(",")))
                        .collect(Collectors.toList())
        );
    }

    private static int getNumOfTrials() {
        try {
            int numOfTrials = InputView.inputNumberOfTrial();
            validateNumOfTrial(numOfTrials);
            return numOfTrials;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
            return getNumOfTrials();
        }
    }

    private static void validateNumOfTrial(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }
    }
}