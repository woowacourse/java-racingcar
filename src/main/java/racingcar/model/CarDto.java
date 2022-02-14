package racingcar.model;

import java.util.Objects;

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

	public int getPosition() {
		return this.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarDto carDto = (CarDto)o;
		return position == carDto.position && Objects.equals(name, carDto.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
