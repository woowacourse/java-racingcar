package racingcar;

public class Car {


    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    private boolean canMove(){
        int random = (int) (Math.random()*10);
        return random >= 4;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }



}
