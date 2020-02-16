package racingcargame.domain.car;

public class CarDto implements Comparable<CarDto> {
	private String name;
	private int position;

	CarDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public int compareTo(CarDto c) {
		return c.position - position;
	}

	public boolean isPositionOf(int position) {
		return this.position == position;
	}
}
