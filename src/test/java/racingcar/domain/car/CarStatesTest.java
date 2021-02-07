package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarStatesTest {
    @Test
    @DisplayName("자동차들의 현재 상태를 출력.")
    public void toString_자동차들의_현재_상태를_출력() {

        List<CarState> cars = new ArrayList(
                Arrays.asList(
                        createCarFor_toString_자동차들의_현재_상태를_출력("포비", 3).getState(),
                        createCarFor_toString_자동차들의_현재_상태를_출력("워니", 1).getState(),
                        createCarFor_toString_자동차들의_현재_상태를_출력("제이슨", 4).getState()
                )
        );

        assertThat(CarStates.valueOf(cars).toString()).isEqualTo(
                "포비 : ---\n" +
                "워니 : -\n" +
                "제이슨 : ----"
        );

        cars = new ArrayList(
                Arrays.asList(
                        createCarFor_toString_자동차들의_현재_상태를_출력("포비", 3).getState()
                )
        );

        assertThat(CarStates.valueOf(cars).toString()).isEqualTo(
                "포비 : ---"
        );
    }

    private Car createCarFor_toString_자동차들의_현재_상태를_출력(String name, int position) {
        Car car = new Car(name, () -> true);

        while (position-- > 0) {
            car.move();
        }

        return car;
    }
}