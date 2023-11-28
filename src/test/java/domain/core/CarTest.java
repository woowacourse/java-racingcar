package domain.core;

import static org.assertj.core.api.Assertions.assertThat;

import domain.vo.Distance;
import domain.vo.Name;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(value = ReplaceUnderscores.class)
class CarTest {

    @Test
    void 이름을_가진다() {
        // given
        Name name = new Name("doggy");

        // when
        Car car = new Car(name);

        // then
        assertThat(car.name()).isEqualTo("doggy");
    }

    @Test
    void 숫자가_4_이상이면_한_칸_이동한다() {
        // given
        Car car = createCar("doggy");
        int number = 4;

        // when
        Distance result = car.move(number);

        // then
        assertThat(result.value()).isEqualTo(1);
    }

    @Test
    void 숫자가_3_이하이면_이동하지_않는다() {
        // given
        Car car = createCar("doggy");
        int number = 3;

        // when
        Distance result = car.move(number);

        // then
        assertThat(result.value()).isEqualTo(0);
    }

    public Car createCar(String name) {
        return new Car(new Name(name));
    }
}
