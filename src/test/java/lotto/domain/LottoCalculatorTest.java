package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoCalculatorTest {
    @Test
    @DisplayName("로또_티켓의_당첨_결과를_반환합니다")
    void 로또_티켓의_당첨_결과를_반환합니다() {
        // given
        List<LottoResult> result = new ArrayList<>();
        result.add(new LottoResult(3, false));
        result.add(new LottoResult(3, true));
        result.add(new LottoResult(3, false));
        result.add(new LottoResult(4, false));
        result.add(new LottoResult(5, true));

        // when
        LottoCalculator calculator = new LottoCalculator();
        int count = calculator.getCountOfWin(result, 3, false);

        // then
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("로또_티켓의_2등_개수를_반환합니다")
    void 로또_티켓의_2등_개수를_반환합니다() {
        // given
        List<LottoResult> result = new ArrayList<>();
        result.add(new LottoResult(3, false));
        result.add(new LottoResult(3, true));
        result.add(new LottoResult(3, false));
        result.add(new LottoResult(4, false));
        result.add(new LottoResult(5, true));

        // when
        LottoCalculator calculator = new LottoCalculator();
        int count = calculator.getCountOfWin(result, 5, true);

        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨금을_계산하여_반환합니다")
    void 당첨금을_계산하여_반환합니다() {
        // given
        List<LottoResult> result = new ArrayList<>();
        result.add(new LottoResult(3, false));
        result.add(new LottoResult(3, true));
        result.add(new LottoResult(3, false));
        result.add(new LottoResult(4, false));
        result.add(new LottoResult(5, true));

        // when
        LottoCalculator calculator = new LottoCalculator();
        int prizeMoney = calculator.getPrizeMoney(result);

        // then
        assertThat(prizeMoney).isEqualTo(30065000);
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
