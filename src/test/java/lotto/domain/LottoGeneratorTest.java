package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또_번호는_6개_입니다")
    void 로또_번호는_6개_입니다() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        LottoTicket lottoTicket = generator.generate();

        // then
        assertThat(lottoTicket.get()).hasSize(6);
    }

    @Test
    @DisplayName("로또_번호는_중복되지_않습니다")
    void 로또_번호는_중복되지_않습니다() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        LottoTicket lottoTicket = generator.generate();
        long count = lottoTicket
                .get()
                .stream()
                .distinct()
                .count();

        // then
        assertThat(count).isEqualTo(6);
    }
}
