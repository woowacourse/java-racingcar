package domain.service;

import domain.model.Name;
import java.util.List;
import java.util.Map;

public interface CarRaceService {

    Map<Name, Integer> saveCars(List<String> names);

    Map<Name, Integer> move();

    List<Name> getResult();
}
