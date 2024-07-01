package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoConsumer;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.view.OutputView;

public class LottoService {

    /** 로또 계산기 */
    private final LottoCalculator calculator;

    /** 로또 번호 생성기 */
    private final LottoGenerator generator;

    public LottoService(LottoCalculator calculator, LottoGenerator generator) {
        this.calculator = calculator;
        this.generator = generator;
    }

    /**
     * 로또 티켓을 구매합니다.
     *
     * @param consumer 로또 구매자 객체
     * @param money    구매 금액
     */
    public void buyLotto(LottoConsumer consumer, int money) {
        consumer.buyLotto(money);
    }

    /**
     * 수동 로또 티켓을 구매합니다.
     *
     * @param consumer     LottoConsumer
     * @param lottoNumbers 로또 번호 목록
     */
    public void buyManualLotto(LottoConsumer consumer, List<String[]> lottoNumbers) {
        consumer.buyManualLotto(lottoNumbers);
    }

    /**
     * 로또 번호를 가공하여 LottoTicket 으로 만듭니다.
     *
     * @param numbers 로또 번호
     *
     * @return LottoTicket
     */
    public LottoTicket lottoNumberToTicket(String[] numbers) {
        return generator.manualGenerate(numbers);
    }

    /**
     * 로또를 계산하여 일치하는 개수의 목록을 반환합니다.
     *
     * @param lottoTickets  구매한 로또 티켓
     * @param winningTicket 지난 주 당첨 로또 티켓
     * @param bonusNumber   보너스 번호
     *
     * @return List<LottoPrize>
     */
    public List<LottoPrize> calculate(List<LottoTicket> lottoTickets, LottoTicket winningTicket, int bonusNumber) {
        List<LottoPrize> winningResult = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            LottoPrize result = lottoTicket.win(winningTicket, bonusNumber);
            winningResult.add(result);
        }

        this.removeNullList(winningResult);

        return winningResult;
    }

    /**
     * List<LottoPrize> 에서 null 값을 제거 합니다.
     *
     * @param lottoPrizes 로또 맞춘 결과 목록
     */
    private void removeNullList(List<LottoPrize> lottoPrizes) {
        lottoPrizes.removeIf(Objects::isNull);
    }

    /**
     * 로또 결과 출력을 위한 데이터를 생성 합니다.
     * 반복하여 view 에 결과를 전달하여 텍스트를 출력합니다.
     *
     * @param prizes 로또 결과 객체 목록
     * @param view   결과 view instance
     */
    public void printWinningInformation(List<LottoPrize> prizes, OutputView view) {
        for (LottoPrize prize : LottoPrize.values()) {
            view.printWinningInformation(prize, calculator.getCountOfWin(prizes, prize));
        }
    }

    /**
     * 로또 수익률을 계산 합니다.
     *
     * @param prizes 로또 결과 객체 목록
     * @param money  구매 금액
     */
    public Double getProfit(List<LottoPrize> prizes, int money) {
        int prizeMoney = calculator.getPrizeMoney(prizes);

        return calculator.getProfit(prizeMoney, money);
    }
}
