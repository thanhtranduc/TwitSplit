package com.thanh.twitsplit.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ParamsTest {

  private Params params;

  @Before
  public void setUp() {
    params = Params.create();
  }

  @Test
  public void testShouldReturnIntValue() {
    params.putInt("key01", 3);

    assertThat(params.getInt("key01", 5)).isEqualTo(3);
  }

  @Test
  public void testShouldReturnIntDefaultValue() {
    params.putInt("key01", 3);
    params.putInt("key02", 4);

    assertThat(params.getInt("key03", 5)).isEqualTo(5);
  }
}
