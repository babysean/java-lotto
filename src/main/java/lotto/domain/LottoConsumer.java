package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoTicket.LOTTO_PRICE;

public class LottoConsumer {
    /**
     * 로또 번호 생성하고 반환 합니다.
     *
     * @param money 구매할 금액
     * @return List<LottoTicket>
     * */
    public List<LottoTicket> buyLotto(int money) {
        int purchasedCount = money / LOTTO_PRICE;
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < purchasedCount; i++) {
            LottoGenerator generator = new LottoGenerator();
            lottoTickets.add(new LottoTicket(generator.generate()));
        }

        return lottoTickets;
    }
}
