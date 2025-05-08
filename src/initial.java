import java.util.HashMap;

public class initial {


//    hiragana
    final static String nn = "ん";
    final static String shada = "っ";

//    katakana
    final static String madd = "ー";
    final static String k_nn = "ン";
    final static String k_shada = "ッ";



    final static String romaji[] = {"a","i","u","e","o","ka","ki","ku","ke","ko","sa","shi","su","se","so","ta","chi","tsu","te","to","na","ni","nu","ne","no","ha","hi","fu","he","ho","ma","mi","mu","me","mo","ra","ri","ru","re","ro","ya","yu","yo","wa","wo","n","shada",
            "ga","gi","gu","ge","go","za","ji","zu","ze","zo","da","dji","dzu","de","do","ba","bi","bu","be","bo","pa","pi","pu","pe","po","kya","kyu","kyo","sha","shu","sho","cha","chu","cho","nya","nyu","nyo","hya","hyu","hyo","mya","myu","myo","rya","ryu","ryo",
            "gya","gyu","gyo","ja","ju","jo","bya","byu","byo","pya","pyu","pyo","wi", "we", "wo", "she", "che", "tsa", "tse", "tso", "ti", "tu", "fa", "fi", "fe", "fo", "je", "di", "du", "dyu","ー","-","la","ー"};



    final static String hiragana[] = {"あ","い","う","え","お","か","き","く","け","こ","さ","し","す","せ","そ","た","ち","つ","て","と","な","に","ぬ","ね","の","は","ひ","ふ","へ","ほ","ま","み","む","め","も","ら","り","る","れ","ろ","や","ゆ","よ","わ","を","ん","っ",
            "が","ぎ","ぐ","げ","ご","ざ","じ","ず","ぜ","ぞ","だ","ぢ","づ","で","ど","ば","び","ぶ","べ","ぼ","ぱ","ぴ","ぷ","ぺ","ぽ","きゃ","きゅ","きよ","しゃ","しゅ","しょ","ちゃ","ちゅ","ちょ","にゃ","にゅ","にょ","ひゃ","ひゅ","ひょ","みゃ","みゅ","みょ","りゃ","りゅ","りょ",
            "ぎゃ","ぎゅ","ぎょ","じゃ","じゅ","じょ","びゃ","びゅ","びょ","ぴゃ","ぴゅ","ぴょ"};


    final static String katakana[] = {"ア","イ","ウ","エ","オ","カ","キ","ク","ケ","コ","サ","シ","ス","セ","ソ","タ","チ","ツ","テ","ト","ナ","ニ","ヌ","ネ","ノ","ハ","ヒ","フ","ヘ","ホ","マ","ミ","ム","メ","モ","ラ","リ","ル","レ","ロ","ヤ","ユ","ヨ","ワ","ヲ","ン","ッ",
            "ガ","ギ","グ","ゲ","ゴ","ザ","ジ","ズ","ゼ","ゾ","ダ","ヂ","ヅ","デ","ド","バ","ビ","ブ","ベ","ボ","パ","ピ","プ","ペ","ポ","キャ","キュ","キョ","シャ","シュ","ショ","チャ","チュ","チョ","ニャ","ニュ","ニョ","ヒャ","ヒュ","ヒョ","ミャ","ミュ","ミョ","リャ","リュ","リョ",
            "ギャ","ギュ","ギョ","ジャ","ジュ","ジョ","ビャ","ビュ","ビョ","ピャ","ピュ","ピョ","ウィ", "ウェ", "ウォ", "シェ", "チェ", "ツァ", "ツェ", "ツォ", "ティ", "トゥ", "ファ", "フィ", "フェ", "フォ", "ジェ", "ディ", "ドゥ", "デュ","ー","ー","ッ","-"};





//    romaji to hiragana

