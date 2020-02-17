package racingcargame.domain.car;

public class CarDto implements Comparable<CarDto> {
	private String name;
	private int position;

	public CarDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isPositionOf(int position) {
		return this.position == position;
	}

	@Override
	public int compareTo(CarDto c) {
		return position - c.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarDto carDto = (CarDto)o;
		return name.equals(carDto.name) && position == carDto.position;
	}
}
