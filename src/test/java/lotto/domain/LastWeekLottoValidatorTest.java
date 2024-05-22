package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("지난 주 당첨 로또 번호의 유효성을 테스트 합니다.")
class LastWeekLottoValidatorTest {
    @Test
    @DisplayName("당첨번호는_콤마로_구분된_숫자_6개이어야_합니다")
    void 당첨번호는_콤마로_구분된_숫자_6개이어야_합니다() {
        // given
        String winningNumber = "1,2,3,4,5,s";
        int bonusNumber = 45;
        String [] winningNumbers = winningNumber
                .replace(" ", "")
                .split(",");

        // when
        LastWeekLottoValidator lastWeekLottoValidator = new LastWeekLottoValidator();

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> lastWeekLottoValidator.validate(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("각_당첨번호는_1과_45_사이의_정수이어야_합니다")
    void 각_당첨번호는_1과_45_사이의_정수이어야_합니다() {
        // given
        String winningNumber = "1,2,3,4,5,70";
        int bonusNumber = 45;
        String [] winningNumbers = winningNumber
                .replace(" ", "")
                .split(",");

        // when
        LastWeekLottoValidator lastWeekLottoValidator = new LastWeekLottoValidator();

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> lastWeekLottoValidator.validate(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨번호에_중복된_숫자가_없어야_합니다")
    void 당첨번호에_중복된_숫자가_없어야_합니다() {
        // given
        String winningNumber = "1,2,3,4,5,5";
        int bonusNumber = 45;
        String [] winningNumbers = winningNumber
                .replace(" ", "")
                .split(",");

        // when
        LastWeekLottoValidator lastWeekLottoValidator = new LastWeekLottoValidator();

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> lastWeekLottoValidator.validate(winningNumbers, bonusNumber));
    }
}
