package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winners = new ArrayList<>();
    private int maxPosition = -1;

    public Winner(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            judgeWinner(cars.get(i).getPosition(), cars.get(i).getName());
        }
    }

    private void judgeWinner(int carPosition, String carName) {
        if (carPosition == maxPosition)  {
            winners.add(carName);
        }

        if (carPosition > this.maxPosition) {
            this.maxPosition = carPosition ;
            winners.clear();
            winners.add(carName);
        }
    }

    public List<String> getWinners() {
        return winners;
    }

    public String toString() {
        String winnerList = "";

        for (int i = 0; i < winners.size() - 1; i++) {
            winnerList += (winners.get(i) + " ");
        }

        winnerList += winners.get(winners.size() - 1);

        return winnerList;
    }
}
