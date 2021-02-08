package stringcalculator.domain.Delimiter;

public class DefaultDelimiter implements Delimiter {
    private final String DEFAULT_DELIMITER = ",|:";

    @Override
    public String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}