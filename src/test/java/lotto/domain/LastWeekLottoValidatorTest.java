package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("지난 주 당첨 로또 번호의 유효성을 테스트 합니다.")
class LastWeekLottoValidatorTest {
    @Test
    @DisplayName("지난_주_당첨_번호는_6개의_숫자입니다")
    void 지난_주_당첨_번호는_6개의_숫자입니다() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        LastWeekLottoValidator lastWeekLottoValidator = new LastWeekLottoValidator();

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lastWeekLottoValidator.winningNumbersValidation(numbers));
    }

    @Test
    @DisplayName("각_당첨번호는_1과_45_사이의_정수이어야_합니다")
    void 각_당첨번호는_1과_45_사이의_정수이어야_합니다() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 70);

        // when
        LastWeekLottoValidator lastWeekLottoValidator = new LastWeekLottoValidator();

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lastWeekLottoValidator.winningNumbersValidation(numbers));
    }

    @Test
    @DisplayName("당첨번호에_중복된_숫자가_없어야_합니다")
    void 당첨번호에_중복된_숫자가_없어야_합니다() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when
        LastWeekLottoValidator lastWeekLottoValidator = new LastWeekLottoValidator();

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lastWeekLottoValidator.winningNumbersValidation(numbers));
    }

    @Test
    @DisplayName("당첨번호와_보너스번호는_중복될_수_없습니다")
    void 당첨번호와_보너스번호는_중복될_수_없습니다() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        // when
        LastWeekLottoValidator lastWeekLottoValidator = new LastWeekLottoValidator();

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lastWeekLottoValidator.bonusNumberValidation(numbers, bonusNumber));
    }
}
