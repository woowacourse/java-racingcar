package controller;

import domain.Car;
import domain.Participants;
import domain.Race;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import utils.Judge;
import view.output.OutputView;

public class RaceController {

    private final Participants participants;
    private Race race;
    private final int DRIVING_DISTANCE = 1;

    public RaceController() {
        participants = new Participants();
    }

    public void playGame(String totalCount) {
        race = new Race(totalCount);
        while (!race.isFinished()) {
            playRound();
        }
        printRoundResult();
    }

    public void addAllParticipants(List<String> carNames) {
        carNames.forEach(participants::join);
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

    private void playRound() {
        List<Car> cars = participants.showAllParticipants();
        cars.forEach(this::driveOrNot);
        race.addCount();
        printRoundResult();
    }

    private void driveOrNot(Car car) {
        int number = car.chooseNumber();
        if (Judge.isAble(number)) {
            car.drive(DRIVING_DISTANCE);
        }
    }

    private void printRoundResult() {
        OutputView.printRoundResult(participants.showAllParticipants());
    }
}
