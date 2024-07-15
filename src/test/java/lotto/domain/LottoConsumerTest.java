package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoConsumerTest {

    @Test
    @DisplayName("전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다")
    void 전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다() {
        // given
        int money = 2000;
        LottoTicketGenerator generator = new LottoTicketGenerator();
        LottoConsumer consumer = new LottoConsumer();

        // when
        consumer.buyLotto(money, generator);
        List<LottoTicket> LottoTickets = consumer.getLottoTickets();

        // then
        assertThat(LottoTickets).hasSize(2);
    }

    @Test
    @DisplayName("수동_로또_티켓을_구매_합니다")
    void 수동_로또_티켓을_구매_합니다() {
        // given
        String[] lottoNumber_1 = {"1", "2", "3", "4", "5", "6"};
        String[] lottoNumber_2 = {"1", "2", "3", "4", "5", "6"};

        List<String[]> LottoTickets = new ArrayList<>();
        LottoTickets.add(lottoNumber_1);
        LottoTickets.add(lottoNumber_2);

        LottoConsumer consumer = new LottoConsumer();
        LottoTicketGenerator generator = new LottoTicketGenerator();

        // when
        consumer.buyManualLotto(LottoTickets, generator);

        // then
        assertThat(consumer.getManualLottoTicketCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동_로또_티켓_수를_반환_합니다")
    void 자동_로또_티켓_수를_반환_합니다() {
        // given
        int money = 3000;
        LottoTicketGenerator generator = new LottoTicketGenerator();
        LottoConsumer consumer = new LottoConsumer();

        // when
        consumer.buyLotto(money, generator);

        // then
        assertThat(consumer.getAutoLottoTicketCount()).isEqualTo(3);
    }
}
