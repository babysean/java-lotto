package lotto.view;

import lotto.domain.LottoCalculator;

import java.util.List;

public class ResultView {

    /**
     * 로또 구매 개수와 로또 번호를 출력합니다.
     *
     * @author 박상훈
     * @param lottoNumbers 로또 객체
     * */
    public void printPurchaseInfo(List<List<Integer>> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");

        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    /**
     * 로또 결과와 수익률을 출력합니다.
     *
     * @author 박상훈
     * @param lotto 로또 객체
     * */
    public void printResult(LottoCalculator lotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lotto.getCountOfWins(3) + "개");
        System.out.println("4개 일치 (50000원) - " + lotto.getCountOfWins(4) + "개");
        System.out.println("5개 일치 (1500000원) - " + lotto.getCountOfWins(5) + "개");
        System.out.println("6개 일치 (2000000000원) - " + lotto.getCountOfWins(6) + "개");
        System.out.println("총 수익률은 " + lotto.getRateOfReturn() + "입니다.");
    }
}
