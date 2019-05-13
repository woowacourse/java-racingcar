package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingWinners {
    public static List<String> process(String[] carNames, ArrayList<Integer>[] carPositionHistory) {
        int maxPosition = getMaxPosition(carNames, carPositionHistory);
        List<String> winners = getWinners(carNames, carPositionHistory, maxPosition);
        return winners;
    }

    protected static int getMaxPosition(String[] carNames, ArrayList<Integer>[] carPositionHistory) {
        int maxPosition = 0;
        int numOfGame = carPositionHistory[0].size();
        int lastRoundIndex = numOfGame - 1;

        for (int i = 0; i < carNames.length; i++) {
            maxPosition = Math.max(maxPosition, carPositionHistory[i].get(lastRoundIndex));
        }
        return maxPosition;
    }

    protected static List<String> getWinners(String[] carNames, ArrayList<Integer>[] carPositionHistory, int maxPosition) {
        List<String> winners = new ArrayList<>();
        int numOfGame = carPositionHistory[0].size();
        int lastRoundIndex = numOfGame - 1;

        for (int i = 0; i < carNames.length; i++) {
            if (maxPosition == carPositionHistory[i].get(lastRoundIndex)) {
                winners.add(carNames[i]);
            }
        }
        return winners;
    }
}
