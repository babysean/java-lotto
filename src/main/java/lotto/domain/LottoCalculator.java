package lotto.domain;

import java.util.*;
import java.util.ArrayList;

public class LottoCalculator {
    /**
     * 로또 당첨 번호를 계산하여 반환 합니다.
     * 지난 주 당첨 번호와 구매한 번호 목록을 비교하여 일치하는 숫자의 개수를 구합니다.
     * 일치하는 개수를 List 에 담아 반환 합니다.
     *
     * @param lottoTickets 구매한 로또 티켓 목록
     * @param winningTicket 지난 주 당첨 번호
     * @return List<Integer>
     * */
    public List<Integer> calculate(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        List<Integer> winningCounts = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            Set<Integer> intersection = new HashSet<>(lottoTicket.get());
            intersection.retainAll(winningTicket.get());
            winningCounts.add(intersection.size());
        }

        return winningCounts;
    }

    /**
     * 전달받은 수 만큼 맞은 로또의 개수를 반환합니다.
     *
     * @param matchingCounts 일치하는 숫자의 개수 목록
     * @param checkNumber 확인할 개수
     * @return int
     * */
    public int getCountOfWin(List<Integer> matchingCounts, int checkNumber) {
        return (int) matchingCounts
                .stream()
                .filter(count -> count == checkNumber)
                .count();
    }

    /**
     * 당첨금을 계산하여 반환 합니다.
     *
     * @param matchingCounts 일치하는 숫자의 개수 목록
     * @return int
     * */
    public int getPrizeMoney(List<Integer> matchingCounts) {
        int prizeMoney = 0;

        for (LottoPrize prize : LottoPrize.values()) {
            prizeMoney += prize.getPrize() * this.getCountOfWin(matchingCounts, prize.getMatches());
        }

        return prizeMoney;
    }

    /**
     * 로또 수익률을 계산하여 반환 합니다.
     *
     * @param prizeMoney 당첨금
     * @param money 로또 구매 금액
     * @return Double
     * */
    public Double getProfit(int prizeMoney, int money) {
        double rateOfReturn = (double) prizeMoney / (double) money;

        return Math.floor(rateOfReturn * 1000) / 1000;
    }
}
