package stringcalculator.domain;

public class DefaultDelimiter implements Delimiter {
    private final String DEFAULT_DELIMITER = ",|:";

    @Override
    public String getDelimiter() {
        return DEFAULT_DELIMITER;
    }
}