package racingcar.view;

import java.util.List;
import java.util.Map;

public class ViewRenderer {
    private static final String COLON = ":";
    private static final String DASH = "-";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public String renderRoundResult(Map<String, Integer> roundResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> result : roundResults.entrySet()) {
            stringBuilder.append(result.getKey());
            stringBuilder.append(SPACE + COLON + SPACE);
            stringBuilder.append(DASH.repeat(result.getValue()));
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    public String renderWinners(List<String> winners) {
        String renderedWinners = winners.toString();
        return renderedWinners.substring(1, renderedWinners.length() - 1);
    }
}
