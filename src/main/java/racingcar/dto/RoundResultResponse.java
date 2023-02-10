package racingcar.dto;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RoundResultResponse {
    private final List<CarDTO> roundResult = new ArrayList<>();

    public RoundResultResponse(Map<String, Integer> carsState) {
        for (Map.Entry<String, Integer> carState : carsState.entrySet()) {
            CarDTO carDTO = new CarDTO(carState.getKey(), carState.getValue());
            roundResult.add(carDTO);
        }
    }

    public List<CarDTO> getRoundResult() {
        return roundResult;
    }
}
