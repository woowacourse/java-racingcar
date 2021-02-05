package racingcar.domain;

import racingcar.domain.CarName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {
    public static final String COMMA_DELIMITER = ",";
    public static final char COMMA = ',';

    private final List<CarName> names = new ArrayList<>();

    public CarNames(String inputNames) {
        if(inputNames.charAt(0)==COMMA || inputNames.charAt(inputNames.length()-1)==COMMA){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        Set<String> unDuplicateNames = new HashSet<>();
        for(String name : inputNames.split(COMMA_DELIMITER)){
            unDuplicateNames.add(name);
            names.add(new CarName(name));
        }
        if(names.size() != unDuplicateNames.size()){
            throw new IllegalArgumentException("이름이 중복됩니다.");
        }
    }

    public List<CarName> getNames() {
        return names;
    }
}
