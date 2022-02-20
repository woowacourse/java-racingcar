package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final List<Car> carsList = new ArrayList<>();
    private Cars cars;

    @BeforeEach
    public void setUp_streams() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    public void setUp_cars() {
        carsList.add(Car.fromName(Name.from("코니")));
        carsList.add(Car.fromName(Name.from("is2hs")));
        cars = Cars.from(carsList);

    }

    @Test
    @DisplayName("자동자 경주 라운드별 기록 출력")
    public void print_racing_round_record() {
        cars.driveAll(() -> 5);

        OutputView.printRacingRecord(cars.getCurrentCars());

        assertThat(output.toString()).contains("코니 : -" + System.lineSeparator() + "is2hs : -");
    }

    @Test
    @DisplayName("자동차 경주 우승자 이름 출력 검사")
    public void print_racing_winners() {
        cars.driveAll(() -> 5);

        OutputView.printRacingResult(cars.getWinners());

        assertThat(output.toString()).contains("코니, is2hs가 최종 우승했습니다.");
    }
}
