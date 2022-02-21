package racingCar.controller;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingCar.domain.RacingGame;
import racingCar.domain.dto.InitDto;
import racingCar.exception.count.CountNotNumberException;
import racingCar.exception.count.CountRangeException;
import racingCar.exception.name.NameDuplicatedException;
import racingCar.exception.name.NameOnlyOneException;
import racingCar.exception.name.NameRangeException;
import racingCar.exception.name.NameSpecialCharException;

@SuppressWarnings("NonAsciiCharacters")
public class ExceptionTest {
    private static final String RIGHT_NAMES_INPUT = "juri,hunch";
    private static final String RIGHT_COUNT_INPUT = "5";

    @Test
    void 올바른_이름이_들어온_경우() {
        InitDto initDto = InitDto.of(RIGHT_NAMES_INPUT, RIGHT_COUNT_INPUT);

        assertThatCode(() -> new RacingGame(initDto))
                .doesNotThrowAnyException();

    }

    @Test
    void 이름이_5자보다_큰_경우() {
        //given
        String nameInput = "abcdef,cde";
        InitDto initDto = InitDto.of(nameInput, RIGHT_COUNT_INPUT);

        //then
        assertThatThrownBy(() -> new RacingGame(initDto))
                .isInstanceOf(NameRangeException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 이름에_특수문자가_들어간_경우() {
        //given
        String nameInput = "주리!,juri";
        InitDto initDto = InitDto.of(nameInput, RIGHT_COUNT_INPUT);

        //then
        assertThatThrownBy(() -> new RacingGame(initDto))
                .isInstanceOf(NameSpecialCharException.class)
                .hasMessage("이름에는 특수문자가 입력될 수 없습니다.");
    }

    @Test
    void 입력된_이름이_하나인_경우() {
        //given
        String nameInput = "주리";
        InitDto initDto = InitDto.of(nameInput, RIGHT_COUNT_INPUT);

        //then
        assertThatThrownBy(() -> new RacingGame(initDto))
                .isInstanceOf(NameOnlyOneException.class)
                .hasMessage("이름을 2개 이상 입력해주세요.");
    }

    @Test
    void 중복된_이름이_있는_경우() {
        //given
        String nameInput = "juri,juri";
        InitDto initDto = InitDto.of(nameInput, RIGHT_COUNT_INPUT);

        //then
        assertThatThrownBy(() -> new RacingGame(initDto))
                .isInstanceOf(NameDuplicatedException.class)
                .hasMessage("중복된 이름이 입력되었습니다.");
    }

    @Test
    void 라운드수_숫자가_아닐_경우() {
        //given
        String countInput = "오";

        //then
        assertThatThrownBy(() -> InitDto.of(RIGHT_NAMES_INPUT, countInput))
                .isInstanceOf(CountNotNumberException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    void 라운드수_숫자가_제로_이하인_경우() {
        //given
        String countInput = "0";
        InitDto initDto = InitDto.of(RIGHT_NAMES_INPUT, countInput);

        //then
        assertThatThrownBy(() -> new RacingGame(initDto))
                .isInstanceOf(CountRangeException.class)
                .hasMessage("0회 이상 입력해주세요.");
    }
}