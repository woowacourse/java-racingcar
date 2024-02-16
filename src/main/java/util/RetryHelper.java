package util;

import java.util.function.Supplier;

public final class RetryHelper {

  private final int maxRetryCount;
  private int retryCount;

  public RetryHelper(int maxRetryCount) {
    this.maxRetryCount = maxRetryCount;
  }

  public <E> E retry(Supplier<E> supplier) {
    E result = null;
    while (result == null && retryCount <= maxRetryCount) {
      result = useSupplier(supplier);
      retryCount += 1;
    }
    if (result == null) {
      throw new RuntimeException("프로그램이 비정상 종료되었습니다.");
    }
    return result;
  }

  private <E> E useSupplier(Supplier<E> supplier) {
    try {
      return supplier.get();
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}

