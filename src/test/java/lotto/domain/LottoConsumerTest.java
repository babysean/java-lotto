package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoConsumerTest {

    @Test
    @DisplayName("자동_로또_티켓을_추가합니다")
    void 자동_로또_티켓을_추가합니다() {
        // given
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = Arrays.asList(lottoTicket1, lottoTicket2);

        LottoConsumer consumer = new LottoConsumer();

        // when
        consumer.addAutoLottoTickets(lottoTickets);

        // then
        assertThat(consumer.getAutoTicketCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동_로또_티켓을_구매_합니다")
    void 수동_로또_티켓을_구매_합니다() {
        // given
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = Arrays.asList(lottoTicket1, lottoTicket2);

        LottoConsumer consumer = new LottoConsumer();

        // when
        consumer.addManualLottoTickets(lottoTickets);

        // then
        assertThat(consumer.getManualTicketCount()).isEqualTo(2);
    }
}
