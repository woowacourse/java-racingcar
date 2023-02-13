package controller;

import domain.Car;
import domain.Participants;
import domain.Race;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private Participants participants;
    private Race race;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

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
        participants = new Participants(carNames);
    }

    private void initRace() {
        int count = repeat(inputView::readCount);
        race = new Race(count, participants);
    }

    private void playGame() {
        outputView.printResultMessage();
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
        outputView.printRoundResult(participants.getCars());
    }

    private void printWinners() {
        List<Car> winners = participants.findWinners();
        outputView.printWinners(winners);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return repeat(inputReader);
        }
    }
}
