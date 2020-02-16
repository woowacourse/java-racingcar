package racingcargame.domain;

public class Car implements Comparable<Car> {
	private final Name name;
	private int position;

	public Car(String name) {
		this(name, 0);
	}

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = position;
	}

	public void go(Engine engine) {
		if (engine.canMove()) {
			position++;
		}
	}

	public boolean isSamePositionWith(Car car) {
		return this.position == car.position;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name.getName();
	}

	@Override
	public int compareTo(Car o) {
		return Integer.compare(this.position, o.position);
	}
}
