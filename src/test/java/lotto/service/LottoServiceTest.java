package lotto.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoConsumer;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    @DisplayName("자동_로또_티켓을_구매합니다")
    void 자동_로또_티켓을_구매합니다() {
        // given
        int money = 4_000;

        LottoConsumer consumer = new LottoConsumer(0);
        LottoCalculator calculator = new LottoCalculator();
        LottoGenerator generator = new LottoGenerator();
        LottoService lottoService = new LottoService(calculator, generator);

        // when
        lottoService.buyLotto(consumer, money);

        // then
        assertThat(consumer.getLottoTickets()
                .size()).isEqualTo(4);
    }

    @Test
    @DisplayName("수동_로또_티켓을_구매합니다")
    void 수동_로또_티켓을_구매합니다() {
        // given
        String[] lottoNumber_1 = {"1", "2", "3", "4", "5", "6"};
        String[] lottoNumber_2 = {"1", "2", "3", "4", "5", "6"};

        List<String[]> LottoTickets = new ArrayList<>();
        LottoTickets.add(lottoNumber_1);
        LottoTickets.add(lottoNumber_2);

        LottoConsumer consumer = new LottoConsumer(0);
        LottoCalculator calculator = new LottoCalculator();
        LottoGenerator generator = new LottoGenerator();
        LottoService lottoService = new LottoService(calculator, generator);

        // when
        lottoService.buyManualLotto(consumer, LottoTickets);

        // then
        assertThat(consumer.getLottoTickets()
                .size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또_번호를_가공하여_로또_티켓을_만듭니다.")
    void 로또_번호를_가공하여_로또_티켓을_만듭니다() {
        // given
        String[] lottoNumber = {"1", "2", "3", "4", "5", "6"};

        LottoCalculator calculator = new LottoCalculator();
        LottoGenerator generator = new LottoGenerator();
        LottoService lottoService = new LottoService(calculator, generator);

        // when
        LottoTicket lottoTicket = lottoService.lottoNumberToTicket(lottoNumber);

        // then
        assertThat(lottoTicket.get()).isNotNull();
    }

    @Test
    @DisplayName("로또를_계산하여_일치하는_개수의_목록을_반환합니다")
    void 로또를_계산하여_일치하는_개수의_목록을_반환합니다() {
        // given
        int bonusNumber = 24;

        LottoCalculator calculator = new LottoCalculator();
        LottoGenerator generator = new LottoGenerator();
        LottoService lottoService = new LottoService(calculator, generator);

        LottoTicket winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<LottoTicket> lottoTickets = new ArrayList<>();
        LottoTicket lottoTicket_1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket_2 = new LottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16));
        lottoTickets.add(lottoTicket_1);
        lottoTickets.add(lottoTicket_2);

        // when
        List<LottoPrize> lottoPrizes = lottoService.calculate(lottoTickets, winningTicket, bonusNumber);

        // then
        assertThat(lottoPrizes).hasSize(1);
        assertThat(lottoPrizes.get(0)).isEqualTo(LottoPrize.SIX_MATCHES);
    }

    @Test
    @DisplayName("로또_수익률을_계산_합니다")
    void 로또_수익률을_계산_합니다() {
        // given
        LottoCalculator calculator = new LottoCalculator();
        LottoGenerator generator = new LottoGenerator();
        LottoService lottoService = new LottoService(calculator, generator);

        // when
        Double profit = lottoService.getProfit(List.of(LottoPrize.THREE_MATCHES), 1_000);

        // then
        assertThat(profit).isEqualTo(5.0);
    }
}
