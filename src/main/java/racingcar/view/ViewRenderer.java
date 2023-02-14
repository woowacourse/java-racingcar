package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewRenderer {
    private static final String COLON = ":";
    private static final String DASH = "-";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public String renderRoundResult(Map<String, Integer> roundResults) {
        return roundResults.entrySet().stream()
                .map(result -> result.getKey() + SPACE + COLON + SPACE + DASH.repeat(result.getValue()) + NEW_LINE)
                .collect(Collectors.joining());
    }

    public String renderWinners(List<String> winners) {
        String renderedWinners = winners.toString();
        return renderedWinners.substring(1, renderedWinners.length() - 1);
    }
}
