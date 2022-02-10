package calculator;

public class Parser {
    String regex = ",|:";

    public String[] splitter(String input) {
        if (input == null || input.isEmpty()) {
            input = "0";
        }
        return input.split(regex);
    }
}
