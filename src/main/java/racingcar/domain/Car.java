package racingcar.domain;

public class Car {
	private String name;
	private int position;

	public Car(String name){
		this.name = name;
		position = 0;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
