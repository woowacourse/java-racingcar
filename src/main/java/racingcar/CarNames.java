package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {
    public static final String COMMA_DELIMITER = ",";
    private final List<CarName> names = new ArrayList<>();

    public CarNames(String names) {
        Set<String> unDuplicateNames = new HashSet<>();
        for(String name : names.split(COMMA_DELIMITER)){
            unDuplicateNames.add(name);
            this.names.add(new CarName(name));
        }
        if(names.length() != unDuplicateNames.size()){
            throw new IllegalArgumentException("이름이 중복됩니다.");
        }
    }

    public List<CarName> getNames() {
        return names;
    }
}
