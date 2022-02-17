package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class RacingCarsTest {
    private final RacingCars cars = new RacingCars(Arrays.asList("hunch", "judi"));

    @Test
    void getMaxPosition_0_검사() {
        System.out.println(cars.get());
        assertThat(cars.getMaxPosition()).isEqualTo(0);
    }

    @Test
    void getMaxPosition_2_검사() {
        //given
        CarDTO hunchDTO = new CarDTO(new Car("hunch",2));
        CarDTO judiDTO = new CarDTO(new Car("judi",2));

        //when
        cars.go();
        if (cars.get().contains(hunchDTO) || cars.get().contains(judiDTO)) {
            System.out.println(cars.get());
            assertThat(cars.getMaxPosition()).isEqualTo(2);
            return;
        }

        //then
        getMaxPosition_2_검사();
    }

    @Test
    void getSamePositionCars_이동없을때_검사() {
        System.out.println(cars.get());
        assertThat(cars.getSamePositionCars(0)).isEqualTo(cars.get());
    }

    @Test
    void getSamePositionCars_이동했을때_검사() {
        //given
        CarDTO sampleDTO = new CarDTO(new Car("hunch",2));

        //when
        while (!cars.get().contains(sampleDTO)) {
            cars.go();
        }

        //then
        System.out.println(cars.get());
        assertThat(cars.getSamePositionCars(2)).contains(sampleDTO);
    }

    @Test
    void getSamePositionCars_이동했을때_검사2() {
        while (cars.get().get(0).position != 2) {
            cars.go();
        }
        System.out.println(cars.get());
        assertThat(cars.getSamePositionCars(2).get(0).position).isEqualTo(2);
    }

    @Test
    void get_같은값이_나오는지_검사() {
        CarDTO hunchDTO = new CarDTO(new Car("hunch",0));
        CarDTO judiDTO = new CarDTO(new Car("judi",0));

        assertThat(cars.get()).isEqualTo(Arrays.asList(hunchDTO,judiDTO));
    }
}