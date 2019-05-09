package racing.controller;

import org.junit.jupiter.api.Test;

import racing.domain.Car;
import racing.domain.CarList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void 입력의이름이잘나눠지나요1() {
        String[] expectation = {"kwon", "kim", "Luffy", "Buddy"};
        assertThat(Controller.splitNames("kwon,kim,Luffy,Buddy")).isEqualTo(expectation);
    }

    @Test
    void 입력의이름이잘나눠지나요2() {
        String[] expectation = {"kwon"};
        assertThat(Controller.splitNames("kwon,kim,Luffy,Buddy")).isNotEqualTo(expectation);
    }

    @Test
    void 입력의이름이잘나눠지나요3() {
        String[] expectation = {"kwon", "kim", "Luffy", "Buddy"};
        assertThat(Controller.splitNames("Buddy")).isNotEqualTo(expectation);
    }

    @Test
    void 카리스트에서우승자를잘뽑아내나요1() {
        String[] expectation = {"kwon", "kim", "Luffy", "Buddy"};
        CarList carList = new CarList();
        carList.addCars(expectation);
        assertThat(Controller.getWinners(carList)).isEqualTo("kwon, kim, Luffy, Buddy");
    }
}