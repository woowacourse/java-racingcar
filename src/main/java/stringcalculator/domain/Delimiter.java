package stringcalculator.domain;

public interface Delimiter {
    boolean isDefault();
    String[] split(String input);
}