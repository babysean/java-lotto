package lotto.factory;

import lotto.LottoApplication;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoConsumer;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplicationFactory {
    private LottoConsumer createLottoConsumer() {
        return new LottoConsumer();
    }

    private InputView createInputView() {
        return new InputView();
    }

    private OutputView createOutputView() {
        return new OutputView();
    }

    private LottoService createLottoService() {
        LottoCalculator calculator = new LottoCalculator();
        return new LottoService(calculator);
    }

    /** LottoApplication 파라미터 생성을 위한 Factory */
    public LottoApplication createLottoApplication() {
        LottoConsumer consumer = createLottoConsumer();
        InputView inputView = createInputView();
        OutputView outputView = createOutputView();
        LottoService lottoService = createLottoService();
        return new LottoApplication(consumer, inputView, outputView, lottoService);
    }
}
