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
     * @return List<Double>
     * */
    public List<Double> calculate(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        List<Double> winningCounts = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            // 일치하는 번호
            Set<Integer> intersection = new HashSet<>(lottoTicket.get());
            intersection.retainAll(winningTicket.get());

            // 일치하지 않는 번호
            Set<Integer> difference = new HashSet<>(lottoTicket.get());
            winningTicket.get().removeAll(difference);

            // 5개가 맞고 보너스 번호도 맞으면 5.1를 반환
            winningCounts.add(intersection.size() + checkBonusNumber(difference, winningTicket.getBonusNumber()));
        }

        return winningCounts;
    }

    /**
     * 보너스 번호가 맞으면 0.1 아니면 0.0을 반환 합니다.
     * 불일치 하는 숫자가 1개가 아니면 (5개가 맞지 않았다면) 0.0을 반환 합니다.
     *
     * @param theOtherOne 일치하지 않는 번호들
     * @param bonusNumber 보너스 번호
     * @return double
     * */
    public double checkBonusNumber(Set<Integer> theOtherOne, int bonusNumber) {
        if (theOtherOne.size() != 1) {
            return 0.0;
        }

        int checkingNumber = theOtherOne.iterator().next();

        if (checkingNumber == bonusNumber) {
            return 0.1;
        }

        return 0.0;
    }

    /**
     * 전달받은 수 만큼 맞은 로또의 개수를 반환합니다.
     *
     * @param matchingCounts 일치하는 숫자의 개수 목록
     * @param checkNumber 확인할 개수
     * @return int
     * */
    public int getCountOfWin(List<Double> matchingCounts, double checkNumber) {
        return (int) matchingCounts
                .stream()
                .filter(count -> Double.compare(count, checkNumber) == 0)
                .count();
    }

    /**
     * 당첨금을 계산하여 반환 합니다.
     *
     * @param matchingCounts 일치하는 숫자의 개수 목록
     * @return int
     * */
    public int getPrizeMoney(List<Double> matchingCounts) {
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
     * @return double
     * */
    public double getProfit(int prizeMoney, int money) {
        double rateOfReturn = (double) prizeMoney / (double) money;

        return Math.floor(rateOfReturn * 1000) / 1000;
    }
}
