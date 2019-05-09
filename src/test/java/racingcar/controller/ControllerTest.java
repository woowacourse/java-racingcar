package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.model.WinningCars;

import java.util.ArrayList;

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
        ArrayList carArrayList=new ArrayList<>();
        carArrayList.add(new Car("a",0));
        carArrayList.add(new Car("b",2));
        carArrayList.add(new Car("c",3));
        carArrayList.add(new Car("d",4));

        CarList carList=new CarList(carArrayList);
        WinningCars winningCars = new WinningCars();
        winningCars.getWinningCarNames().add("d");
        assertThat(carList.getWinnerCars().getWinningCarNames().size()).isEqualTo(winningCars.getWinningCarNames().size());
        for(int i=0;i<winningCars.getWinningCarNames().size();i++){
            assertThat(carList.getWinnerCars().getWinningCarNames().get(i)).isEqualTo(winningCars.getWinningCarNames().get(i));
        }

        carArrayList.add(new Car("e",4));
        winningCars.getWinningCarNames().add("e");
        carList=new CarList(carArrayList);
        assertThat(carList.getWinnerCars().getWinningCarNames().size()).isEqualTo(winningCars.getWinningCarNames().size());
        for(int i=0;i<winningCars.getWinningCarNames().size();i++){
            assertThat(carList.getWinnerCars().getWinningCarNames().get(i)).isEqualTo(winningCars.getWinningCarNames().get(i));
        }

    }
}
