package racingCar.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import racingCar.utlis.Convertor;

public class NameValidator {
	public final String ERROR = "ERROR";

	public void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty())
			throw new Exception(ERROR);
	}

	public void checkSpace(String name) throws Exception {
		if (name.trim().isEmpty()) {
			throw new Exception(ERROR);
		}
	}

	public void checkNameSize(String name) throws Exception {
		if (name.length() > 5) {
			throw new Exception(ERROR);
		}
	}

	public void checkSpecialChar(String name) throws Exception {
		if (!Pattern.matches("[가-힣\\w_]*", name)) {
			throw new Exception(ERROR);
		}
	}

	public void checkOneName(List<String> nameList) throws Exception {
		if (nameList.size() <= 1) {
			throw new Exception(ERROR);
		}
	}

	public void checkDuplicatedName(String names) throws Exception {
		List<String> nameList = new ArrayList<>(Arrays.asList(Convertor.separateNamesByDelimiter(names)));
		Set<String> nameSet = new HashSet<>(nameList);
		if (nameSet.size() != nameList.size()) {
			throw new Exception(ERROR);
		}
	}
}
