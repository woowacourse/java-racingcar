package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NoneAsciiCharacters")
public class CarTest {
    private CarName carName1;
    private CarName carName2;

    @BeforeEach
    void setUp() {
        carName1 = new CarName("칙촉");
        carName2 = new CarName("어썸오");
    }

    @Test
    void 자동차는_4이상일_경우_전진한다() {
        // given
        Car car = new Car(carName1);
        int number = 4;
        Position afterMove = new Position(2);
        // when
        car.attemptToMove(number);
        // then
        assertThat(car.getPosition()).isEqualTo(afterMove);
    }

    @Test
    void 자동차는_3이하일_경우_멈춘다() {
        // given
        Car car = new Car(carName1);
        int number = 3;
        Position afterMove = new Position(1);
        // when
        car.attemptToMove(number);
        // then
        assertThat(car.getPosition()).isEqualTo(afterMove);
    }

    @Test
    void 같은_위치인_경우_참을_반환한다() {
        //given
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        //when

        //then
        assertThat(car1.isSamePositionWith(car2)).isTrue();
    }

    @Test
    void 같은_위치가_아닌_경우_거짓을_반환한다() {
        //given
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        //when
        car1.attemptToMove(4);
        //then
        assertThat(car1.isSamePositionWith(car2)).isFalse();
    }
}
