package parser;

import domain.Trial;

public class TrialParser {
    public static Trial parse(String input) {
        return Trial.from(Integer.parseUnsignedInt(input));
    }
}
