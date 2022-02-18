package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.exception.DuplicateCarNameException;

public class Names {

	private final List<Name> names;

	public Names(List<Name> names) {
		names = new ArrayList<>(names);
		validateDuplicate(names);
		this.names = names;
	}

	private void validateDuplicate(List<Name> names) {
		boolean duplicated = names.stream()
			.anyMatch(name -> Collections.frequency(names, name) > 1);

		if (duplicated) {
			throw new DuplicateCarNameException();
		}
	}

	public List<Name> getNames() {
		return Collections.unmodifiableList(names);
	}

	public int getSize() {
		return names.size();
	}
}
