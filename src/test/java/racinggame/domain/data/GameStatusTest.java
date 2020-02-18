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

    @ParameterizedTest
    @CsvSource(value = {"pobi,3,pobi : ---", "crong,4,crong : ----", "honux,0,honux : "})
    void 로그_테스트(String name, int position, String log) {
        if (position == 0) {
            log += " ";
        }
        Assertions.assertThat(gameStatus.makeStatusLog(name, position)).isEqualTo(log);
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
        boolean chkWinner = gameStatus.isContainName("pobi");
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = gameStatus.isContainName("crong");
        Assertions.assertThat(chkWinner).isEqualTo(true);

        chkWinner = gameStatus.isContainName("honux");
        Assertions.assertThat(chkWinner).isEqualTo(false);
    }
}
