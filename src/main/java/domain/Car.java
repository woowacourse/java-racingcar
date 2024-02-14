package domain;

public class Car {
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
}
