package lotto;

import java.util.List;

public class ResultView {

    void printPurchaseInfo(Lotto lotto) {
        System.out.println(lotto.getPurchaseCount() + "개를 구매했습니다.");

        for (List<Integer> numbers : lotto.getPurchaseNumbers()) {
            System.out.println(numbers);
        }
    }

    void printResult(Lotto lotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lotto.getWinningCount(3) + "개");
        System.out.println("4개 일치 (50000원) - " + lotto.getWinningCount(4) + "개");
        System.out.println("5개 일치 (1500000원) - " + lotto.getWinningCount(5) + "개");
        System.out.println("6개 일치 (2000000000원) - " + lotto.getWinningCount(6) + "개");
        System.out.println("총 수익률은 " + lotto.getRateOfReturn() + "입니다.");
    }
}
