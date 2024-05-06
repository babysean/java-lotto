package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {
    @Test
    @DisplayName("구매_금액은_1000_과_같거나_커야_합니다")
    void 구매_금액은_1000_과_같거나_커야_합니다() {
        // given
        String money = "1000";

        // when
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(money.getBytes()));

        // then
        assertThat(inputView.insertMoney()).isGreaterThanOrEqualTo(1000);
    }

    @Test
    @DisplayName("구매_금액은_숫자만_입력할_수_있습니다")
    void 구매_금액은_숫자만_입력할_수_있습니다() {
        // given
        String money = "hello";

        // when
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(money.getBytes()));

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::insertMoney)
                .withMessage("숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("당첨번호는_콤마로_구분된_6개_정수_입니다")
    void 당첨번호는_콤마로_구분된_6개_정수_입니다() {
        // given
        String winningNumber = "1,2,3 ,4,5";

        // when
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(winningNumber.getBytes()));

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::insertLastWeekWinningNumber)
                .withMessage("당첨번호는 콤마로 구분된 숫자 6개이어야 합니다.");
    }

    @Test
    @DisplayName("각_당첨번호는_1과_45_사이의_정수_이어야_합니다")
    void 각_당첨번호는_1과_45_사이의_정수_이어야_합니다() {
        // given
        String winningNumber = "1,2,3 ,4,5,77";

        // when
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(winningNumber.getBytes()));

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::insertLastWeekWinningNumber)
                .withMessage("각 당첨번호는 1과 45 사이의 정수이어야 합니다.");
    }

    @Test
    @DisplayName("당첨번호에는_중복된_번호가_없어야_합니다")
    void 당첨번호에는_중복된_번호가_없어야_합니다() {
        // given
        String winningNumber = "1,2,3,4,5,5";

        // when
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(winningNumber.getBytes()));

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::insertLastWeekWinningNumber)
                .withMessage("당첨번호에 중복된 숫자가 없어야 합니다.");
    }
}
