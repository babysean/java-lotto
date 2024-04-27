package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    @Test
    @DisplayName("입력값은_NULL_일_수_없습니다")
    void 입력값은_NULL_일_수_없습니다() {
        // given & when & then
        assertThatNullPointerException()
                .isThrownBy(() -> new StringCalculator(null))
                .withMessage("입력값은 NULL일 수 없습니다.");
    }

    @Test
    @DisplayName("문자열은_플래시_2개_로_시작_되어야_합니다")
    void 문자열은_플래시_2개_로_시작_되어야_합니다() {
        // given
        String stringNumber = "/:\n1:2:3:1";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(stringNumber))
                .withMessage("구분자 형식이 맞지 않습니다.");
    }

    @Test
    @DisplayName("입력값에_음수가_포함될_수_없습니다")
    void 입력값에_음수가_포함될_수_없습니다() {
        // given
        String stringNumber = "//:\n1:-2:3:1";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(stringNumber).sum())
                .withMessage("음수는 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("숫자_배열의_합을_구합니다")
    void 숫자_배열의_합을_구합니다() {
        // given
        Integer[] numbers = {1, 2, 3, 4, 5};

        // when
        Integer result = Arrays.stream(numbers)
                            .mapToInt(Integer::intValue)
                            .sum();
        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("문자열에_숫자가_아닌_값이_포함되어_있는지_확인합니다")
    void 문자열에_숫자가_아닌_값이_포함되어_있는지_확인합니다() {
        // given
        String[] numbers = {"123", "456", "789"};

        // when
        boolean withNonNumber = Arrays.stream(numbers).anyMatch(s -> !s.matches("\\d+"));

        // then
        assertThat(withNonNumber).isFalse();
    }
}
