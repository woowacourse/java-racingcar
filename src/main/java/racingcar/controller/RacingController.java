package racingcar.controller;

import racingcar.domain.RaceParticipants;
import racingcar.domain.car.move.MovingStrategy;
import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RaceParticipantsRequest;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class RacingController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovingStrategy movingStrategy;

    public RacingController(final InputView inputView, final OutputView outputView,
                            final MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void run() {
        RaceParticipants raceParticipants = readRaceParticipants();
        final int raceCount = readRaceCount();
        race(raceCount, raceParticipants);
        printRaceWinners(raceParticipants);
    }

    private RaceParticipants readRaceParticipants() {
        return retryOnException(() -> {
            final RaceParticipantsRequest dto = inputView.readRaceParticipants();
            return dto.toRaceParticipants(movingStrategy);
        });
    }

    private int readRaceCount() {
        return retryOnException(() -> {
            final RaceCountRequest dto = inputView.readRaceCount();
            return dto.toInt();
        });
    }

    private void race(final int raceCount, final RaceParticipants raceParticipants) {
        outputView.printRaceResultHeaderMessage();
        for (int i = 0; i < raceCount; i++) {
            raceParticipants.move();

            final Map<String, Integer> raceResult = raceParticipants.getCarNamesAndPosition();
            outputView.printRaceResult(raceResult);
        }
    }

    private void printRaceWinners(final RaceParticipants raceParticipants) {
        final List<String> raceWinnerNames = raceParticipants.getRaceWinnerNames();
        outputView.printRaceWinners(raceWinnerNames);
    }

    private <T> T retryOnException(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
