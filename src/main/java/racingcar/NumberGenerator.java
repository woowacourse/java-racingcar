package racingcar;

import java.util.Random;

public interface NumberGenerator {
	Random random = new Random();
	int generate();
}
