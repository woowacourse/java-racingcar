package racingCar.utlis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConvertorTest {

	Convertor convertor = new Convertor();

	@Test
	public void 쉼표_기준으로_이름_분리() {
		String names = "pobi,crong,honux";
		String[] nameArray = convertor.separateNamesByDelimiter(names);
		assertArrayEquals(nameArray, new String[] {"pobi", "crong", "honux"});
	}

}