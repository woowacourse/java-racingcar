package racing.controller;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public List<String> parse(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }
}
