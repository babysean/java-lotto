package lotto.service;

import lotto.domain.*;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    /** 로또 계산기 */
    LottoCalculator calculator;

    public LottoService(LottoCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * 로또 티켓을 구매합니다.
     *
     * @param consumer LottoConsumer
     * @param money 구매 금액
     * */
    public void buyLotto(LottoConsumer consumer, int money) {
        consumer.buyLotto(money);
    }

    /**
     * 지난 주 당첨 로또를 가공하여 LottoTicket 으로 만듭니다.
     *
     * @param numbers 지난 주 당첨 번호
     * @return LottoTicket
     * */
    public LottoTicket winningNumberToTicket(String[] numbers) {
        List<Integer> lottoNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 유효성 체크
        LastWeekLottoValidator validator = new LastWeekLottoValidator();
        validator.winningNumbersValidation(lottoNumbers);

        return new LottoTicket(lottoNumbers);
    }

    /**
     * 로또를 계산하여 일치하는 개수의 목록을 반환합니다.
     *
     * @param lottoTickets 구매한 로또 티켓
     * @param winningTicket 지난 주 당첨 로또 티켓
     * @param bonusNumber 보너스 번호
     * @return List<LottoResult>
     * */
    public List<LottoResult> calculate(List<LottoTicket> lottoTickets, LottoTicket winningTicket, int bonusNumber) {
        List<LottoResult> winningResult = new ArrayList<>();

        for(LottoTicket lottoTicket : lottoTickets) {
            LottoResult result = lottoTicket.win(winningTicket, bonusNumber);
            winningResult.add(result);
        }

        return winningResult;
    }

    /**
     * 로또 결과 출력을 위한 데이터를 생성 합니다.
     * 반복하여 view 에 결과를 전달하여 텍스트를 출력합니다.
     *
     * @param lottoResults 일치하는 숫자의 개수 목록
     * @param view 결과 view instance
     * */
    public void printWinningInformation(List<LottoResult> lottoResults, OutputView view) {
        for (LottoPrize prize : LottoPrize.values()) {
            view.printWinningInformation(prize, calculator.getCountOfWin(lottoResults, prize.getMatches(), prize.getBonusNumber()));
        }
    }

    /**
     * 로또 수익률을 계산 합니다.
     *
     * @param results 로또 결과 객체
     * @param money 구매 금액
     * */
    public Double getProfit(List<LottoResult> results, int money) {
        int prizeMoney = calculator.getPrizeMoney(results);

        return calculator.getProfit(prizeMoney, money);
    }
}
