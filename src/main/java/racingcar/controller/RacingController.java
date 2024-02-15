package racingcar.controller;

import java.util.List;
import racingcar.domain.RaceParticipants;
import racingcar.domain.car.Car;
import racingcar.domain.car.move.MovingStrategy;
import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RaceParticipantsRequest;
import racingcar.dto.response.RaceResultResponse;
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
        int raceCount = readRaceCount();
        race(raceCount, raceParticipants);
        printRaceWinners(raceParticipants);
    }

    private RaceParticipants readRaceParticipants() {
        return InputUtils.retryOnException(() -> {
            RaceParticipantsRequest dto = inputView.readRaceParticipants();
            return dto.toRaceParticipants(movingStrategy);
        });
    }

    private int readRaceCount() {
        return InputUtils.retryOnException(() -> {
            RaceCountRequest dto = inputView.readRaceCount();
            return dto.toInt();
        });
    }

    private void race(int raceCount, RaceParticipants raceParticipants) {
        outputView.printRaceResultHeaderMessage();
        for (int i = 0; i < raceCount; i++) {
            raceParticipants.move();
            List<Car> raceResult = raceParticipants.getCars();
            outputView.printRaceResult(RaceResultResponse.from(raceResult));
        }
    }

    private void printRaceWinners(RaceParticipants raceParticipants) {
        List<Car> raceWinners = raceParticipants.getRaceWinners();
        outputView.printRaceWinners(RaceWinnersResponse.from(raceWinners));
    }
}
