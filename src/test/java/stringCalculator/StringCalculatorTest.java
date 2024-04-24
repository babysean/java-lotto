package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    @Test
    @DisplayName("명시된_구분자로_문자열을_자르고_그_값들의_합을_반환합니다")
    void 명시된_구분자로_문자열을_자르고_그_값들의_합을_반환합니다() {
        // given
        String stringInt = "//:\n1:2:3:1";

        // when
        if (!stringInt.startsWith("//")) {
            throw new RuntimeException("Invalid format: 구분자 형식이 맞지 않습니다.");
        }

        int delimiterEndIndex = stringInt.indexOf('\n');
        String customDelimiter = stringInt.substring(2, delimiterEndIndex);
        stringInt = stringInt.substring(delimiterEndIndex + 1);

        // then
        try {
            int sum = Arrays.stream(stringInt.split(customDelimiter))
                    .mapToInt(Integer::parseInt)
                    .peek(number -> {
                        if (number < 0) {
                            throw new RuntimeException("음수가 포함 되어있습니다.");
                        }
                    })
                    .sum();

            assertThat(sum).isEqualTo(7);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값이 포함되어있습니다.");
        }
    }
}