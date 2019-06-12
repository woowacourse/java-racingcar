package parser;

import domain.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesParser {
    private static final String CAR_NAME_SPLITOR = ",";

    public static List<CarName> parse(String input) {
        return Arrays.asList(input.split(CAR_NAME_SPLITOR)).stream()
                .map(String::trim)
                .map(CarNameParser::parse)
                .collect(Collectors.toList());
    }
}
