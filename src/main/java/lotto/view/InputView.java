package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    /**
     * 구매할 금액을 입력 받아 반환합니다..
     *
     * @author 박상훈
     * @return Integer
     * */
    public Integer insertMoney() {
        int money;
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입할 금액을 입력해 주세요.");

        try {
            money = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자만 입력할 수 있습니다.");
        }

        if (money < 1000) {
            throw new IllegalArgumentException("금액은 1000과 같거나 커야 합니다.");
        }

        return money;
    }

    /**
     * 지난 주 당첨 번호를 입력 받아 반환합니다.
     *
     * @author 박상훈
     * @return String
     * */
    public String insertLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
