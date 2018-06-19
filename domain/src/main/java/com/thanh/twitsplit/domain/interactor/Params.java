
package com.thanh.twitsplit.domain.interactor;

import java.util.HashMap;
import java.util.Map;

/**
 * Class backed by a Map, used to pass parameters to {@link UseCase} instances.
 */
public final class Params {
  public static final Params EMPTY = Params.create();

  private final Map<String, Object> parameters = new HashMap<>();

  private Params() {}

  public static Params create() {
    return new Params();
  }

  public void putInt(String key, int value) {
    parameters.put(key, value);
  }

  int getInt(String key, int defaultValue) {
    final Object object = parameters.get(key);
    if (object == null) {
      return defaultValue;
    }
    try {
      return (int) object;
    } catch (ClassCastException e) {
      return defaultValue;
    }
  }
}
