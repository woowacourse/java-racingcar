package racingcar.utlis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConvertorTest {

	@Test
	public void 쉼표_기준으로_이름_분리() {
		String names = "pobi,crong,honux";
		String[] nameArray = Convertor.separateNamesByDelimiter(names);
		assertArrayEquals(nameArray, new String[] {"pobi", "crong", "honux"});
	}

}