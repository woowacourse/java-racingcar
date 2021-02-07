package stringcalculator.domain;

public class DefaultDelimiter implements Delimiter {
    private final String DEFAULT_DELIMITER = ",|:";

    @Override
    public boolean isDefault() {
        return true;
    }

    @Override
    public String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}