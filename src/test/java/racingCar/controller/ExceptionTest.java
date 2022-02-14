package racingCar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.controller.service.RacingCarsService;
import racingCar.controller.service.RequestService;
import racingCar.model.exception.count.CountNotNumberException;
import racingCar.model.exception.count.CountRangeException;
import racingCar.model.exception.name.NameDuplicatedException;
import racingCar.model.exception.name.NameOnlyOneException;
import racingCar.model.exception.name.NameRangeException;
import racingCar.model.exception.name.NameSpecialCharException;

class ExceptionTest {
    RacingCarsService racingCarsService = new RacingCarsService();

    @DisplayName("이름이_5자보다_큰_경우")
    @Test
    public void t1() {
        //given
        String input = "abcdef,cde";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> racingCarsService.initiateCars(RequestService.requestNames()))
                .isInstanceOf(NameRangeException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("이름에_특수문자가_들어간_경우")
    @Test
    public void t2() {
        //given
        String input = "주리!,juri";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> racingCarsService.initiateCars(RequestService.requestNames()))
                .isInstanceOf(NameSpecialCharException.class)
                .hasMessage("이름에는 특수문자가 입력될 수 없습니다.");
    }

    @DisplayName("입력된_이름이_하나인_경우")
    @Test
    public void t3() {
        //given
        String input = "주리";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> racingCarsService.initiateCars(RequestService.requestNames()))
                .isInstanceOf(NameOnlyOneException.class)
                .hasMessage("이름을 2개 이상 입력해주세요.");
    }

    @DisplayName("중복된_이름이_있는_경우")
    @Test
    public void t4() {
        //given
        String input = "juri,juri";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> racingCarsService.initiateCars(RequestService.requestNames()))
                .isInstanceOf(NameDuplicatedException.class)
                .hasMessage("중복된 이름이 입력되었습니다.");
    }

    @DisplayName("라운드수_숫자가_아닐_경우")
    @Test
    public void t5() {
        //given
        String input = "오";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> racingCarsService.initiateCount(RequestService.requestCount()))
                .isInstanceOf(CountNotNumberException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @DisplayName("라운드수_숫자가_제로_이하인_경우")
    @Test
    public void t6() {
        //given
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(() -> racingCarsService.initiateCount(RequestService.requestCount()))
                .isInstanceOf(CountRangeException.class)
                .hasMessage("0회 이상 입력해주세요.");
    }
}