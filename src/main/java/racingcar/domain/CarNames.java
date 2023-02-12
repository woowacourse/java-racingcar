package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import racingcar.dto.CarNamesRequestDTO;

public class CarNames {

    private final List<String> names;

    private final String CAR_NAME_DELIMITER = ",";

    public CarNames(CarNamesRequestDTO carNamesRequestDTO) {
        names = List.copyOf(Collections.unmodifiableCollection(
            Arrays.asList(carNamesRequestDTO.getCarNames().split(CAR_NAME_DELIMITER))));
    }

    public List<String> getNames() {
        return names;
    }
}
