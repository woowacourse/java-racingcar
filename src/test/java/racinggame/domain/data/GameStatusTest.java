package racinggame.domain.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class GameStatusTest {
    private GameStatus gameStatus;
    Names names;

    @BeforeEach
    void init(){
        names = new Names("pobi,crong,honux");
        gameStatus = new GameStatus(names.splitNamesByComma());
    }

    @Test
    void 우승자_확인_테스트() {
        List<Car> carList= new ArrayList<>();
        carList.add(new Car("pobi", 0));
        carList.add(new Car("crong", 0));
        carList.add(new Car("honux", 0));

        carList.get(0).accelerate();
        carList.get(1).accelerate();
        //carList.get(2).accelerate();
        for (Car car : carList) {
            car.passingLog(gameStatus);
        }
        gameStatus.makeWinnerNames();
        boolean chkWinner = gameStatus.makeWinnerNames().contains("pobi");
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = gameStatus.makeWinnerNames().contains("crong");
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = gameStatus.makeWinnerNames().contains("honux");
        Assertions.assertThat(chkWinner).isEqualTo(false);
    }
}
