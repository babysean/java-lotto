package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    /** 로또 개수 */
    public static final int LOTTO_PRICE = 1000;

    /**
     * 구매할 금액을 입력 받아 반환합니다.
     *
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
     * 지난 주 당첨 번호를 입력 받아 반환 합니다.
     *
     * @return String[]
     * */
    public String[] inputLastWeekWinningLottoNumbers() {
        String scanValue;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        scanValue = scanner.nextLine();

        return scanValue
                .replace(" ", "")
                .split(",");
    }
}
