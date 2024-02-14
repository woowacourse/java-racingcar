package racingcar.controller;

import racingcar.domain.RaceParticipants;
import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RaceParticipantsRequest;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.utils.InputUtils;

public class RacingController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {
        RaceParticipants raceParticipants = readRaceParticipants();
        int raceCount = readRaceCount();

    }

    private RaceParticipants readRaceParticipants() {
        return InputUtils.retryOnException(() -> {
            RaceParticipantsRequest dto = inputView.readRaceParticipants();
            return dto.toRaceParticipants();
        });
    }

    private int readRaceCount() {
        return InputUtils.retryOnException(() -> {
            RaceCountRequest dto = inputView.readRaceCount();
            return dto.toInt();
        });
    }
}
