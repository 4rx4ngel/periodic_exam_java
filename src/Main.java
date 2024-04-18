import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        getWordCount("src/input.txt");
        System.out.println();
        System.out.println("Первое самое длинное слово: ");
        findLongestWords("src/input.txt");
        System.out.println();
        System.out.println("Частота слов:");
        wordFrequency("src/input.txt");

    }

    public static void getWordCount(String pathname) throws FileNotFoundException{
        File file = new File(pathname);
        Scanner scanner = new Scanner(file);
        int words = 0;

        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;
        }

        System.out.println("Количество слов: " + words);
        scanner.close();
    }

    public static String findLongestWords(String pathname) throws FileNotFoundException {
        String longest_word = "";
        String current;
        Scanner scanner = new Scanner(new File(pathname));
        while (scanner.hasNext()) {
            current = scanner.next();
            if (current.length() > longest_word.length()) {
                longest_word = current;
            }
        }
        System.out.println(longest_word);
        return longest_word;
    }
    public static void wordFrequency(String pathname) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(pathname));
        Map<String,Integer> wordFrequency = new HashMap<>();
        while (scanner.hasNext()){
            String word = scanner.next();
            wordFrequency.put(word,wordFrequency.getOrDefault(word, 0) + 1);
        }
        wordFrequency.forEach((word, frequency) -> System.out.println(word + " - " + frequency + " раз(а)"));

    }
}