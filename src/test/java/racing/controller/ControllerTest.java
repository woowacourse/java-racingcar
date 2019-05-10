package racing.controller;

import org.junit.jupiter.api.Test;

import racing.domain.CarContainer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerTest {
    @Test
    void 입력이잘변환되나요() {
        String[] expectation = {"kwon", "kim", "Luffy", "Buddy"};
        CarContainer carList = new CarContainer();
        carList.addCars(expectation);
        assertThat(Controller.makeCarList("kwon,kim,Luffy,Buddy")).isEqualTo(carList);
    }

    @Test
    void 카리스트에서우승자를잘뽑아내나요() {
        Controller.makeCarList("kwon,kim,Luffy,Buddy");
        assertThat(Controller.getWinners()).isEqualTo("kwon, kim, Luffy, Buddy");
    }

    @Test
    void 이름배열이비어있으면예외처리가되나요콤마만입력해봄() {
        assertThrows(IllegalArgumentException.class, () -> {
            Controller.makeCarList(",,,,,");
        });
    }

    @Test
    void 이름배열이비어있으면예외처리가되나요아무것도안입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            Controller.makeCarList("");
        });
    }
}