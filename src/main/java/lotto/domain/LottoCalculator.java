package lotto.domain;

import java.util.*;
import java.util.ArrayList;

public class LottoCalculator {
    /** 지난 주 당첨 번호 */
    private final LottoTicket winningTicket;

    /** 구매한 번호 목록 */
    private final List<LottoTicket> lottoTickets;

    /**
     * 맞춘 로또의 개수를 구합니다.
     *
     * @author 박상훈
     * @param lottoTickets 구매한 로또 티켓
     * @param winningTicket 지난 주 당첨 로또 티켓
     */
    public LottoCalculator(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
        this.lottoTickets = lottoTickets;
    }

    /**
     * 로또 당첨 번호를 계산하여 반환 합니다.
     * 지난 주 당첨 번호와 구매한 번호 목록을 비교하여 일치하는 숫자의 개수를 구합니다.
     * 일치하는 개수를 List 에 담아 반환 합니다.
     *
     * @return List<Integer>
     * */
    public List<Integer> calculate() {
        List<Integer> winningCounts = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            Set<Integer> intersection = new HashSet<>(lottoTicket.get());
            intersection.retainAll(winningTicket.get());
            winningCounts.add(intersection.size());
        }

        return winningCounts;
    }

    /**
     * 수익률을 계산하여 반환합니다.
     *
     * @return Double
     * */
    public Double getRateOfReturn() {
        // TODO : 수익률 계산 메서드 작성
        /*
        int winningPrice = LottoPrize.THREE_MATCHES.getPrize() * getCountOfWins(LottoPrize.THREE_MATCHES.getMatches()) +
                LottoPrize.FOUR_MATCHES.getPrize() * getCountOfWins(LottoPrize.FOUR_MATCHES.getMatches()) +
                LottoPrize.FIVE_MATCHES.getPrize() * getCountOfWins(LottoPrize.FIVE_MATCHES.getMatches()) +
                LottoPrize.SIX_MATCHES.getPrize() * getCountOfWins(LottoPrize.SIX_MATCHES.getMatches());

        double rateOfReturn = (double) winningPrice / (double) this.purchaseMoney;

        return Math.floor(rateOfReturn * 1000) / 1000;*/
        return null;
    }
}
