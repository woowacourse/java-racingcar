package racing.domain;

import racing.util.RandomGenerator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    public void validate(String name){
        validateSize(name);
    }

    private void validateSize(String name) {
        if(name.length() > 5 || name.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    public void moveForward(int value) {
        if(value>=4){
            this.position++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position)+"\n";
    }
}
