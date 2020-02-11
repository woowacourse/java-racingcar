package racing;

import java.util.concurrent.ThreadLocalRandom;

public class Car {
	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public int randomGenerate() {
		return ThreadLocalRandom.current()
			.ints(0, 9)
			.findFirst()
			.orElse(0);
	}
}
