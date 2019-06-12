package parser;

import domain.CarName;

public class CarNameParser {
    public static CarName parse(String input) {
        return CarName.from(input);
    }
}
