package calculator;

import java.util.*;

public class Extractor {
    private List<Integer> numbers = new ArrayList<>();
    private List<String> symbols = new ArrayList<>();

    Extractor(List<String> expression) {


    }

    public static Extractor instantiateExtractor(List<String> expression) {
        try {
            Extractor extractor = new Extractor(expression);
            return extractor;
        } catch (Exception e) {
            return StringCalculatorLauncher.doCalculate();
        }
    }

}
