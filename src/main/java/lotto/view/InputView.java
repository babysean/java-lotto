package lotto.view;

import lotto.domain.LastWeekLottoNumberValidator;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.service.LottoService.*;

public class InputView {
    /**
     * 구매할 금액을 입력 받아 반환합니다.
     *
     * @author 박상훈
     * @return int
     * */
    public int insertMoney() {
        int scanValue;

        System.out.println("구입할 금액을 입력해 주세요.");

        try {
            Scanner scanner = new Scanner(System.in);
            scanValue = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (scanValue < LOTTO_PRICE) {
            throw new IllegalArgumentException("금액은 1000과 같거나 커야 합니다.");
        }

        return scanValue;
    }

    /**
     * 지난 주 당첨 번호를 입력 받아 반환합니다.
     *
     * @author 박상훈
     * @return List
     * */
    public List<Integer> insertLastWeekWinningNumber() {
        String scanValue;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        scanValue = scanner.nextLine();
        String[] lastWeekWinningNumber = scanValue
                .replace(" ", "")
                .split(",");

        // 유효성 체크
        new LastWeekLottoNumberValidator(lastWeekWinningNumber);

        return Arrays.stream(lastWeekWinningNumber).map(Integer::parseInt).collect(Collectors.toList());
    }
}
