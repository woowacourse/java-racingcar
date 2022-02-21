package racingCar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingCar.domain.dto.CarDto;
import racingCar.domain.dto.CarsDto;

@SuppressWarnings("NonAsciiCharacters")
public class OutputViewTest {
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

        //when
        List<CarDto> result = new ArrayList<>();
        result.add(CarDto.of("jiwoo", 2));
        result.add(CarDto.of("juri", 0));

        CarsDto carsDto = CarsDto.of(result);

        OutputView.printRoundResult(carsDto);

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo : --\njuri : \n" + System.lineSeparator());
    }

    @Test
    void 실행결과출력_검사_new() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        List<CarDto> result = new ArrayList<>();
        result.add(CarDto.of("jiwoo", 2));
        result.add(CarDto.of("juri", 0));
        CarsDto carsDto = CarsDto.of(result);

        OutputView.printRoundResult(carsDto);

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo : --\njuri : \n" + System.lineSeparator());
    }

    @Test
    void 위너출력_검사_1명() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        CarsDto carsDto = CarsDto.of(List.of(CarDto.of("hunch", 0)));

        //when
        OutputView.printWinner(carsDto);

        //then
        assertThat(out.toString())
                .isEqualTo("hunch가 최종 우승했습니다.\n");
    }

    @Test
    void 위너출력_검사_2명() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        CarsDto carsDto = CarsDto.of(Arrays.asList(CarDto.of("hunch", 0), CarDto.of("juri", 0)));

        //when
        OutputView.printWinner(carsDto);

        //then
        assertThat(out.toString())
                .isEqualTo("hunch, juri가 최종 우승했습니다.\n");
    }
}