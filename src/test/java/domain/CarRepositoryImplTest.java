package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.FixedMovingStrategy;

class CarRepositoryImplTest {

    Map<Car, Integer> carBoard = new HashMap<>();
    Car car = new Car(new Name("lee"));
    CarRepository carRepository = new CarRepositoryImpl();

    @BeforeEach
    void setUp() {
        carBoard.put(car, 0);
        carRepository.insertCarBoard(carBoard);
    }

    @DisplayName("자동 생성 숫자가 추출되었을때, 차량의 이동 가능여부를 판단")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "4:true", "9:true"}, delimiter = ':')
    void testIsAllowedToMove(int number, boolean expected) {
        boolean actualValue = carRepository.isAllowedToMove(number);
        assertEquals(expected, actualValue);
    }

    @DisplayName("이동 여부가 가능으로 판단되었다면 이동, 그렇지 않다면 멈춤")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1", "9:1"}, delimiter = ':')
    void testMove(int number, int expected) {
        carRepository.move(car, number);
        assertThat(carRepository.getCarBoard().get(car)).isEqualTo(expected);
    }

    @DisplayName("생성 전략으로 부터 생성된 숫자가 4 이상일 때, 이동하는지 확인")
    @Test
    void testCycleCars() {
        carRepository.cycleCars(new FixedMovingStrategy());
        assertThat(carRepository.getCarBoard().get(car)).isEqualTo(1);
    }

    @DisplayName("현재 게임 참여 차량 중 가장 위치값이 높은 n명의 우승자 추출")
    @Test
    void findWinners() {
        Car carKim = new Car(new Name("kim"));
        Car carPark = new Car(new Name("park"));
        carBoard.put(carKim, 2);
        carBoard.put(carPark, 2);
        assertThat(carRepository.findWinners()).isEqualTo(List.of(carKim, carPark));
    }
}