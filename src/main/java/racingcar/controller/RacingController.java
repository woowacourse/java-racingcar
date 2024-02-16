package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.domain.RaceParticipants;
import racingcar.domain.RaceResults;
import racingcar.domain.car.Car;
import racingcar.domain.move.MovingStrategy;
import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RaceParticipantsRequest;
import racingcar.dto.response.RaceResultsResponse;
import racingcar.dto.response.RaceWinnersResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.utils.InputUtils;

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

        RaceResults raceResults = race(raceCount, raceParticipants);

        printRaceResults(raceResults.getRaceResults());
        printRaceWinners(raceResults.getRaceWinners());
    }

    private RaceParticipants readRaceParticipants() {
        return InputUtils.retryOnException(() -> {
            final RaceParticipantsRequest dto = inputView.readRaceParticipants();
            return dto.toRaceParticipants(movingStrategy);
        });
    }

    private int readRaceCount() {
        return InputUtils.retryOnException(() -> {
            final RaceCountRequest dto = inputView.readRaceCount();
            return dto.toInt();
        });
    }

    private RaceResults race(final int raceCount, final RaceParticipants raceParticipants) {
        RaceResults raceResults = new RaceResults();

        for (int i = 0; i < raceCount; i++) {
            raceParticipants.move();
            raceResults.recordResult(raceParticipants.getCars());
        }

        return raceResults;
    }

    private void printRaceResults(final List<Map<Car, Integer>> raceResults) {
        outputView.printRaceResults(RaceResultsResponse.from(raceResults));
    }

    private void printRaceWinners(final List<Car> raceWinners) {
        outputView.printRaceWinners(RaceWinnersResponse.from(raceWinners));
    }
}
