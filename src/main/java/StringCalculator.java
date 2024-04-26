import java.util.Arrays;

public class StringCalculator {

    private final String[] numbers;

    public StringCalculator(String stringNumber) {
        this.numbers = splitNumber(stringNumber);
    }

    /**
     * 문자열을 명시된 구분자에 맞게 split 하여 변수에 저장합니다.
     *
     * @author 박상훈
     * */
    private String[] splitNumber(String stringNumber) {
        if (!stringNumber.startsWith("//")) {
            throw new IllegalArgumentException("Invalid format: 구분자 형식이 맞지 않습니다.");
        }

        int delimiterEndIndex = stringNumber.indexOf('\n');
        String customDelimiter = stringNumber.substring(2, delimiterEndIndex);
        String customStringNumbers = stringNumber.substring(delimiterEndIndex + 1);

        return customStringNumbers.split(customDelimiter);
    }

    /**
     * 문자열에 음수가 포함되어 있는지, 형식이 맞는지 확인합니다.
     *
     * @author 박상훈
     * */
    private void checkFormat() {
        Arrays.stream(numbers).forEach(number -> {
            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("Invalid format: 음수가 포함 되어있습니다.");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid format: 형식이 맞지 않습니다.");
            }
        });
    }

    /**
     * split 된 문자 배열을 더합니다.
     *
     * @author 박상훈
     * */
    public int sum() {
        checkFormat();

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
