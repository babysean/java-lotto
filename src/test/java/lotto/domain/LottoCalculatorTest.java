package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoCalculatorTest {
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
