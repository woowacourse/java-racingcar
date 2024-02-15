package domain.car;

import domain.name.Name;

public class Car  {
    public static final Integer FORWARD_MAX_NUMBER = 10;
    private final Name name;
    private Integer position;
    private static final Integer FORWARD_THRESHOLD=4;
    public Car(Name name) {
        this.name = name;
        this.position=0;
    }

    public Name getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void race(Integer number){
        if(number>=FORWARD_THRESHOLD){
            this.position++;
        }
    }

    @Override
    public String toString() {
        return name.getValue();
    }
}
