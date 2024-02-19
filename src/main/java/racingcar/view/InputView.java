package racingcar.view;

import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RaceParticipantsRequest;

public interface InputView {
    RaceParticipantsRequest readRaceParticipants();

    RaceCountRequest readRaceCount();
}
