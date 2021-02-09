package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarsTest {

    @Test
    @DisplayName("경주할 자동차는 1대 이하일 경우에 IllegalArgumentException 발생")
    public void carsShouldBeMoreThanOneTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.of(Name.of("bmw")));

        assertThatThrownBy(() -> {
            Cars.of(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양쪽끝 공백을 제거한 자동차 이름이 서로 중복되면 IllegalArgumentException 발생")
    public void carsShouldNotUseDuplicatedNameTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.of(Name.of("bmw")));
        cars.add(Car.of(Name.of("bmw")));

        assertThatThrownBy(() -> {
            Cars.of(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("각각의 자동차들이 4이상의 값을 가지면 전진을 시도해본다")
    public void carsTryToMoveTest() {
        //given
        Cars cars = Cars.of("bmw,tico,k5");
        List<Integer> numbers = Arrays.asList(1, 3, 7);

        //when
        cars.tryToMoveCars(numbers);
        List<Car> carsForTest = cars.getCars();
        List<Integer> resultNumbers = Arrays.asList(0, 0, 1);

        //then
        assertAll(() -> {
                    for (int i = 0; i < carsForTest.size(); i++) {
                        assertThat(carsForTest.get(i).getPosition()).isEqualTo(resultNumbers.get(i));
                    }
                }
        );
    }

    @Test
    @DisplayName("우승자 판별을 위한 MaxPosition 값 가져오기")
    public void getMaxPositionTest() {
        //given
        Cars cars = Cars.of(Arrays.asList(
                Car.of(Name.of("bmw"), 3),
                Car.of(Name.of("tico"), 1),
                Car.of(Name.of("k5"), 10)
        ));

        //when
        int maxPosition = cars.getMaxPosition();

        //then
        assertThat(maxPosition).isEqualTo(10);
    }
}
