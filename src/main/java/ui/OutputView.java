package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OutputView {
    private final String POSITION_MARK = "-";

    public void printGameResult(TreeMap<String, Integer> carPositions) {
        System.out.println("실행 결과");
        carPositions.forEach((name, position) -> System.out.println(name + " : " + convertPosition(position)));
        System.out.println();
    }

    private String convertPosition(int position) {
        String result = POSITION_MARK;
        result.repeat(position + 1);
        return result;
    }
}
