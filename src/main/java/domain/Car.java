package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;

    private final List<String> position;

    public Car(String name) {
        validateLengthOfName(name);
        this.name = name;
        this.position = new ArrayList<>();
    }

    private void validateLengthOfName(String name){
        if(name.length() < 1 || name.length() > 5 ){
            throw new IllegalArgumentException();
        }
    }
}
