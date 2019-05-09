package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarList;
import racingcar.model.WinningCars;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ControllerTest {
    Controller controller;

    @BeforeEach
    void setup() {
        controller = new Controller();
    }

    @Test
    void 자동차_리스트가_잘_생성됐는지_확인() {
        CarList tmp = new CarList(new String[]{"a", "b", "c", "d", "e"});
        CarList carList = controller.makeCarList(new String[]{"a", "b", "c", "d", "e"});
        for (int i = 0; i < tmp.getCarList().size(); i++) {
            assertThat(carList.getCarList().get(i).getName()).isEqualTo(tmp.getCarList().get(i).getName());
        }
    }

    @Test
    void 승리한_자동차_목록이_잘_나오는지_확인() {
        CarList carList = new CarList("a,b,c,d".split(","));
        WinningCars winningCars = carList.getWinnerCars();

        WinningCars tmp = new WinningCars();
        tmp.getWinningCarNames().add("a");
        tmp.getWinningCarNames().add("b");
        tmp.getWinningCarNames().add("c");
        tmp.getWinningCarNames().add("d");
        for (int i = 0; i < tmp.getWinningCarNames().size(); i++) {
            assertThat(winningCars.getWinningCarNames().get(i)).isEqualTo(tmp.getWinningCarNames().get(i));
        }
    }
}
