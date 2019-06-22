package parser;

import domain.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {
    private static final String CAR_NAME_SEPARATOR = ",";

    public static CarName parseCarName(String input) {
        return CarName.from(input.trim());
    }

    public static List<CarName> parseCarNames(String input) {
        return Arrays.asList(input.split(CAR_NAME_SEPARATOR)).stream()
                .map(String::trim)
                .map(CarNameParser::parseCarName)
                .collect(Collectors.toList());
    }

}
