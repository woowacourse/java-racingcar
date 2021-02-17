package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class CarsSetGenerator {

    private static final String DELIMITER = ",";

    public static Cars generateSet(String carsInput) {
        List<String> carNameCandidates = carsNameStringToList(carsInput);
        return new Cars(carNameCandidates);
    }

    public static List<String> carsNameStringToList(String carsInput) {
        String[] parsedCarsInput = carsInput.split(DELIMITER);
        return Arrays.asList(parsedCarsInput);
    }
}
