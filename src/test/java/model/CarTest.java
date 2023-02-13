package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class CarTest {

    @DisplayName("자동차 이동 테스트 실패")
    @Test
    void isMoveFail() {
        Vehicle car = new TestCarFail("falseTest");

        assertThat(car.isMove()).isEqualTo(false);
    }

    @DisplayName("자동차 이동 테스트 성공")
    @Test
    void isMoveSuccess() {
        Vehicle car = new TestCarSuccess("trueTest");

        assertThat(car.isMove()).isEqualTo(true);
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