package racingcar.model;

public class Car {

	private static final int MOVE_CRITERIA = 4;
	private static final int INITIAL_POSITION_VALUE = 0;

	private final Name name;
	private int position;

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = position;
	}

	public Car(String name) {
		this(name,INITIAL_POSITION_VALUE);
	}

	public void decideMove(int number) {
		if (number >= MOVE_CRITERIA) {
			move();
		}
	}

	private void move() {
		position++;
	}

	public String getName() {
		return name.getName();
	}

	public int getPosition() {
		return position;
	}

	public boolean matchPosition(int position) {
		return this.position == position;
	}

}
