package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    final int TOTAL_ROUNDS = 5;
    CarRepository carRepository = new CarRepository();
    Game game;

    @BeforeEach
    void beforeEach(){
        carRepository.clear();
        game = new Game(new String[]{"pobi", "jeong", "roma"}, TOTAL_ROUNDS);
    }

    @Test
    void getWinners(){
        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            game.playRound();
        }

        List<Car> winners = game.getWinners();
        int maxPosition = winners.get(0).getPosition();

        for (Car car : game.getCars()) {
            assertThat(car.getPosition()).isLessThanOrEqualTo(maxPosition);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"4,false", "5,true"}, delimiter = ',')
    void isOver(String roundNumString, String resultString) {
        int roundNum = Integer.parseInt(roundNumString);
        boolean result = Boolean.parseBoolean(resultString);

        for (int i = 0; i < roundNum; i++) {
            game.playRound();
        }

        assertThat(game.isOver()).isEqualTo(result);
    }
}
