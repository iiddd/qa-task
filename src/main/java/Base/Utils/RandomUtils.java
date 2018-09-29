package Base.Utils;

/**
 * This class is used to store random generators
 */

public class RandomUtils {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int EMAIL_RANDOM_STRING_COUNT = 7;

    public static String getRandomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String getRandomEmail() {
        return String.format("%s@ammail.ttt", getRandomAlphaNumeric(EMAIL_RANDOM_STRING_COUNT));
    }
}
