package racingcar.model;

public class CarDto {
	private final String name;
	private final int position;

	public CarDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name + " : " + "-".repeat(this.position);
	}
}
