package lotto.domain.purchaseStrategy;

import lotto.domain.LottoConsumer;
import lotto.domain.LottoTicketGenerator;
import lotto.dto.LottoPurchaseDto;

public interface PurchaseStrategy {

    void buyLottoTicket(LottoConsumer consumer, LottoPurchaseDto purchaseDto, LottoTicketGenerator generator);
}
