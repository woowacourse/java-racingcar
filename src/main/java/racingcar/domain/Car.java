package racingcar.domain;

public class Car {
    private int position;
    private String name;

    private final int INIT_POSITION = 0;
    private final int MOVABLE_VALUE = 4;

    public Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public void move(int number){
        if(isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number){
        return number >= MOVABLE_VALUE;
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }
}
