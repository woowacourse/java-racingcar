package model;

import static util.Util.generateRandomNumber;
import static view.OutputView.ERROR_PREFIX;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MIN_CAR_NAME_COUNT = 2;
    private static final int MIN_POSITION = 0;
    private static final String NATURAL_FORMAT_REGEX = "^[\\d]*$";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final Cars cars;
    private final int round;
    private final List<RacingResultByRoundDto> raceRecord;

    private RacingGame(final Cars cars, final int round) {
        this.cars = cars;
        this.round = round;
        this.raceRecord = new ArrayList<>();
    }

    public static RacingGame from(final Cars cars, final String round) {
        validateRound(round);

        return new RacingGame(cars, Integer.parseInt(round));
    }

    private static void validateRound(String round) {
        checkIsNull(round);
        checkIsNaturalNumber(round);
        checkIsZero(round);
    }

    private static void checkIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수를 입력해 주십시오.");
        }
    }

    private static void checkIsNaturalNumber(String input) {
        if (!Pattern.matches(NATURAL_FORMAT_REGEX, input)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수는 자연수여야 합니다.");
        }
    }

    private static void checkIsZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수를 입력해 주세요.");
        }
    }

    public void race() {
        for (int i = 0; i < this.round; i++) {
            cars.moveCars();
            raceRecord.add(new RacingResultByRoundDto(cars.getCars()));
        }
    }

    public List<RacingResultByRoundDto> getAllRacingRecord() {
        return this.raceRecord;
    }

    public List<String> findWinnerNames() {
        return cars.findMaxPositionCarName();
    }

}
