package repository;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarRepositoryTest {

    private CarRepository carRepository;
    private final Car car1 = new Car("car1");
    private final Car car2 = new Car("car2");

    @BeforeEach
    void setUp() {
        this.carRepository = new CarRepositoryImpl();
        this.carRepository.save(car1);
        this.carRepository.save(car2);
    }

    @Test
    @DisplayName("차가 중복된 경우")
    void saveDuplicate() {
        //given
        Car original = new Car("car");
        Car copy = new Car("car");
        carRepository.save(original);

        //when
        //then
        assertThatThrownBy(() -> carRepository.save(copy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("새로운 차 저장")
    void save() {
        //given
        Car newCar = new Car("new");

        //when
        carRepository.save(newCar);

        //then
        assertThat(carRepository.findAllNameAndPosition().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("해당 이름의 차가 없을 때")
    void findByNameNotFound() {
        //given
        String name = "nothing";

        //when
        //then
        assertThatThrownBy(() -> carRepository.findMoveCountByName(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차 이름으로 레이싱 결과 찾기")
    void findByName() {
        //given
        //when
        int result = carRepository.findMoveCountByName(car1.getName());

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("모든 차 객체를 반환한다")
    void checkCarNameReturn() {
        //given
        //when
        List<Car> cars = carRepository.findAll();

        //then
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList()))
            .containsOnly(car1.getName(), car2.getName());
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2", "3:1"}, delimiter = ':')
    @DisplayName("멈춘 차 / 전진한 차의 업데이트를 테스트한다")
    void checkCarRaceUpdate(int power, int movePosition) {
        //given
        //when
        car1.move(power);

        //then
        assertThat(carRepository.findMoveCountByName(car1.getName())).isEqualTo(
            movePosition);
    }

    @Test
    @DisplayName("모든 차의 이동 결과 반환을 테스트한다")
    void checkAllCarNameAndPosition() {
        //given
        //when
        car1.move(4);
        car2.move(3);

        //then
        assertThat(carRepository.findAllNameAndPosition()).containsOnly(
            entry(car1.getName(), 2), entry(car2.getName(), 1));
    }
}