package lotto;

import lotto.domain.LottoCalculator;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoPurchase;
import lotto.domain.PurchasedNumbers;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTest {

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

    @Test
    @DisplayName("로또_번호는_6개_입니다")
    void 로또_번호는_6개_입니다() {
        // given
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // when
        List<Integer> lottoNumber = generator.generate();

        // then
        assertThat(lottoNumber).hasSize(6);
    }

    @Test
    @DisplayName("로또_번호는_중복되지_않습니다")
    void 로또_번호는_중복되지_않습니다() {
        // given
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // when
        List<Integer> lottoNumber = generator.generate();
        long count = lottoNumber.stream().distinct().count();

        // then
        assertThat(count).isEqualTo(6);
    }

    @Test
    @DisplayName("전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다")
    void 전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다() {
        // given
        LottoPurchase lottoPurchase =  new LottoPurchase(new PurchasedNumbers(), 2000);

        // when
        PurchasedNumbers purchasedNumbers = lottoPurchase.getPurchasedNumbers();
        List<List<Integer>> lottoNumbers = purchasedNumbers.getNumbers();

        // then
        assertThat(lottoNumbers).hasSize(2);
    }

    @Test
    @DisplayName("두_정수_리스트의_일치하는_정수의_개수를_반환합니다")
    void 두_정수_리스트의_일치하는_정수의_개수를_반환합니다() {
        // given
        int purchaseMoney = 2000;
        PurchasedNumbers lottoNumbers = new PurchasedNumbers();
        lottoNumbers.addNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers.addNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        List<Integer> lastWeeklottoNumbers = Arrays.asList(2, 3, 4, 5, 20, 21);

        // when
        LottoCalculator calculator = new LottoCalculator(lottoNumbers, lastWeeklottoNumbers, purchaseMoney);

        // then
        assertThat(calculator.getCountOfWins(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("정수_리스트에서_특정_숫자에_맞는_값의_개수를_반환합니다")
    void 정수_리스트에서_특정_숫자에_맞는_값의_개수를_반환합니다() {
        // given
        int purchaseMoney = 2000;
        PurchasedNumbers lottoNumbers = new PurchasedNumbers();
        lottoNumbers.addNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers.addNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        List<Integer> lastWeeklottoNumbers = Arrays.asList(2, 3, 4, 5, 20, 21);

        // when
        LottoCalculator calculator = new LottoCalculator(lottoNumbers, lastWeeklottoNumbers, purchaseMoney);
        int count = calculator.getCountOfWins(4);

        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을_계산하여_반환합니다")
    void 수익률을_계산하여_반환합니다() {
        // given
        PurchasedNumbers lottoNumbers = new PurchasedNumbers();
        lottoNumbers.addNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers.addNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        List<Integer> lastWeeklottoNumbers = Arrays.asList(2, 3, 4, 13, 20, 21);

        // when
        LottoCalculator calculator = new LottoCalculator(lottoNumbers, lastWeeklottoNumbers, 2000);

        // then
        assertThat(calculator.getRateOfReturn()).isEqualTo(2.5);
    }
}
