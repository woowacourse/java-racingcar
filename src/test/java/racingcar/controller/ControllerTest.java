package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.CarList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ControllerTest {

    @Test
    void 자동차_리스트가_잘_생성됐는지_확인() {
        Controller controller = new Controller();
        CarList tmp = new CarList(new String[]{"a", "b", "c", "d", "e"});
        CarList carList = controller.makeCarList(new String[]{"a", "b", "c", "d", "e"});
        for (int i = 0; i < tmp.getCarList().size(); i++) {
            assertThat(carList.getCarList().get(i).getName()).isEqualTo(tmp.getCarList().get(i).getName());
        }
    }
}
