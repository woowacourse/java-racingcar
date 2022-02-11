package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.RacingRecord;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    public void setUpCars() {
        cars.add(new Car("rookie"));
        cars.add(new Car("is2hs"));
    }

    @Test
    @DisplayName("자동자 경주 라운드별 기록 출력")
    public void print_racing_round_record() {
        cars.forEach(car -> car.drive(4));
        RacingRecord racingRecord = new RacingRecord(cars);

        OutputView.printRacingRecord(racingRecord);

        assertThat(output.toString()).contains("rookie : -\nis2hs : -");
    }
}
