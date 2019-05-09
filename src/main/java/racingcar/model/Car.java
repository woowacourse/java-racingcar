package racingcar.model;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name){
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}
