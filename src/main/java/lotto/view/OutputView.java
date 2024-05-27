package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;

import java.util.List;

public class OutputView {
    /**
     * 로또 구매 개수와 로또 번호를 출력합니다.
     *
     * @param lottoTickets 로또 객체
     * */
    public void printLottoTicketsInformation(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.get());
        }
    }

    /**
     * 결과를 출력하기 전, 타이틀을 출력합니다.
     */
    public void printResultTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    /**
     * 로또 결과와 수익률을 출력합니다.
     *
     * @param prize 로또 결과 enum
     * @param count 일치하는 개수
     * */
    public void printWinningInformation(LottoPrize prize, int count) {
        System.out.print(prize.getMatches() +"개 일치");

        if (prize.getIsWonBonusNumber()) {
            System.out.print(", 보너스 볼 일치");
        }

        System.out.println(" ("+ prize.getPrize() +"원) - " + count + "개");

    }

    /**
     * 수익률을 출력합니다.
     *
     * @param rate 수익률
     * */
    public void printProfit(Double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
