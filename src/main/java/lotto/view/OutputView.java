package lotto.view;

import lotto.domain.LottoConsumer;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;

public class OutputView {

    /**
     * 로또 구매 개수와 로또 번호를 출력합니다.
     *
     * @param consumer 로또 구매자
     */
    public void printLottoTicketsInformation(LottoConsumer consumer) {
        System.out.println("수동으로 " + consumer.getManualLottoTicketCount() + "개, 자동으로 " + consumer.getAutoLottoTicketCount() + "를 구매했습니다.");

        for (LottoTicket lottoTicket : consumer.getLottoTickets()) {
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
     * @param prize 로또 결과
     * @param count 일치하는 개수
     */
    public void printWinningInformation(LottoPrize prize, int count) {
        System.out.print(prize.getMatches() + "개 일치");

        if (prize.getMatches() == 5 && prize.getIsWonBonusNumber()) {
            System.out.print(", 보너스 볼 일치");
        }

        System.out.println(" (" + prize.getPrize() + "원) - " + count + "개");
    }

    /**
     * 수익률을 출력합니다.
     *
     * @param rate 수익률
     */
    public void printProfit(Double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
