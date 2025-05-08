import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
    public class EnglishToIPAConverter {

        private static final String DICTIONARY_FILE_PATH = "file.txt";
        private static final String cmu_romaji_FILE_PATH = "cmu_romaji.txt";
        private static final String kafile = "kafile.txt";

        private Map<String, String> dictionary;
        private Map<String, String> cmu_dict;
        public Map<String, String> kamap;
        private initial i1;


        public EnglishToIPAConverter() throws IOException {
            dictionary = new HashMap<>();
            cmu_dict = new HashMap<>();
            kamap = new HashMap<>();
            i1 = new initial();
            loadDictionary(dictionary, "file.txt");
            loadDictionary(cmu_dict, "cmu_romaji.txt");
            loadDictionary(kamap, "kafile.txt");

        }

        private void loadDictionary(Map load_map, String file_Path) throws IOException {

            BufferedReader br = new BufferedReader(new FileReader(file_Path));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(";;;")) {
                    continue; // skip comments
                }
                String[] parts = line.split("\\s+");
                String word = parts[0].toLowerCase().replace('_',' ');
                word = word;
                StringBuilder ipaBuilder = new StringBuilder();
                for (int i = 1; i < parts.length; i++) {
                    ipaBuilder.append(parts[i]);
                    if (i < parts.length - 1) {
                        ipaBuilder.append(" ");
                    }
                }
                String ipa = ipaBuilder.toString();
                load_map.put(word, ipa);
            }
            br.close();
        }

        private String convertToIPA(String word) {
            String ipa = dictionary.get(word.toLowerCase());
            return ipa != null ? ipa : "404";
        }

        //
        private String kafile_searcher(String enka)
        {
            String katakana = kamap.get(enka.toLowerCase());
            return katakana != null ? katakana : "404";
        }



//    from english to katakana


        //replace character from cmu to  primary romaji
        private String character_replacer(String cmu)
        {
            cmu = cmu.toLowerCase();

            String senStr[]= cmu.split("\\s+");
            String romaji_phase1 =new String();
            for (int j = 0; j < senStr.length; j++)
            {
                if (cmu_dict.containsKey(senStr[j]))
                {
                    romaji_phase1 = romaji_phase1 + cmu_dict.get(senStr[j]);
                }
            }



            return romaji_phase1;
        }

        //final romaji form
        private String vowels_checker(String replaced)
        {

            String final_romaji = new String();
            char wordstr[] = replaced.toCharArray();

            for (int i = 0; i < replaced.length(); i++)
            {
                if (wordstr[i] == 'a' || wordstr[i] == 'i' || wordstr[i] == 'u' || wordstr[i] == 'e'|| wordstr[i] == 'o' || wordstr[i] == 'n' || wordstr[i] == '-')
                    final_romaji = final_romaji + wordstr[i];

                else if (i == replaced.length()-1)
                {
                    if (wordstr[i] == 't' || wordstr[i] == 'd')
                        final_romaji = final_romaji + wordstr[i] + 'o';
                    else
                        final_romaji = final_romaji + wordstr[i] + 'u';
                }

                else if(wordstr[i+1] != 'a' & wordstr[i+1] != 'i' & wordstr[i+1] != 'u' & wordstr[i+1] != 'e' & wordstr[i+1] != 'o' )
                {
                    if (wordstr[i] == 't' || wordstr[i] == 'd')
                        final_romaji = final_romaji + wordstr[i] + 'o';
                    else
                        final_romaji = final_romaji + wordstr[i] + 'u';
                }

                else
                    final_romaji = final_romaji + wordstr[i];
            }


            return final_romaji;
        }

        //romaji pattern checker
        private String namatt(String word)
        {
            String S1 = new String();
            S1 = vowels_checker(word);
            return S1.equals(word) ? S1 : "404";

        }

        //convert from english (cmu) to katakana converter
        private String eng_to_katakana_oneWord(String engWord)
        {
            engWord = convertToIPA(engWord);
            if (engWord.equals("404"))
                return "404";
            engWord = character_replacer(engWord);
            engWord = vowels_checker(engWord);
            engWord = i1.convertSentenceToKatakana(engWord);
            return engWord;
        }

        private String final_final(String enka)
        {
            enka = enka.toLowerCase();
            String final_string = new String();

//            file checker
            final_string = kafile_searcher(enka);
            if (!final_string.equals("404"))
                return i1.convertSentenceToKatakana(final_string.toLowerCase());

//          namat checker
            final_string = namatt(enka);
            if (!final_string.equals("404"))
                return i1.convertSentenceToKatakana(final_string);

//          english to katakana converter
            final_string = eng_to_katakana_oneWord(enka);
            if (!final_string.equals("404"))
                return final_string ;
            else
                return "not found" ;


        }


        public String final_final_final(String enka)
        {
            enka = enka.toLowerCase();
            String senStr[]= enka.split(" ");
            String kata =new String();

            kata = kafile_searcher(enka);
            if (!kata.equals("404"))
                return i1.convertSentenceToKatakana(kata);


            else {
                kata = "";
                for (int j = 0; j < senStr.length; j++) {
                    kata = kata + final_final(senStr[j]);
                    if (j != senStr.length - 1)
                        kata = kata + "・";

                }

                return kata;
            }
        }

    }


