package view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.Car;
import racing.view.OutputView;

class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outputStream;
    Car winner;
    Car nonWinner;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("현황을 형식에 맞게 출력하는지 테스트")
    void printStatus() {
        // given
        setWinner();
        List<Car> statuses = List.of(winner, nonWinner);

        // when
        outputView.printStatus(statuses);

        // then
        Assertions.assertThat(outputStream.toString())
                .isEqualTo("rosie : --\nhong : -\n\n");
    }

    private void setWinner() {
        winner = new Car("rosie");
        winner.moveDependingOn(9);
        winner.moveDependingOn(9);
        nonWinner = new Car("hong");
        nonWinner.moveDependingOn(9);
    }

    @Test
    @DisplayName("우승자들을 형식에 맞게 출력하는지 테스트")
    void printWinners() {
        // given
        setWinner();
        List<Car> winners = List.of(winner, nonWinner);

        // when
        outputView.printWinners(winners);

        // then
        Assertions.assertThat(outputStream.toString())
                .isEqualTo("rosie, hong가 최종 우승했습니다.");
    }
}