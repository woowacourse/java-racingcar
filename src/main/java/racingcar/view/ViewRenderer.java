package racingcar.view;

import java.util.Map;

import racingcar.dto.RoundResultResponseDTO;
import racingcar.dto.WinnersResponseDTO;

public class ViewRenderer {
    private static final String COLON = ":";
    private static final String DASH = "-";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public String renderRoundResult(RoundResultResponseDTO roundResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> result : roundResults.getRoundResult()) {
            stringBuilder.append(result.getKey());
            stringBuilder.append(SPACE + COLON + SPACE);
            stringBuilder.append(DASH.repeat(result.getValue()));
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    public String renderWinners(WinnersResponseDTO winners) {
        String renderedWinners = winners.getWinners().toString();
        return renderedWinners.substring(1, renderedWinners.length() - 1);
    }
}
