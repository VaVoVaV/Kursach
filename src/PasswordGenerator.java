import java.security.SecureRandom;

class PasswordGenerator {

    private final SecureRandom random = new SecureRandom();

    public String generatePassword(int length, String characterSet) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }
        return password.toString();
    }

    public String getPasswordStrength(int length, String useLowercase, String useUppercase,
                                      String useDigits, String useSpecialChars) {
        int parameterCount = getParameterCount(useLowercase, useUppercase, useDigits, useSpecialChars);
        return evaluatePasswordStrength(length, parameterCount);
    }

    private int getParameterCount(String useLowercase, String useUppercase, String useDigits, String useSpecialChars) {
        int count = 0;
        if (useLowercase.equals("да") || useLowercase.equals("yes")) count++;
        if (useUppercase.equals("да") || useUppercase.equals("yes")) count++;
        if (useDigits.equals("да") || useDigits.equals("yes")) count++;
        if (useSpecialChars.equals("да") || useSpecialChars.equals("yes")) count++;
        return count;
    }

    private String evaluatePasswordStrength(int length, int parameterCount) {
        if (length < 50000) {
            return "Низкий уровень сложности";
        } else if ((length <= 400000 && parameterCount >= 4) || (length > 400000 && parameterCount >= 3)) {
            return "Высокий уровень сложности";
        } else {
            return "Средний уровень сложности";
        }
    }
}