package racingcar;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


    public void moveOrHold(Boolean isMove) {
        if (isMove) {
            this.position += 1;
        }
    }

    public boolean isSamePosition(int targetPosition) {
        return position == targetPosition;
    }
    public void printPosition(){
        System.out.print(name+" : ");
        System.out.println("-".repeat(position));
    }
    public void printName(){
        System.out.print(name);
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
