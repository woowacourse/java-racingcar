package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarStatesBufferTest {
    @Test
    @DisplayName("자동차들의 상태 로그들을 출력.")
    public void toSting_자동차들의_상태_로그들을_출력() {
        CarStatesBuffer carStatesBuffer = new CarStatesBuffer();

        for(CarStates carStates : getCarStatesList()) {
            carStatesBuffer.append(carStates);
        }

        assertEquals(provideExpectedFor_toSting_자동차들의_상태_로그들을_출력() ,carStatesBuffer.toString());
    }

    private static List<CarStates> getCarStatesList() {
        List<CarStates> carStates = new ArrayList<>();

        carStates.add(
                CarStates.of(
                        Arrays.asList(getCarState("pobi", 1),
                                getCarState("crong", 1),
                                getCarState("honux", 1))
                )
        );
        carStates.add(
                CarStates.of(
                        Arrays.asList(
                                getCarState("pobi", 2),
                                getCarState("crong", 1),
                                getCarState("honux", 2))
                )
        );

        carStates.add(
                CarStates.of(
                        Arrays.asList(
                                getCarState("pobi", 3),
                                getCarState("crong", 2),
                                getCarState("honux", 3))
                )
        );
        carStates.add(
                CarStates.of(
                        Arrays.asList(
                                getCarState("pobi", 4),
                                getCarState("crong", 3),
                                getCarState("honux", 4)
                        )
                )
        );
        carStates.add(
                CarStates.of(
                        Arrays.asList(
                                getCarState("pobi", 5),
                                getCarState("crong", 4),
                                getCarState("honux", 5))
                )
        );
        carStates.add(
                CarStates.of(
                        Arrays.asList(
                                getCarState("pobi", 5),
                                getCarState("crong", 4),
                                getCarState("honux", 5))
                )
        );

        return carStates;
    }

    private static CarState getCarState(String name, int position) {
        return CarState.withNameAndPosition(new CarName(name), position);
    }

    private static String provideExpectedFor_toSting_자동차들의_상태_로그들을_출력() {
        return "실행 결과\n" +
                "pobi : -\n" +
                "crong : -\n" +
                "honux : -\n" +
                "\n" +
                "pobi : --\n" +
                "crong : -\n" +
                "honux : --\n" +
                "\n" +
                "pobi : ---\n" +
                "crong : --\n" +
                "honux : ---\n" +
                "\n" +
                "pobi : ----\n" +
                "crong : ---\n" +
                "honux : ----\n" +
                "\n" +
                "pobi : -----\n" +
                "crong : ----\n" +
                "honux : -----\n" +
                "\n" +
                "pobi : -----\n" +
                "crong : ----\n" +
                "honux : -----";
    }
}
