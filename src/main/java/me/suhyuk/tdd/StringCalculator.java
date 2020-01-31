package me.suhyuk.tdd;

class StringCalculator {

    private static final String defaultRegex = ",:";

    static int splitAndSum(String input) {
        return compositeSplitAndSum(input, defaultRegex);
    }

    static int splitAndPositiveSum(String input) {
        return positiveSplitAndSum(input, defaultRegex);
    }

    private static int positiveSplitAndSum(String input, String regex) {
        if (isNullOrEmpty(input)) return 0;
        return positiveSum(toPositives(input.split(String.format("[%s]", regex))));
    }

    private static String validateNumericString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        }
        return input;
    }

    private static int validatePositive(int number) {
        if (number < 0) throw new RuntimeException("입력 값이 음수입니다.");
        return number;
    }

    private static int compositeSplitAndSum(String input, String regex) {
        return isNullOrEmpty(input) ? 0 : integerSum(toInts(input.split(String.format("[%s]", regex))));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    static int splitAndSum(String input, String regex) {
        if (input == null || input.isEmpty()) return 0;
        return intSum(toInts(input.split(String.format("[%s]", regex))));
    }

    // 이렇게 하나의 일만 하는 함수는 재사용이 가능하다는 점이 아주 중요하다
    private static int[] toInts(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            ints[i] = Integer.parseInt(validateNumericString(values[i]));
        }
        return ints;
    }

    private static Positive[] toPositives(String[] values) {
        Positive[] positives = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            positives[i] = new Positive(values[i]);
        }
        return positives;
    }

    private static int strSum(String[] values) {
        int result = 0;
        for (String value : values)
            result += Integer.parseInt(validateNumericString(value));
        return result;
    }

    // 이렇게 validate 같은 기능이 들어가는 경우 클래스로 변환에 대한 냄새가 나는 것 같다
    private static int intSum(int[] values) {
        int result = 0;
        for (int value : values) result += validatePositive(value);
        return result;
    }

    private static int integerSum(int[] values) {
        Positive result = new Positive(0);
        for (int value : values) result.add(new Positive(value));
        return result.getNumber();
    }

    private static int positiveSum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers)
            result = result.add(number);
        return result.getNumber();
    }
}
