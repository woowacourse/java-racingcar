package controller;

import domain.Car;
import domain.Judge;
import domain.Participants;
import domain.Race;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import view.output.OutputView;

public class RaceController {

    private final Participants participants;
    private Race race;
    private Judge judge = new Judge();
    private final int DRIVING_DISTANCE = 1;

    public RaceController() {
        participants = new Participants();
    }

    public void playGame(int totalCount) {
        race = new Race(totalCount);
        while (!race.isFinished()) {
            playRound();
        }
        printRoundResult();
    }

    public void addAllParticipants(List<String> carNames) {
        participants.add(carNames);
    }

    public List<Car> getWinners() {
        List<Car> participants = this.participants.findAll();
        int maxDistance = participants.stream().max(Comparator.comparing(Car::getDrivenDistance)).get()
            .getDrivenDistance();
        List<Car> winners = participants.stream()
            .filter(car -> car.getDrivenDistance() == maxDistance).collect(
                Collectors.toList());
        return winners;
    }

    private void playRound() {
        List<Car> participants = this.participants.findAll();
        participants.forEach(this::driveOrNot);
        race.addCount();
        printRoundResult();
    }

    private void driveOrNot(Car car) {
        int number = car.chooseNumber();
        if (judge.judgeDriving(number)) {
            car.drive(DRIVING_DISTANCE);
        }
    }

    private void printRoundResult() {
        OutputView.printRoundResult(participants.findAll());
    }
}
