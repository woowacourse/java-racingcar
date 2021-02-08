package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("스틱이 제대로 만들어 지는지 확인")
    @ParameterizedTest
    @CsvSource({"포비,3,---", "웨지,2,--", "삭정,1,-"})
    void makeStick_givenProperCarNameAndPosition_returnStickAccordingToTheValueOfPosition(String name, int position, String stick) {
        CarDto car = new CarDto(new Car(name));
        car.setPosition(position);
        assertThat(OutputView.makeStick(car)).isEqualTo(stick);
    }

    @DisplayName("매 라운드 상황을 표시해주는 리더보드를 형식에 맞게 제대로 출력하는지")
    @Test
    void printLeaderBoard_givenCars_printFormattedLeaderBoardMessage() {
        List<String> names = Arrays.asList("포비", "삭정", "웨지");
        CarsDto carsDto = new CarsDto(new Cars(names));
        setCarPositionForTest(carsDto, 0, 2);
        setCarPositionForTest(carsDto, 2, 1);

        OutputView.printLeaderBoard(carsDto);
        String expectedLeaderBoardFormat = "포비 : --\n삭정 : \n웨지 : -\n\n";

        assertThat(output.toString()).isEqualTo(expectedLeaderBoardFormat);
    }

    private void setCarPositionForTest(CarsDto carsDto, int carIndex, int targetPosition) {
        carsDto.getCarsDto()
                .get(carIndex)
                .setPosition(targetPosition);
    }

    @DisplayName("우승자 발표를 형식에 맞게 제대로 출력하는지")
    @Test
    void announceWinners_givenWinners_printFormattedAnnounceMessage() {
        List<String> winnerNames = Arrays.asList("포비", "삭정", "데이브");
        Cars winners = new Cars(winnerNames);
        WinnersDto winnersDto = new WinnersDto(winners.getCars());

        OutputView.announceWinners(winnersDto);
        String expectedAnnounceMessage = "포비, 삭정, 데이브가 최종 우승했습니다.\n";

        assertThat(output.toString()).isEqualTo(expectedAnnounceMessage);
    }
}