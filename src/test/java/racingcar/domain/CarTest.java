package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final String SAMPLE_CAR_NAME = "sample";
    private static final int CRITERIA = 4;
    private static final int ONE_PROGRESS_POSITION = 1;
    private static final int ZERO_VALUE = 0;

    @Test
    void oneTurn() {
        Car advancedCar = new Car(SAMPLE_CAR_NAME);
        advancedCar.oneTurn(CRITERIA);
        assertThat(advancedCar.getPosition()).isEqualTo(ONE_PROGRESS_POSITION);

        Car stayedCar = new Car(SAMPLE_CAR_NAME);
        stayedCar.oneTurn(ZERO_VALUE);
        assertThat(stayedCar.getPosition()).isEqualTo(ZERO_VALUE);
    }
}