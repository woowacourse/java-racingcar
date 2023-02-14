package view;

import domain.Name;
import domain.TryCount;

import java.util.List;

public interface InputView {

    List<Name> sendCarsName();

    TryCount sendTryCount();
}
