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
import racingcar.dto.RecordDto;
import racingcar.dto.ResultDto;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    public void setUpCars() {
        cars.add(new Car("hoon"));
        cars.add(new Car("is2hs"));
    }

    @Test
    @DisplayName("자동자 경주 라운드별 기록 출력")
    public void print_racing_round_record() {
        cars.forEach(car -> car.drive(4));

        OutputView.printRacingRecord(RecordDto.createRecordDto(cars));

        assertThat(output.toString()).contains("hoon : -\nis2hs : -");
    }

    @Test
    @DisplayName("자동차 경주 우승자 이름 출력")
    public void print_racing_winners() {
        cars.forEach(car -> car.drive(4));

        OutputView.printRacingResult(ResultDto.createResultDto(cars));

        assertThat(output.toString()).contains("hoon, is2hs가 최종 우승했습니다.");
    }
}
