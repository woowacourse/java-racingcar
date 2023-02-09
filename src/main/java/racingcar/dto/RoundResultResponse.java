package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import racingcar.domain.Car;

public class RoundResultResponse {
    private final List<CarDTO> roundResult = new ArrayList<>();

    public RoundResultResponse(Set<Car> cars) {
        for (Car car : cars) {
            roundResult.add(new CarDTO(car));
        }
    }

    public List<CarDTO> getRoundResult() {
        return roundResult;
    }
}
