package racingCar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingCar.model.CarDTO;
import racingCar.model.RacingCars;

@SuppressWarnings("NonAsciiCharacters")
public class OutputTest {

    @Test
    void 시작메세지_검사() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        Output.printStartMessage();

        //then
        assertThat(out.toString())
                .isEqualTo("\n실행 결과\n");
    }

    @Test
    void 실행결과출력_검사() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        RacingCars cars = new RacingCars(Arrays.asList("jiwoo", "juri"));
        CarDTO jiwooCarDTO = cars.get().get(0);
        jiwooCarDTO.position = 2;

        //when
        Output.printRoundResult(Arrays.asList(jiwooCarDTO, cars.get().get(1)));

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo : --\njuri : \n" + System.lineSeparator());
    }

    @Test
    void 위너출력_검사_1명() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        RacingCars cars = new RacingCars(Arrays.asList("jiwoo", "juri"));
        CarDTO jiwooCarDTO = cars.get().get(0);

        //when
        Output.printWinner(List.of(jiwooCarDTO));

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo가 최종 우승했습니다.\n");
    }

    @Test
    void 위너출력_검사_2명() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        RacingCars cars = new RacingCars(Arrays.asList("jiwoo", "juri"));

        //when
        Output.printWinner(cars.get());

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo, juri가 최종 우승했습니다.\n");
    }
}