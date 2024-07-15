package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketGeneratorTest {

    @Test
    @DisplayName("로또_번호는_6개_입니다")
    void 로또_번호는_6개_입니다() {
        // given
        LottoTicketGenerator generator = new LottoTicketGenerator();

        // when
        LottoTicket lottoTicket = generator.autoGenerate();

        // then
        assertThat(lottoTicket.get()
                .size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또_번호는_중복되지_않습니다")
    void 로또_번호는_중복되지_않습니다() {
        // given
        LottoTicketGenerator generator = new LottoTicketGenerator();

        // when
        LottoTicket lottoTicket = generator.autoGenerate();

        long count = lottoTicket.get()
                .stream()
                .distinct()
                .count();

        // then
        assertThat(count).isEqualTo(6);
    }
}
