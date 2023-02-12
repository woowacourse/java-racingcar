package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @Test
    @DisplayName("단독 우승 테스트")
    void getWinner() {
        Vehicle success = new TestCarSuccess("Success");
        Vehicle fail = new TestCarFail("Fail");
        Cars cars = new Cars(Arrays.asList(success,fail));
        cars.moveAll();
        assertThat(cars.getWinner()).isEqualTo(Arrays.asList(success));
    }

    @Test
    @DisplayName("공동 우승 테스트")
    void getWinners() {
        Vehicle success1 = new TestCarSuccess("Success1");
        Vehicle success2 = new TestCarSuccess("Success2");
        Cars cars = new Cars(Arrays.asList(success1,success2));
        cars.moveAll();
        assertThat(cars.getWinner()).isEqualTo(Arrays.asList(success1,success2));
    }

    public class TestCarSuccess extends Vehicle {

        public TestCarSuccess(String name) {
            super(name,0);
        }

        @Override
        public boolean isMove() {
            return true;
        }
    }

    public class TestCarFail extends Vehicle {

        public TestCarFail(String name) {
            super(name,0);
        }
    }
}