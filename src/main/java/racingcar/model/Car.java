package racingcar.model;

public class Car {
	private String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Car car = (Car)obj;
		return this.name.equals(car.name);
	}
}
