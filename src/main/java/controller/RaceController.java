package controller;

import domain.Car;
import domain.Participants;
import domain.Race;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import util.NumberGenerator;
import view.output.OutputView;

public class RaceController {

    private final Participants participants;
    private Race race;
    private final int DRIVING_DISTANCE = 1;

    public RaceController() {
        participants = new Participants();
    }

    public void playGame(String totalCount, NumberGenerator numberGenerator) {
        race = new Race(totalCount);
        while (!race.isFinished()) {
            playRound(numberGenerator);
        }
        printRoundResult();
    }

    public void addAllParticipants(final String carNames) {
        final String DELIMITER = ",";
        splitWordsBy(carNames, DELIMITER).forEach(participants::join);
    }

    private List<String> splitWordsBy(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, -1)).map(String::strip)
            .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        List<Car> candidates = participants.showAllParticipants();
        int maxDistance = candidates.stream().max(Comparator.comparing(Car::getDrivenDistance))
            .get().getDrivenDistance();
        List<Car> winners = candidates.stream()
            .filter(car -> car.getDrivenDistance() == maxDistance)
            .collect(Collectors.toList());
        return winners;
    }

    private void playRound(NumberGenerator numberGenerator) {
        List<Car> cars = participants.showAllParticipants();
        cars.forEach((car) -> driveOrNot(car, numberGenerator));
        race.addCount();
        printRoundResult();
    }

    private void driveOrNot(Car car, NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        if (isEnoughToMove(number)) {
            car.drive(DRIVING_DISTANCE);
        }
    }

    private boolean isEnoughToMove(final int score) {
        final int MIN_SCORE = 4;
        return score >= MIN_SCORE;
    }

    private void printRoundResult() {
        OutputView.printRoundResult(participants.showAllParticipants());
    }
}
