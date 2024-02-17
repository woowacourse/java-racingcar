package domain.car;

import domain.name.Name;

public class Car  {
    private final Name name;
    private int position;
    private static final Integer FORWARD_POWER_THRESHOLD=4;
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

    public void race(Integer power){
        if(power>=FORWARD_POWER_THRESHOLD){
            this.position++;
        }
    }
}
