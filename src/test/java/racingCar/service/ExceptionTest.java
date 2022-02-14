package racingCar.service;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.exception.count.CountNotNumberException;
import racingCar.exception.count.CountRangeException;
import racingCar.exception.name.NameDuplicatedException;
import racingCar.exception.name.NameOnlyOneException;
import racingCar.exception.name.NameRangeException;
import racingCar.exception.name.NameSpecialCharException;

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
			.isInstanceOf(NameRangeException.class);
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
			.isInstanceOf(NameSpecialCharException.class);
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
			.isInstanceOf(NameOnlyOneException.class);
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
			.isInstanceOf(NameDuplicatedException.class);
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
			.isInstanceOf(CountNotNumberException.class);
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
			.isInstanceOf(CountRangeException.class);
	}
}