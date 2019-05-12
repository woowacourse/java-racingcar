package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCarsTest {

    @Test
    void determineWinnersTest() {
        List<Car> winners = new ArrayList<>();
        List<String> carNames = new ArrayList<>();
        WinnerCars winnerCars = new WinnerCars();

        winners.add(new Car("crong"));
        carNames.add("pobi");
        carNames.add("crong");

        GameResult gameResult = new GameResult(carNames, 2);

        gameResult.getCars().get(1).move(4);
        winnerCars.determineWinners(gameResult);

        for (int i = 0; i < winners.size(); i++) {
            assertThat(winnerCars.getWinnerCars().get(i).getName()).isEqualTo(winners.get(i).getName());
        }

    }
}
