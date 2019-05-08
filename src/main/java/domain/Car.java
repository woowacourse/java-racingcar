package domain;

public class Car {
    private String name;
    private int position = 0;

    Car(String name){
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= Constant.MOVE_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
