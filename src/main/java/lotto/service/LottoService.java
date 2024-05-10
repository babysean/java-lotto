package lotto.service;

import lotto.domain.*;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    /**
     * 로또 번호를 생성하고 목록을 반환 합니다.
     *
     * @param consumer LottoConsumer
     * @param money 구매 금액
     * @return List<LottoTicket>
     * */
    public List<LottoTicket> buyLotto(LottoConsumer consumer, int money) {
        return consumer.buyLotto(money);
    }

    /**
     * 지난 주 당첨 로또를 가공하여 LottoTicket 으로 만듧니다.
     *
     * @param numbers 지난 주 당첨 번호
     * @return LottoTicket
     * */
    public LottoTicket winningNumberToTicket(String[] numbers) {
        // 유효성 체크
        LastWeekLottoValidator validator = new LastWeekLottoValidator();
        validator.validate(numbers);

        List<Integer> numberList = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());

        return new LottoTicket(numberList);
    }

    /**
     * 로또를 계산하여 일치하는 개수의 목록을 반환합니다.
     *
     * @param lottoTickets 구매한 로또 티켓
     * @param winningTicket 지난 주 당첨 로또 티켓
     * @return List<Integer>
     * */
    public List<Integer> calculate(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        LottoCalculator calculator = new LottoCalculator();

        return calculator.calculate(lottoTickets, winningTicket);
    }

    /**
     * 로또 결과 출력을 위한 데이터를 생성 합니다.
     * 반복하여 view 에 결과를 전달하여 텍스트를 출력합니다.
     *
     * @param matchingCounts 일치하는 숫자의 개수 목록
     * @param view 결과 view instance
     * */
    public void printWinningInformation(List<Integer> matchingCounts, OutputView view) {
        LottoCalculator calculator = new LottoCalculator();

        for (LottoPrize prize : LottoPrize.values()) {
            view.printWinningInformation(prize, calculator.getCountOfWin(matchingCounts, prize.getMatches()));
        }
    }

    /**
     * 로또 수익률을 계산 합니다.
     *
     * @param matchingCounts 일치하는 숫자의 개수 목록
     * @param money 구매 금액
     * */
    public Double getProfit(List<Integer> matchingCounts, int money) {
        LottoCalculator calculator = new LottoCalculator();

        int prizeMoney = calculator.getPrizeMoney(matchingCounts);

        double rateOfReturn = (double) prizeMoney / (double) money;

        return Math.floor(rateOfReturn * 1000) / 1000;
    }
}
