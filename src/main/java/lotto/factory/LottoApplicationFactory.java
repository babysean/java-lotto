package lotto.factory;

import lotto.LottoApplication;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplicationFactory {

    private InputView createInputView() {
        return new InputView();
    }

    private OutputView createOutputView() {
        return new OutputView();
    }

    private LottoService createLottoService() {
        LottoCalculator calculator = new LottoCalculator();
        LottoGenerator generator = new LottoGenerator();

        return new LottoService(calculator, generator);
    }

    /** LottoApplication 파라미터 생성을 위한 Factory */
    public LottoApplication createLottoApplication() {
        InputView inputView = createInputView();
        OutputView outputView = createOutputView();
        LottoService lottoService = createLottoService();

        return new LottoApplication(inputView, outputView, lottoService);
    }
}