    private String convertSingleRomajiToHiragana(String user_romaji) {
        String hiragana_string = new String();


        for (int i = 0; i < 105; i++)
        {
            if (user_romaji.equals(romaji[i]))
            {
                hiragana_string = hiragana[i];
                break;
            }
            else
            {
                hiragana_string=user_romaji;
            }
        }

        return hiragana_string;


    }


    private String convertWordToHiragana(String user_romaji)
    {
        //variables
        int word = user_romaji.length();
        int jiSize=0;
        char[] charstr;
        String sayo= user_romaji;
        charstr = sayo.toCharArray();
        String hira = new String();
        String b ;

//        word loop
        for (int j = 0; j < word; j++) {

            jiSize++;

//            n condition
            if (charstr[j] == 'n')
            {
                if (j == word -1)
                {
                    hira = hira + nn;
                    jiSize = 0;
                }

                else if (charstr[j+1] != 'a' & charstr[j+1] != 'i' & charstr[j+1] != 'u' & charstr[j+1] != 'e' & charstr[j+1] != 'o' & charstr[j+1] != 'y')
                {
                    hira = hira + nn;
                    jiSize = 0;
                }

            }
//            shada and the rest of char condition
            else if (charstr[j] == 'a' || charstr[j] == 'i' || charstr[j] == 'u' || charstr[j] == 'e' || charstr[j] == 'o')
            {
                if (jiSize >= 3 )
                {
                    if (charstr[j-jiSize+1] == charstr[j-jiSize+2])
                    {
                        hira = hira + shada;

                        char[] roma_sendarr = new char[jiSize-1];

                        for (int k = 0; k < jiSize-1; k++)
                        {
                            roma_sendarr[k] = charstr[j - jiSize +2 + k];
                        }
                        b = new String(roma_sendarr);
                        hira = hira + convertSingleRomajiToHiragana(b);
                        jiSize = 0;

                        continue;
                    }
                }

                    char[] roma_sendarr = new char[jiSize];
                    for (int k = 0; k < jiSize; k++)
                    {
                        roma_sendarr[k] = charstr[j - jiSize + 1 + k];
                    }
                    b = new String(roma_sendarr);
                    hira = hira + convertSingleRomajiToHiragana(b);
                    jiSize = 0;
            }
        }
        return hira;
    }


    public String convertSentenceToHiragana(String user_romaji)
    {
        String senStr[]= user_romaji.split("\\s+");
        String hira =new String();
//        wo\o checker
        for (int j = 0; j < senStr.length; j++)
        {
            if (senStr[j].equals("o") & j!= 0 & j != senStr.length - 1)
            {
                senStr[j] = "wo";
            }
        }
        for (int j = 0; j < senStr.length; j++)
        {
            hira = hira + convertWordToHiragana(senStr[j]);
        }
        return hira;
    }


    
//    romaji to katakana


    public String convertSingleRomajiToKatakana(String user_romaji) {
        String katakana_string = new String();


        for (int i = 0; i < 126; i++)
        {
            if (user_romaji.equals(romaji[i]))
            {
                katakana_string = katakana[i];
                break;
            }
            else
            {
                katakana_string=user_romaji;
            }
        }

        return katakana_string;


    }


