package stringcalculator.parser;

import java.util.Arrays;
import java.util.List;

public enum StringParserGroup {
    CUSTOM(new CustomParsingStrategy()),
    DEFAULT(new DefaultParsingStrategy());

    private final ParsingStrategy parsingStrategy;

    StringParserGroup(ParsingStrategy parsingStrategy) {
        this.parsingStrategy = parsingStrategy;
    }

    public static StringParserGroup findByInput(String input) {
        return Arrays.stream(values())
                .filter(aParser -> aParser.parsingStrategy.support(input))
                .findFirst()
                .orElse(DEFAULT);
    }

    public List<String> parse() {
        return this.parsingStrategy.parse();
    }
}
