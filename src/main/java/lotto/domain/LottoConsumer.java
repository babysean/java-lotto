package lotto.domain;

import static lotto.domain.LottoTicket.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoConsumer {

    /** 자동 구매한 로또 티켓 목록 */
    private final List<LottoTicket> autoLottoTickets = new ArrayList<>();

    /** 수동 구매한 로또 티켓 목록 */
    private final List<LottoTicket> manualLottoTickets = new ArrayList<>();

    /**
     * 자동 로또 티켓을 구매합니다.
     *
     * @param money 구매할 금액
     */
    public void buyLotto(int money) {
        int purchasedCount = money / LOTTO_PRICE;
        int autoPurchasedCount = purchasedCount - manualLottoTickets.size();

        for (int i = 0 ; i < autoPurchasedCount ; i++) {
            LottoGenerator generator = new LottoGenerator();
            autoLottoTickets.add(new LottoTicket(generator.generate()));
        }
    }

    /**
     * 수동 로또 티켓을 구매합니다.
     *
     * @param lottoTickets 수동 로또 티켓 목록
     */
    public void buyManualLotto(List<LottoTicket> lottoTickets) {
        manualLottoTickets.addAll(lottoTickets);
    }

    /**
     * 자동 로또 티켓 수 반환 합니다.
     *
     * @return int
     */
    public int getAutoLottoTicketsCount() {
        return autoLottoTickets.size();
    }

    /**
     * 수동 로또 티켓 수 반환 합니다.
     *
     * @return int
     */
    public int getManualLottoTicketsCount() {
        return manualLottoTickets.size();
    }

    /**
     * 구매한 로또 티켓 목록을 반환 합니다.
     *
     * @return List<LottoTicket>
     */
    public List<LottoTicket> getLottoTickets() {
        List<LottoTicket> allLottoTickets = new ArrayList<>(manualLottoTickets);
        allLottoTickets.addAll(autoLottoTickets);

        return allLottoTickets;
    }
}
