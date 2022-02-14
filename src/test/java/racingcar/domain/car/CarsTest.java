package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Car pobi;
    private List<Car> sampleCarList;

    @BeforeEach
    void setUp() {
        pobi = new Car(new Name("pobi"), new Position(3));
        sampleCarList = List.of(pobi,
            new Car(new Name("seung"), new Position(3)));
    }

    @Test
    void createCarsBySplitComma() {
        String input = "pobi,seung,char";
        Cars cars = new Cars(input);
        List<Car> carList = cars.getCarList();
        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0)).isEqualTo(new Car("pobi"));
        assertThat(carList.get(1)).isEqualTo(new Car("seung"));
        assertThat(carList.get(2)).isEqualTo(new Car("char"));
    }

    @Test
    void errorOnContinuousComma() {
        String input = ",,,";
        assertThatThrownBy(() -> {
            new Cars(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름에 ,만 사용할 수 없습니다.");
    }

    @DisplayName("우승자가 1명일 경우 정상적인지 확인")
    @Test
    void Should_SuccessToFindOneWinners() {
        List<Car> sampleWinners = List.of(pobi);
        List<Car> carList = List.of(pobi, new Car("seung"));
        Cars cars = new Cars(carList);
        assertThat(cars.findWinners()).isEqualTo(sampleWinners);
    }

    @DisplayName("우승자가 2명일 경우 정상적인지 확인")
    @Test
    void Should_SuccessToFindTwoWinners() {
        List<Car> sampleWinners = sampleCarList;
        List<Car> carList = sampleCarList;
        Cars cars = new Cars(carList);
        assertThat(cars.findWinners()).isEqualTo(sampleWinners);
    }
}
