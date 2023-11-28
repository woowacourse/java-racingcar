package domain.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.vo.Name;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_이름은_중복될_수_없다() {
        // given
        List<Car> cars = List.of(new Car(
                new Name("doggy")), new Car(new Name("doggy"))
        );

        // when
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(cars));
    }

    @Test
    void 자동차_이름이_중복되지_않으면_객체_생성에_성공한다() {
        // given
        List<Car> cars = List.of(
                new Car(new Name("a")), new Car(new Name("b"))
        );

        // when
        Cars result = new Cars(cars);

        // then
        assertThat(result.cars()).hasSize(2);
    }

    @Test
    void 경주를_한_번_진행한다() {
        // given
        Cars cars = new Cars(List.of(
                new Car(new Name("A")), new Car(new Name("B")))
        );
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        List<Car> result = cars.playOnce(randomNumberGenerator);

        // then
        List<Integer> distances = result.stream()
                .map(Car::distance)
                .collect(Collectors.toList());
        assertThat(distances).allMatch(it -> it == 0 || it == 1);
    }

    @Test
    void 우승자를_반환한다() {
        // given
        Car a = new Car(new Name("A"));
        Car b = new Car(new Name("B"));
        a.move(4);

        Cars cars = new Cars(List.of(a, b));

        // when
        List<Car> result = cars.winners();

        // then
        assertThat(result)
                .containsOnly(a)
                .doesNotContain(b);
    }
}
