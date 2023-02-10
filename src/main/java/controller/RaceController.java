package controller;

import domain.Car;
import domain.Judge;
import domain.Participants;
import domain.Race;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import view.input.InputView;
import view.output.OutputView;

public class RaceController {

    private InputView inputView = new InputView();
    private Participants participants;
    private Race race;
    private Judge judge = new Judge();
    private final int DRIVING_DISTANCE = 1;

    public void play() {
        readyForGame();
        playGame();
        printWinners();
    }

    private void readyForGame() {
        initParticipants();
        initRace();
    }

    private void initParticipants() {
        List<String> carNames = inputCarNames();
        participants = new Participants(carNames);
    }

    private List<String> inputCarNames() {
        try {
            return inputView.readCarNames();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return inputCarNames();
        }
    }

    private void initRace() {
        int count = inputCount();
        race = new Race(count);
    }

    private int inputCount() {
        try {
            return inputView.readCount();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return inputCount();
        }
    }

    private void playGame() {
        while (!race.isFinished()) {
            playRound();
        }
        printRoundResult();
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

    private void printWinners() {
        List<Car> winners = getWinners();
        OutputView.printWinners(winners);
    }

    private List<Car> getWinners() {
        int maxDistance = participants.findAll().stream().max(Comparator.comparing(Car::getDrivenDistance)).get()
            .getDrivenDistance();
        List<Car> winners = participants.findAll().stream()
            .filter(car -> car.getDrivenDistance() == maxDistance).collect(
                Collectors.toList());
        return winners;
    }
}
