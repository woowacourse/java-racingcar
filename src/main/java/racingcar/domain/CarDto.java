package racingcar.domain;

public class CarDto {

	private final String name;
	private final int position;

	public CarDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static CarDto from(String name) {
		return new CarDto(name, 0);
	}

	public static CarDto of(String name, int position) {
		return new CarDto(name, position);
	}

	public Car toEntity() {
		return Car.of(name, position);
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
