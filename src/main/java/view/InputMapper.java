package view;

import domain.Cars;
import domain.MoveCount;
import java.util.List;
import util.StringParser;

public class InputMapper {
    private static final String CAR_NAMES_DELIMITER = ",";

    public Cars mapToCars(String names) {
        List<String> carNames = StringParser.split(names, CAR_NAMES_DELIMITER);
        return Cars.from(carNames);
    }

    public MoveCount mapToMoveCount(String moveCount) {
        Integer count = StringParser.parseToInt(moveCount);
        return MoveCount.from(count);
    }
}
