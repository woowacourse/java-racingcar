package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.rule.Condition;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @ParameterizedTest
    @DisplayName("랜덤 값이 4 이상일 경우 전진하고 3 이하의 값이면 멈춘다.")
    @CsvSource(value = {"1,1,1:0", "1,6,3:1", "6,5,7:3"}, delimiter = ':')
    public void move_랜덤_값이_4_이상일_경우_전진하고_3_이하의_값이면_멈춘다(String input, int expected) {
        int[] inputs = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();

        Car car = new Car(new Condition() {
            private int[] randomNumbers = inputs;
            private int index = 0;

            @Override
            public boolean isMovable() {
                return randomNumbers[index++] >= 4;
            }
        });

        for(int i=0; i<inputs.length; i++) {
            car.move();
        }

        assertEquals(expected, car.getPosition());
    }
}
