package util;

import java.util.List;

public class CarNamesDivider {

    private static final int LIMIT_REMOVER = -1;

    private static final String DELIMITER = ",";

    public List<String> divideCarNames(String carNames) {
        return List.of(carNames.split(DELIMITER, LIMIT_REMOVER));
    }

}
