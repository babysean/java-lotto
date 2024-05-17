package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoConsumerTest {
    @Test
    @DisplayName("전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다")
    void 전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다() {
        // given
        int moeny = 2000;

        // when
        LottoConsumer consumer =  new LottoConsumer();
        consumer.buyLotto(moeny);
        List<LottoTicket> LottoTickets = consumer.getLottoTickets();

        // then
        assertThat(LottoTickets).hasSize(2);
    }
}
