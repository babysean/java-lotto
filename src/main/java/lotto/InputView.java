package lotto;

import java.util.Scanner;

public class InputView {
    Integer insertMoney() {
        Integer money = 0;

        while (money <= 0) {
            System.out.println("구입할 금액을 입력해 주세요.");

            money = new Scanner(System.in).nextInt();
        }

        return money;
    }

    String insertLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return new Scanner(System.in).nextLine();
    }
}
