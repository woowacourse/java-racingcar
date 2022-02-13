package racingCar.service;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import racingCar.exception.count.CountRangeException;
import racingCar.exception.name.NameDuplicatedException;
import racingCar.exception.name.NameRangeException;
import racingCar.exception.name.NameSpecialCharException;
import racingCar.exception.count.CountNotNumberException;
import racingCar.exception.name.NameOnlyOneException;

class RequestServiceTest {

	@Test
	public void 이름이_5자보다_큰_경우() {
		//given
		String input = "abcdef,cde";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//then
		assertThatThrownBy(RequestService::requestNames)
			.isInstanceOf(NameRangeException.class);
	}

	@Test
	public void 이름에_특수문자가_들어간_경우() {
		//given
		String input = "주리!,juri";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//then
		assertThatThrownBy(RequestService::requestNames)
			.isInstanceOf(NameSpecialCharException.class);
	}

	@Test
	public void 입력된_이름이_하나인_경우() {
		//given
		String input = "주리";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//then
		assertThatThrownBy(RequestService::requestNames)
			.isInstanceOf(NameOnlyOneException.class);
	}

	@Test
	public void 중복된_이름이_있는_경우() {
		//given
		String input = "juri,juri";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//then
		assertThatThrownBy(RequestService::requestNames)
			.isInstanceOf(NameDuplicatedException.class);
	}

	@Test
	public void 라운드수_숫자가_아닐_경우() {
		//given
		String input = "오";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//then
		assertThatThrownBy(RequestService::requestCount)
			.isInstanceOf(CountNotNumberException.class);
	}

	@Test
	public void 라운드수_숫자가_제로_이하인_경우() {
		//given
		String input = "0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//then
		assertThatThrownBy(RequestService::requestCount)
			.isInstanceOf(CountRangeException.class);
	}
}