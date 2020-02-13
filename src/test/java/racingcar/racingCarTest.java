package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;

import java.util.LinkedHashMap;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class racingCarTest {

    private static Game game;
    private static Cars cars;

    @BeforeAll
    public static void init() {
        CarFactory carFactory = new CarFactory("alan, bart, carol, don, eddy");
        cars = carFactory.enrollCars();
        game = new Game(cars, 5);
    }

    @Test
    @DisplayName("Car 클래스를 검사")
    void carTest() {
        Car car = new Car("pobi");
    }

    @ParameterizedTest
    @DisplayName("car가 4 이상의 숫자를 받을 때만 전진한다")
    @ValueSource(ints = {0, 1, 2, 3})
    void doesCarProceed(int randomSeed) {
        Car car = new Car("hiro");
        assertFalse(car.checkMove(randomSeed));
    }

    @ParameterizedTest
    @DisplayName("car의 전진 여부를 결정하는 난수 범위를 체크한다.")
    @ValueSource(ints = {10, -1})
    void randomGeneratorTest(int number) {
        Car car = new Car("hiro");
        Random random = new Random();
        assertThatThrownBy(() -> {
            car.checkMove(number);
        }).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @DisplayName("이름의 5자 제한을 체크하는 부분")
    @ValueSource(strings = {"abcdef", ""})
    void checkCarNameException(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("Car의 Proceed 테스트")
    void carProceedTest() {
        Car car = new Car("hiro");
        for (int i = 0; i < 4; i++) {
            car.checkMove(4);
        }
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    @DisplayName("경기 진행 테스트(1턴)")
    void gameProceedTest() {
        TestNumberGenerator test = new TestNumberGenerator(new int[]{4, 2, 3, 9, 5});
        cars.playTurn(test);
        assertThat(cars.notifyStatus().get("alan")).isEqualTo(1);
        assertThat(cars.notifyStatus().get("bart")).isEqualTo(0);
        assertThat(cars.notifyStatus().get("carol")).isEqualTo(0);
        assertThat(cars.notifyStatus().get("don")).isEqualTo(1);
        assertThat(cars.notifyStatus().get("eddy")).isEqualTo(1);
    }

    @Test
    @DisplayName("결과 발표 테스트")
    void getResultTest() {
        LinkedHashMap<String, Integer> finalStatus = new LinkedHashMap<>();
        finalStatus.put("alan", 6);
        finalStatus.put("bart", 3);
        finalStatus.put("cloy", 6);
        finalStatus.put("don", 5);
        assertThat(game.findWinner(finalStatus)).containsExactly("alan", "cloy");
    }

    @Test
    @DisplayName("Car의 현재 위치를 시각적으로 리턴하는 것을 테스트")
    void checkCurrentPosition() {
        Car car = new Car("hiro");
        for(int i = 0; i < 10; i++) {
            car.checkMove(4);
        }
        assertThat(car.currentPosition().get(0)).isEqualTo("hiro");
        assertThat(car.currentPosition().get(1)).isEqualTo("----------");
    }

}