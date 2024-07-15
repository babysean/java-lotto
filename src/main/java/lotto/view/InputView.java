package lotto.view;

import static lotto.domain.LottoTicket.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    /**
     * 구매할 금액을 입력 받아 반환합니다.
     *
     * @return int
     */
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
     */
    public String[] inputLastWeekWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        String scanValue = scanner.nextLine();

        return scanValue.replace(" ", "")
                .split(",");
    }

    /**
     * 보너스 볼을 입력 받아 반환 합니다.
     *
     * @return int
     */
    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    /**
     * 수동으로 구매할 로또 수를 입력 받아 반환 합니다.
     *
     * @return int
     */
    public int inputManuallyPurchasedLottoTicketCount() {
        int scanValue;

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            Scanner scanner = new Scanner(System.in);
            scanValue = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        return scanValue;
    }

    /**
     * 수동으로 구매할 로또 번호를 입력 받아 반환 합니다.
     *
     * @param purchasedCount 수동 로또 구매 수
     *
     * @return List<String [ ]>
     */
    public List<String[]> inputManuallyPurchasedLottoTicketNumbers(int purchasedCount) {
        if (purchasedCount < 1) {
            return null;
        }

        List<String[]> numbers = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0 ; i < purchasedCount ; i++) {
            String scanValue = scanner.nextLine();
            numbers.add(scanValue.replace(" ", "")
                    .split(","));
        }

        return numbers;
    }
}
