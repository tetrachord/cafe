package com.foo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CafeTest {

    private Cafe cafe = new Cafe();

    @Test
    public void shouldCalculateTotal() throws Exception {

        // given
        List<String> items = Arrays.asList("Cola", "Coffee", "Cheese Sandwich");

        // when
        double total = cafe.calculateTotalFor(items);

        // then
        assertThat(total).isEqualTo(3.5d);
    }
}
