package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoConsumer {

    /** 자동 로또 티켓 목록 */
    private final List<LottoTicket> lottoTicketsByAuto;

    /** 수동 로또 티켓 목록 */
    private final List<LottoTicket> lottoTicketsByManual;

    public LottoConsumer() {
        this.lottoTicketsByAuto = new ArrayList<>();
        this.lottoTicketsByManual = new ArrayList<>();
    }

    /**
     * 자동 로또 티켓을 추가합니다.
     *
     * @param lottoTickets 로또 티켓 목록
     */
    public void addAutoLottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTicketsByAuto.addAll(lottoTickets);
    }

    /**
     * 수동 로또 티켓을 추가합니다.
     *
     * @param lottoTickets 로또 티켓 목록
     */
    public void addManualLottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTicketsByManual.addAll(lottoTickets);
    }

    /**
     * 전체 로또 티켓 목록을 반환 합니다.
     *
     * @return List<LottoTicket>
     */
    public List<LottoTicket> getLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(lottoTicketsByAuto);
        lottoTickets.addAll(lottoTicketsByManual);

        return lottoTickets;
    }

    /**
     * 자동 로또 티켓 개수를 반환합니다.
     *
     * @return int
     */
    public int getAutoTicketCount() {
        return lottoTicketsByAuto.size();
    }

    /**
     * 수동 로또 티켓 개수를 반환합니다.
     *
     * @return int
     */
    public int getManualTicketCount() {
        return lottoTicketsByManual.size();
    }
}
