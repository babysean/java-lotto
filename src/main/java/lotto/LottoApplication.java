package lotto;

import lotto.domain.LottoCalculator;
import lotto.domain.LottoConsumer;
import lotto.domain.LottoTicket;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    private final LottoConsumer consumer;

    private final InputView inputView;

    private final OutputView outputView;

    public LottoApplication(LottoConsumer consumer, InputView inputView, OutputView outputView) {
        this.consumer = consumer;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoService lottoService = new LottoService(new LottoCalculator());

        // 로또 구매 금액 입력 및 구매
        int money = inputView.insertMoney();
        List<LottoTicket> lottoTickets = lottoService.buyLotto(consumer, money);

        // 로또 구매 정보 출력
        outputView.printLottoTicketsInformation(lottoTickets);

        // 지난 주 당첨번호 입력
        String[] LastWeekWinningNumbers = inputView.inputLastWeekWinningLottoNumbers();
        LottoTicket winningTicket = lottoService.winningNumberToTicket(LastWeekWinningNumbers);

        // 로또 계산
        List<Integer> winningCounts = lottoService.calculate(lottoTickets, winningTicket);

        // 로또 결과 출력
        outputView.printResultTitle();
        lottoService.printWinningInformation(winningCounts, outputView);

        // 수익률 출력
        double profit = lottoService.getProfit(winningCounts, money);
        outputView.printProfit(profit);
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication(new LottoConsumer(), new InputView(), new OutputView());
        lottoApplication.run();
    }
}
