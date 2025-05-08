import java.io.IOException;

import java.util.Scanner;

   public class Main {
        public static void main(String[] args) throws IOException {

            try {
                EnglishToIPAConverter englishConverter = new EnglishToIPAConverter();
                initial romajiConverter = new initial();
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("\n===== Text Converter Menu =====");
                    System.out.println("1. Romaji to Hiragana");
                    System.out.println("2. Romaji to Katakana");
                    System.out.println("3. Hiragana to Romaji");
                    System.out.println("4. Katakana to Romaji");
                    System.out.println("5. English to Katakana");
                    System.out.println("6. Exit");
                    System.out.print("Choose an option (1-6): ");

                    String choice = scanner.nextLine().trim();

                    if (choice.equals("6")) {
                        System.out.println("Exiting. Goodbye!");
                        break;
                    }

                    System.out.print("Enter text: ");
                    String input = scanner.nextLine().trim();

                    String result;
                    switch (choice) {
                        case "1":
                            result = romajiConverter.convertSentenceToHiragana(input);
                            System.out.println("Hiragana: " + result);
                            break;
                        case "2":
                            result = romajiConverter.convertSentenceToKatakana(input);
                            System.out.println("Katakana: " + result);
                            break;
                        case "3":
                            result = romajiConverter.hiragana_to_romaji(input); // handles both
                            System.out.println("Romaji: " + result);
                            break;
                        case "4":
                            result = romajiConverter.katakana_to_romaji(input); // same as above
                            System.out.println("Romaji: " + result);
                            break;
                        case "5":
                            result = englishConverter.final_final_final(input);
                            System.out.println("Katakana: " + result);
                            break;
                        default:
                            System.out.println("Invalid option. Please choose 1 to 6.");
                    }
                }

                scanner.close();
            } catch (IOException e) {
                System.err.println("Error initializing converter: " + e.getMessage());
            }

        }
    }