package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> parsing(String text, String delimiter){
        return Arrays.asList(text.split(delimiter));
    }
}
