package racingcar.view;

import java.util.List;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;
import racingcar.dto.TryCountRequest;

public class RacingCarViewImpl implements RacingCarView {

    @Override
    public RacingCarNamesRequest receiveCarNames() {
        return null;
    }

    @Override
    public TryCountRequest receiveTryCount() {
        return null;
    }

    @Override
    public void printRacingResult(List<RacingCarStatusResponse> responses) {

    }

    @Override
    public void printWinners(RacingCarWinnerResponse response) {

    }
}
