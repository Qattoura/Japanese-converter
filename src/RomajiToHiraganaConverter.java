import java.util.HashMap;
import java.util.Map;

public class RomajiToHiraganaConverter {

    private static final Map<String, String> ROMAJI_TO_HIRAGANA_MAP = new HashMap<>();

    static {
        ROMAJI_TO_HIRAGANA_MAP.put("a", "あ");
        ROMAJI_TO_HIRAGANA_MAP.put("i", "い");
        ROMAJI_TO_HIRAGANA_MAP.put("u", "う");
        ROMAJI_TO_HIRAGANA_MAP.put("e", "え");
        ROMAJI_TO_HIRAGANA_MAP.put("o", "お");

        ROMAJI_TO_HIRAGANA_MAP.put("ka", "か");
        ROMAJI_TO_HIRAGANA_MAP.put("ki", "き");
        ROMAJI_TO_HIRAGANA_MAP.put("ku", "く");
        ROMAJI_TO_HIRAGANA_MAP.put("ke", "け");
        ROMAJI_TO_HIRAGANA_MAP.put("ko", "こ");

        ROMAJI_TO_HIRAGANA_MAP.put("sa", "さ");
        ROMAJI_TO_HIRAGANA_MAP.put("shi", "し");
        ROMAJI_TO_HIRAGANA_MAP.put("su", "す");
        ROMAJI_TO_HIRAGANA_MAP.put("se", "せ");
        ROMAJI_TO_HIRAGANA_MAP.put("so", "そ");

        ROMAJI_TO_HIRAGANA_MAP.put("ta", "た");
        ROMAJI_TO_HIRAGANA_MAP.put("chi", "ち");
        ROMAJI_TO_HIRAGANA_MAP.put("tsu", "つ");
        ROMAJI_TO_HIRAGANA_MAP.put("te", "て");
        ROMAJI_TO_HIRAGANA_MAP.put("to", "と");

        ROMAJI_TO_HIRAGANA_MAP.put("na", "な");
        ROMAJI_TO_HIRAGANA_MAP.put("ni", "に");
        ROMAJI_TO_HIRAGANA_MAP.put("nu", "ぬ");
        ROMAJI_TO_HIRAGANA_MAP.put("ne", "ね");
        ROMAJI_TO_HIRAGANA_MAP.put("no", "の");

        ROMAJI_TO_HIRAGANA_MAP.put("ha", "は");
        ROMAJI_TO_HIRAGANA_MAP.put("hi", "ひ");
        ROMAJI_TO_HIRAGANA_MAP.put("fu", "ふ");
        ROMAJI_TO_HIRAGANA_MAP.put("he", "へ");
        ROMAJI_TO_HIRAGANA_MAP.put("ho", "ほ");

        ROMAJI_TO_HIRAGANA_MAP.put("ma", "ま");
        ROMAJI_TO_HIRAGANA_MAP.put("mi", "み");
        ROMAJI_TO_HIRAGANA_MAP.put("mu", "む");
        ROMAJI_TO_HIRAGANA_MAP.put("me", "め");
        ROMAJI_TO_HIRAGANA_MAP.put("mo", "も");

        ROMAJI_TO_HIRAGANA_MAP.put("ya", "や");
        ROMAJI_TO_HIRAGANA_MAP.put("yu", "ゆ");
        ROMAJI_TO_HIRAGANA_MAP.put("yo", "よ");

        ROMAJI_TO_HIRAGANA_MAP.put("ra", "ら");
        ROMAJI_TO_HIRAGANA_MAP.put("ri", "り");
        ROMAJI_TO_HIRAGANA_MAP.put("ru", "る");
        ROMAJI_TO_HIRAGANA_MAP.put("re", "れ");
        ROMAJI_TO_HIRAGANA_MAP.put("ro", "ろ");

        ROMAJI_TO_HIRAGANA_MAP.put("wa", "わ");
        ROMAJI_TO_HIRAGANA_MAP.put("wo", "を");

        ROMAJI_TO_HIRAGANA_MAP.put("n", "ん");
    }

    public static String convertToHiragana(String romaji) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < romaji.length(); i++) {
            String currentChar = String.valueOf(romaji.charAt(i));
            String nextChar = i < romaji.length() - 1 ? String.valueOf(romaji.charAt(i + 1)) : null;
            String twoChars = nextChar != null ? currentChar + nextChar : null;

            if (ROMAJI_TO_HIRAGANA_MAP.containsKey(twoChars)) {
                sb.append(ROMAJI_TO_HIRAGANA_MAP.get(twoChars));
                i++;
            } else if (ROMAJI_TO_HIRAGANA_MAP.containsKey(currentChar)) {
                sb.append(ROMAJI_TO_HIRAGANA_MAP.get(currentChar));
            } else {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }
}