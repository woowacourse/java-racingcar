package dto.input;

import domain.TryCount;

public class ReadTryCountDto {
    private final TryCount tryCount;

    public ReadTryCountDto(final TryCount tryCount) {
        this.tryCount = tryCount;
    }

    public TryCount getTryCount() {
        return tryCount;
    }
}
