package lotto;

import lotto.domain.LottoConsumer;
import lotto.domain.LottoTicket;
import lotto.factory.LottoApplicationFactory;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    private final InputView inputView;

    private final OutputView outputView;

    private final LottoService lottoService;

    public LottoApplication(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoConsumer consumer = new LottoConsumer();

        // 로또 구매 금액 입력 및 구매
        int money = inputView.insertMoney();
        lottoService.buyLotto(consumer, money);

        // 로또 구매 정보 출력
        outputView.printLottoTicketsInformation(consumer.getLottoTickets());

        // 지난 주 당첨번호 입력
        String[] LastWeekWinningNumbers = inputView.inputLastWeekWinningLottoNumbers();
        LottoTicket winningTicket = lottoService.winningNumberToTicket(LastWeekWinningNumbers);

        // 로또 계산
        List<Integer> winningCounts = lottoService.calculate(consumer.getLottoTickets(), winningTicket);

        // 로또 결과 출력
        outputView.printResultTitle();
        lottoService.printWinningInformation(winningCounts, outputView);

        // 수익률 출력
        double profit = lottoService.getProfit(winningCounts, money);
        outputView.printProfit(profit);
    }

    public static void main(String[] args) {
        LottoApplicationFactory factory = new LottoApplicationFactory();
        LottoApplication lottoApplication = factory.createLottoApplication();
        lottoApplication.run();
    }
}
