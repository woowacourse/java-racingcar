package racingcar.domain;

public class CarDto {

	private static final int INITIAL_POSITION = 0;

	private final String name;
	private final int position;

	private CarDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static CarDto of(String name) {
		return new CarDto(name, INITIAL_POSITION);
	}

	public static CarDto of(String name, int position) {
		return new CarDto(name, position);
	}

	public static CarDto of(Car car) {
		return new CarDto(car.getName(), car.getPosition());
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
