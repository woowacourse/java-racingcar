package racinginterface;

import java.io.IOException;

public interface InputViewInterface {
    String readNames() throws IOException;

    int readCountOfRound() throws IOException;

}
