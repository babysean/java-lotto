import java.util.Arrays;

public class StringCalculator {

    private final String stringNumbers;

    private final String[] splitNumbers;

    public StringCalculator(String stringNumbers) {
        this.stringNumbers = stringNumbers;
        this.splitNumbers = splitNumbers();
    }

    // 문자열을 명시된 구분자에 맞게 split 하여 변수에 저장합니다.
    private String[] splitNumbers() {
        if (!stringNumbers.startsWith("//")) {
            throw new RuntimeException("Invalid format: 구분자 형식이 맞지 않습니다.");
        }

        int delimiterEndIndex = stringNumbers.indexOf('\n');
        String customDelimiter = stringNumbers.substring(2, delimiterEndIndex);
        String customStringNumbers = stringNumbers.substring(delimiterEndIndex + 1);

        return customStringNumbers.split(customDelimiter);
    }

    // 문자열에 음수가 포함되어 있는지, 형식이 맞는지 확인합니다.
    private void checkFormat() {
        Arrays.stream(splitNumbers).forEach(number -> {
            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new NumberFormatException("Invalid format: 음수가 포함 되어있습니다.");
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid format: 형식이 맞지 않습니다.");
            }
        });
    }

    // split 된 문자 배열을 더합니다.
    public int sum() {
        checkFormat();

        return Arrays.stream(splitNumbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}