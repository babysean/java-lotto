package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoTicket.LOTTO_PRICE;

public class LottoConsumer {
    /** 구매한 로또 티켓 목록 */
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    /**
     * 로또 번호 생성하고 반환 합니다.
     *
     * @param money 구매할 금액
     * */
    public void buyLotto(int money) {
        int purchasedCount = money / LOTTO_PRICE;

        for (int i = 0; i < purchasedCount; i++) {
            LottoGenerator generator = new LottoGenerator();
            lottoTickets.add(new LottoTicket(generator.generate()));
        }
    }

    /**
     * 구매한 로또 티켓 목록을 반환 합니다.
     *
     * @return List<LottoTicket>
     * */
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
