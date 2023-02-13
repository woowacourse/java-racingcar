package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import racingcar.dto.CarNamesRequestDTO;
import racingcar.util.Validator;

public class CarNames {

    private static final String CAR_NAME_DELIMITER = ",";
    private final List<String> names;

    public CarNames(CarNamesRequestDTO carNamesRequestDTO) {
        names = List.copyOf(Arrays.asList(carNamesRequestDTO.getCarNames().split(CAR_NAME_DELIMITER)));
        names.forEach(Validator::validateNotEmptyInput);
    }

    public List<String> getNames() {
        return names;
    }
}
