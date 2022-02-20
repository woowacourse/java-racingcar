package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingCar.domain.dto.CarDto;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
    private final Cars cars = new Cars(Arrays.asList("hunch", "judi"));

    @Test
    void getMaxPosition_0_검사() {
        System.out.println(cars.getDto());
        assertThat(cars.getMaxPosition()).isEqualTo(0);
    }

    @Test
    void getMaxPosition_2_검사() {
        //given
        CarDto hunchDTO = new CarDto(new Car("hunch", 2));
        CarDto judiDTO = new CarDto(new Car("judi", 2));

        //when
        cars.go();
        if (cars.getDto().contains(hunchDTO) || cars.getDto().contains(judiDTO)) {
            System.out.println(cars.getDto());
            assertThat(cars.getMaxPosition()).isEqualTo(2);
            return;
        }

        //then
        getMaxPosition_2_검사();
    }

    @Test
    void getSamePositionCars_이동없을때_검사() {
        System.out.println(cars.getDto());
        assertThat(cars.getSamePositionCarsDto(0)).isEqualTo(Arrays.asList("hunch", "judi"));
    }

    @Test
    void getSamePositionCars_이동했을때_검사() {
        //given
        CarDto sampleDTO = new CarDto(new Car("hunch", 2));

        //when
        while (!cars.getDto().contains(sampleDTO)) {
            cars.go();
        }

        //then
        System.out.println(cars.getDto());
        assertThat(cars.getSamePositionCarsDto(2)).contains("hunch");
    }

    @Test
    void getSamePositionCars_이동했을때_검사2() {
        while (cars.getDto().get(0).position != 2) {
            cars.go();
        }
        assertThat(cars.getSamePositionCarsDto(2).get(0)).isEqualTo("hunch");
    }

    @Test
    void get_같은값이_나오는지_검사() {
        CarDto hunchDTO = new CarDto(new Car("hunch", 0));
        CarDto judiDTO = new CarDto(new Car("judi", 0));

        assertThat(cars.getDto()).isEqualTo(Arrays.asList(hunchDTO, judiDTO));
    }
}