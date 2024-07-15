package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @Test
    @DisplayName("로또_티켓의_당첨_결과를_반환합니다")
    void 로또_티켓의_당첨_결과를_반환합니다() {
        // given
        List<LottoPrize> result = List.of(LottoPrize.THREE_MATCHES, LottoPrize.THREE_MATCHES, LottoPrize.FIVE_MATCHES);

        // when
        LottoCalculator calculator = new LottoCalculator();
        int count = calculator.getCountOfWin(result, LottoPrize.THREE_MATCHES);

        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨금을_계산하여_반환합니다")
    void 당첨금을_계산하여_반환합니다() {
        // given
        List<LottoPrize> result = List.of(LottoPrize.THREE_MATCHES, LottoPrize.FOUR_MATCHES);

        // when
        LottoCalculator calculator = new LottoCalculator();
        int prizeMoney = calculator.getPrizeMoney(result);

        // then
        assertThat(prizeMoney).isEqualTo(55_000);
    }

    @Test
    @DisplayName("수익률을_계산하여_반환합니다")
    void 수익률을_계산하여_반환합니다() {
        // given
        int prizeMoney = 10000;
        int money = 2000;

        // when
        LottoCalculator calculator = new LottoCalculator();
        double profit = calculator.getProfit(prizeMoney, money);

        // then
        assertThat(profit).isEqualTo(5.0);
    }
}
