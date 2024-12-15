class CharacterSetBuilder {

    private static final String LOWERCASE_EN = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_RU = "абвгдеёжзийклмнопрстуфхцчшщъыэюя";
    private static final String UPPERCASE_RU = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЭЮЯ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+=<>?/|[]{}";

    public static String buildCharacterSet(String useLowercase, String useUppercase, String useDigits, String useSpecialChars, String language) {
        StringBuilder characterSet = new StringBuilder();

        if (language.equals("русский") || language.equals("оба")) {
            if (useLowercase.equals("да") || useLowercase.equals("yes")) characterSet.append(LOWERCASE_RU);
            if (useUppercase.equals("да") || useUppercase.equals("yes")) characterSet.append(UPPERCASE_RU);
        }
        if (language.equals("английский") || language.equals("оба")) {
            if (useLowercase.equals("да") || useLowercase.equals("yes")) characterSet.append(LOWERCASE_EN);
            if (useUppercase.equals("да") || useUppercase.equals("yes")) characterSet.append(UPPERCASE_EN);
        }
        if (useDigits.equals("да") || useDigits.equals("yes")) characterSet.append(DIGITS);
        if (useSpecialChars.equals("да") || useSpecialChars.equals("yes")) characterSet.append(SPECIAL_CHARACTERS);

        return characterSet.toString();
    }
}