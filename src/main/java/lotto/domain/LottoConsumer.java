package lotto.domain;

import static lotto.domain.LottoTicket.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoConsumer {

    /** 구매한 로또 티켓 목록 */
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    /** 수동 로또 구매 개수 */
    private int manualLottoCount = 0;

    /**
     * 자동 로또 티켓을 구매합니다.
     *
     * @param money 구매할 금액
     */
    public void buyLotto(int money) {
        int purchasedCount = money / LOTTO_PRICE;
        int autoPurchasedCount = purchasedCount - manualLottoCount;

        for (int i = 0 ; i < autoPurchasedCount ; i++) {
            LottoGenerator generator = new LottoGenerator();
            lottoTickets.add(generator.autoGenerate());
        }
    }

    /**
     * 수동 로또 티켓을 구매합니다.
     *
     * @param lottoTickets 수동 로또 티켓 목록
     */
    public void buyManualLotto(List<LottoTicket> lottoTickets) {
        this.lottoTickets.addAll(lottoTickets);
        manualLottoCount = lottoTickets.size();
    }

    /**
     * 구매한 로또 티켓 목록을 반환 합니다.
     *
     * @return List<LottoTicket>
     */
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    /**
     * 자동 로또 티켓 개수를 반환합니다.
     *
     * @return int
     */
    public int getAutoLottoTicketCount() {
        return lottoTickets.size() - manualLottoCount;
    }

    /**
     * 수동 로또 티켓 개수를 반환합니다.
     *
     * @return int
     */
    public int getManualLottoTicketCount() {
        return manualLottoCount;
    }
}
