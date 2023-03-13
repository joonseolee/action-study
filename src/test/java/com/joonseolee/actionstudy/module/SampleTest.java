package com.joonseolee.actionstudy.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
class SampleTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1:2", "2:3:5", "4:6:10"}, delimiter = ':')
    @DisplayName("두개의 값을 더하면 합쳐진 값이 나온다.")
    void whenTwoElementsSumUp_thenSuccess(int left, int right, int expected) {
        assertThat(left + right).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "2:3:-1", "4:6:-2"}, delimiter = ':')
    @DisplayName("두개의 값을 빼면 뺼셈된 값이 나온다.")
    void whenTwoElementsSubtract_thenSuccess(int left, int right, int expected) {
        assertThat(left - right).isEqualTo(expected);
    }
}
