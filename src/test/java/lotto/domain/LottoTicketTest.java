package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("로또 티켓에 대한 테스트 코드")
class LottoTicketTest {
    @Test
    @DisplayName("로또_티켓_클래스를_문자_배열로_초기화_합니다")
    void 로또_티켓_클래스를_문자_배열로_초기화_합니다() {
        // give
        String[] numbers = {"1", "2", "3", "4", "5", "6"};

        // when
        LottoTicket lottoTicket = new LottoTicket(numbers);

        // then
        assertThat(lottoTicket).isNotNull();
    }

    @Test
    @DisplayName("로또_티켓_클래스를_리스트로_초기화_합니다")
    void 로또_티켓_클래스를_리스트로_초기화_합니다() {
        // give
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        LottoTicket lottoTicket = new LottoTicket(numbers);

        // then
        assertThat(lottoTicket).isNotNull();
    }

}