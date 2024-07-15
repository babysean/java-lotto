package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @Test
    @DisplayName("이등_당첨을_확인합니다")
    void 이등_당첨을_확인합니다() {
        // given
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 10));
        int bonusNumber = 10;

        // when
        LottoPrize result = purchasedLottoTicket.win(winningLottoTicket, bonusNumber);

        // then
        assertThat(result.getMatches()).isEqualTo(5);
    }
}
