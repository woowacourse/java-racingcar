package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    private CarName carName;

    @BeforeEach
    void setUp() {
        carName = new CarName("daon");
    }

    @DisplayName("자동차를 생성하면 위치 초기값은 0이다.")
    @Test
    void createCarByCarName() {
        //given
        int expectedPosition = 0;

        //when
        Car car = new Car(carName);
        int result = car.getPosition().getPosition();

        //then
        assertThat(result).isEqualTo(expectedPosition);
    }

    @DisplayName("4보다 큰 숫자일 경우 전진, 작을 경우 전진하지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,0", "3,0", "4,1", "5,1", "9,1",})
    void carMovingTest(int givenNumber, int expectedPosition) {
        //given
        Position expected = new Position(expectedPosition);

        //when
        Car car = new Car(carName);
        Position result = car.move(givenNumber);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
