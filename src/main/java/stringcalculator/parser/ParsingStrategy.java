package stringcalculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ParsingStrategy {
    protected Matcher matcher;

    public boolean support(String input) {
        matcher = Pattern.compile(getRegex())
                .matcher(input);
        return matcher.find();
    }

    abstract String getRegex();

    public List<String> parse() {
        return Arrays.asList(matcher.group(getNumbersIndex()).split(getDelimiter()));
    }

    abstract int getNumbersIndex();

    abstract String getDelimiter();
}
