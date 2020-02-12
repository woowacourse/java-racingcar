package racingcar.domain;

// TODO: 2020/02/11 Application, Game
public class Car implements Comparable<Car> {
	private final String name;
	private int position = 0;

	public Car(String name) {
		if (isTooLongName(name))
			throw new IllegalArgumentException();
		this.name = name;
	}

	private boolean isTooLongName(String name) {
		return name.length() > 5;
	}

	// TODO: 2020/02/11 int -> something wrapping ?
	public void move(int random) {
		if (isMoving(random)) {
			position++;
		}
	}

	private boolean isMoving(int random) {
		return random >= 4;
	}

	public boolean isOnSamePosition(Car anotherCar) {
		return compareTo(anotherCar) == 0;
	}

	public String getCoWinnersName(Car anotherCar) {
		if (isOnSamePosition(anotherCar)) {
			return name;
		}
		return null;
	}

	// TODO: 2020/02/11 isSame(int, car another) -> equals 빠지고 move도 테스트되니

	@Override
	public int compareTo(Car anotherCar) {
		return anotherCar.position - position;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" : ");
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		sb.append("\n");
		return sb.toString();
	}
}
