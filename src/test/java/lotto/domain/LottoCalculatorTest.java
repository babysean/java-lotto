package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {
    @Test
    @DisplayName("두_정수_리스트의_일치하는_정수의_개수를_반환합니다")
    void 두_정수_리스트의_일치하는_정수의_개수를_반환합니다() {
        // TODO : 테스트 코드 작성

        /*// given
        int purchaseMoney = 2000;
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));

        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(2, 3, 4, 5, 20, 21));

        // when
        LottoCalculator calculator = new LottoCalculator(lottoTickets, winningLottoTicket);
        List<Integer> matchingCount = calculator.calculate();

        // then
        assertThat(calculator.getCountOfWins(matchingCount,4)).isEqualTo(1);*/
    }

    @Test
    @DisplayName("정수_리스트에서_특정_숫자에_맞는_값의_개수를_반환합니다")
    void 정수_리스트에서_특정_숫자에_맞는_값의_개수를_반환합니다() {
        // TODO : 테스트 코드 작성

        /*// given
        int purchaseMoney = 2000;
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));

        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(2, 3, 4, 5, 20, 21));

        // when
        LottoCalculator calculator = new LottoCalculator(lottoTickets, winningLottoTicket);

        int count = calculator.getCountOfWins(4);

        // then
        assertThat(count).isEqualTo(1);*/
    }

    @Test
    @DisplayName("수익률을_계산하여_반환합니다")
    void 수익률을_계산하여_반환합니다() {
        // TODO : 테스트 코드 작성

        /*// given
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12)));

        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(2, 3, 4, 5, 20, 21));

        // when
        LottoCalculator calculator = new LottoCalculator(lottoTickets, winningLottoTicket);

        // then
        assertThat(calculator.getRateOfReturn()).isEqualTo(2.5);*/
    }
}
