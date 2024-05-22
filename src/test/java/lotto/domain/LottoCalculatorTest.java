package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoCalculatorTest {
    @Test
    @DisplayName("전달_받은_숫자만큼_일치하는_티켓의_개수를_반환합니다")
    void 전달_받은_숫자만큼_일치하는_티켓의_개수를_반환합니다() {
        // given
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));

        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(2, 3, 4, 5, 20, 21));

        // when
        LottoCalculator calculator = new LottoCalculator();

        List<Double> matchingCount = calculator.calculate(lottoTickets, winningLottoTicket);

        int count = calculator.getCountOfWin(matchingCount, 4);

        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을_계산하여_반환합니다")
    void 수익률을_계산하여_반환합니다() {
        // given
        int money = 2000;
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));

        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(2, 3, 4, 5, 20, 21));

        // when
        LottoCalculator calculator = new LottoCalculator();
        List<Double> matchingCount = calculator.calculate(lottoTickets, winningLottoTicket);

        int prizeMoney = calculator.getPrizeMoney(matchingCount);

        double rate = calculator.getProfit(prizeMoney, money);

        // then
        assertThat(rate).isEqualTo(25.0);
    }
}
