package racingcar.domain;

import java.util.Map;

public class RacingResult {

    private Map<Car, Integer> racingResult;

    public RacingResult(Map<Car, Integer> racingCarResult) {
        racingResult = racingCarResult;
    }

    public Map<Car, Integer> getRacingResult() {
        return racingResult;
    }
}
