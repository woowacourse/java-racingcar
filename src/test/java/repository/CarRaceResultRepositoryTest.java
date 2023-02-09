package repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceResultRepositoryTest {

    private CarRaceResultRepository carRaceResultRepository;
    private final Car car1 = new Car("car1");
    private final Car car2 = new Car("car2");

    @BeforeEach
    void setUp() {
        this.carRaceResultRepository = new CarRaceResultRepositoryImpl();
        this.carRaceResultRepository.save(car1);
        this.carRaceResultRepository.save(car2);
    }

    @Test
    @DisplayName("차가 중복된 경우")
    void saveDuplicate() {
        //given
        Car original = new Car("car");
        Car copy = new Car("car");
        carRaceResultRepository.save(original);

        //when
        //then
        assertThatThrownBy(() -> carRaceResultRepository.save(copy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차 레이싱 결과 저장")
    void save() {
        //given
        Car newCar = new Car("new");

        //when
        carRaceResultRepository.save(newCar);

        //then
        assertThat(carRaceResultRepository.findByName(newCar.getName())).isEqualTo(1);
    }

    @Test
    @DisplayName("해당 이름의 차가 없을 때")
    void findByNameNotFound() {
        //given
        String name = "nothing";

        //when
        //then
        assertThatThrownBy(() -> carRaceResultRepository.findByName(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차 이름으로 레이싱 결과 찾기")
    void findByName() {
        //given
        //when
        int result = carRaceResultRepository.findByName(car1.getName());

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("모든 차 이름을 반환한다")
    void checkCarNameReturn() {
        //given
        //when
        List<String> carNames = carRaceResultRepository.findAllCars();

        //then
        assertThat(carNames.size()).isEqualTo(2);
        assertThat(carNames).containsAll(List.of(car1.getName(), car2.getName()));
    }

    @Test
    @DisplayName("차 이름에 따른 이동을 테스트한다")
    void checkCarRaceByName() {
        //given
        //when
        carRaceResultRepository.moveByName(car1.getName());
        //then
        assertThat(carRaceResultRepository.getRaceResult().get(car1.getName())).isEqualTo(2);
        assertThat(carRaceResultRepository.getRaceResult().get(car2.getName())).isEqualTo(1);
    }
}