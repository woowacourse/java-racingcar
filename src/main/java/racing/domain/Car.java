package racing.domain;

public class Car {
    private final String name;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name){
        validateSize(name);
    }

    private void validateSize(String name) {
        if(name.length() > 5 || name.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
}
