package controller;

import domain.Car;
import domain.Judge;
import domain.Participants;
import domain.Race;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class RaceController {

    private InputView inputView = new InputView();
    private Participants participants;
    private Race race;
    private final Judge judge = new Judge();

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
        List<String> carNames = repeat(inputView::readCarNames);
        participants = new Participants(carNames, judge);
    }

    private void initRace() {
        int count = repeat(inputView::readCount);
        race = new Race(count, participants);
    }

    private void playGame() {
        while (!race.isFinished()) {
            playRound();
        }
        printRoundResult();
    }

    private void playRound() {
        race.playRound();
        printRoundResult();
    }

    private void printRoundResult() {
        OutputView.printRoundResult(participants.getCars());
    }

    private void printWinners() {
        List<Car> winners = participants.getWinners();
        OutputView.printWinners(winners);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return repeat(inputReader);
        }
    }
}
