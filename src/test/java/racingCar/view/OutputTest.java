package racingCar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingCar.domain.CarDto;
import racingCar.domain.Cars;

@SuppressWarnings("NonAsciiCharacters")
public class OutputTest {
    @Test
    void 시작메세지_검사() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        OutputView.printStartMessage();

        //then
        assertThat(out.toString())
                .isEqualTo("\n실행 결과\n");
    }

    @Test
    void 실행결과출력_검사() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Cars cars = new Cars(Arrays.asList("jiwoo", "juri"));
        CarDto jiwooCarDto = cars.get().get(0);
        jiwooCarDto.position = 2;

        //when
        OutputView.printRoundResult(Arrays.asList(jiwooCarDto, cars.get().get(1)));

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo : --\njuri : \n" + System.lineSeparator());
    }

    @Test
    void 위너출력_검사_1명() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Cars cars = new Cars(Arrays.asList("jiwoo", "juri"));
        CarDto jiwooCarDto = cars.get().get(0);

        //when
        OutputView.printWinner(List.of(jiwooCarDto));

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo가 최종 우승했습니다.\n");
    }

    @Test
    void 위너출력_검사_2명() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Cars cars = new Cars(Arrays.asList("jiwoo", "juri"));

        //when
        OutputView.printWinner(cars.get());

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo, juri가 최종 우승했습니다.\n");
    }
}