    public String convertWordToKatakana(String user_romaji)
    {


        //variables
        int n2 = user_romaji.length();
        int jiSize=0;
        char[] charstr;
        String sayo= user_romaji;
        charstr = sayo.toCharArray();
        String kata = new String();
        String b ;

//        word loop
        for (int j = 0; j < n2; j++) {

            jiSize++;

//            maad cond
            if (charstr[j] == '-' || charstr[j] == 'ー')
            {
                kata = kata + madd;
                jiSize = 0;
                continue;
            }
//            n cond
            if (charstr[j] == 'n')
            {


                if (j == n2-1)
                {
                    kata = kata + k_nn;
                    jiSize = 0;
                }


                else if (charstr[j+1] != 'a' & charstr[j+1] != 'i' & charstr[j+1] != 'u' & charstr[j+1] != 'e' & charstr[j+1] != 'o' & charstr[j+1] != 'y')
                {
                    kata = kata + k_nn;
                    jiSize = 0;
                }

            }

//            shada and the rest of char cond
            else if (charstr[j] == 'a' || charstr[j] == 'i' || charstr[j] == 'u' || charstr[j] == 'e' || charstr[j] == 'o')
            {

                if (jiSize >= 3 )
                {
                    if (charstr[j-jiSize+1] == charstr[j-jiSize+2])
                    {
                        kata = kata + k_shada;

                        char[] roma_sendarr = new char[jiSize-1];

                        for (int k = 0; k < jiSize-1; k++)
                        {
                            roma_sendarr[k] = charstr[j - jiSize +2 + k];
                        }

                        b = new String(roma_sendarr);
                        kata = kata + convertSingleRomajiToKatakana(b);
                        jiSize = 0;

                        continue;

                    }

                }

                char[] roma_sendarr = new char[jiSize];


                for (int k = 0; k < jiSize; k++) {
                    roma_sendarr[k] = charstr[j - jiSize + 1 + k];
                }

                b = new String(roma_sendarr);
                kata = kata + convertSingleRomajiToKatakana(b);
                jiSize = 0;


            }

        }


        return kata;

    }


    public String convertSentenceToKatakana(String user_romaji)
    {
        String senStr[]= user_romaji.split(" ");
        String kata =new String();

        for (int j = 0; j < senStr.length; j++)

        {

            kata = kata + convertWordToKatakana(senStr[j]);

        }


        return kata;
    }



    public String hiragana_to_romaji(String hiraganaword) {
        HashMap<String, String> hiraganatoromajimap = new HashMap<>();
        char[] icoloumn = {'き', 'し', 'ち', 'に', 'ひ', 'み', 'り', 'ぎ', 'じ', 'び', 'ぴ'};
        char[] hiraganaword1 = hiraganaword.toCharArray();
        StringBuilder strbui = new StringBuilder();

        for (int i = 0; i < 105; i++) {
            hiraganatoromajimap.put(hiragana[i], romaji[i]);
        }

        for (int i = 0; i < hiraganaword1.length; i++) {
            boolean found = false;
            for (char c : icoloumn) {
                if (hiraganaword1[i] == c) {
                    if (i + 1 < hiraganaword1.length) {
                        // Check if the next character forms a valid pair (e.g., き + ゃ = きゃ)
                        String pair = String.valueOf(hiraganaword1[i]) + hiraganaword1[i + 1];
                        if (hiraganatoromajimap.containsKey(pair)) {
                            strbui.append(hiraganatoromajimap.get(pair));
                            i++; // Skip the next character
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (!found) {
                // Process single character
                strbui.append(hiraganatoromajimap.get(String.valueOf(hiraganaword1[i])));
            }
        }
        return strbui.toString();
    }

    public String katakana_to_romaji(String katakanaword) {
        HashMap<String, String> katakanatoromajimap = new HashMap<>();
        char[] icoloumn = {'キ', 'シ', 'チ', 'ニ', 'ヒ', 'ミ', 'リ', 'ビ', 'ギ', 'ジ', 'ピ'};
        char[] katakanaword1 = katakanaword.toCharArray();
        StringBuilder strbui = new StringBuilder();

        for (int i = 0; i < 127; i++) {
            katakanatoromajimap.put(katakana[i], romaji[i]);
        }

        for (int i = 0; i < katakanaword1.length; i++) {
            boolean found = false;
            for (char c : icoloumn) {
                if (katakanaword1[i] == c) {
                    if (i + 1 < katakanaword1.length) {
                        String pair = String.valueOf(katakanaword1[i]) + katakanaword1[i + 1];
                        if (katakanatoromajimap.containsKey(pair)) {
                            strbui.append(katakanatoromajimap.get(pair));
                            i++; // Skip next character
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (!found) {
                strbui.append(katakanatoromajimap.get(String.valueOf(katakanaword1[i])));
            }
        }
        return strbui.toString();
    }

}
