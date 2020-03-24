import java.io.*;
import java.util.*;

public class CountWord {

    private TreeMap<String, Integer> wordToCount = new TreeMap<>();

    private void readFile()throws IOException{

        System.out.println("Введите путь к файлу: ");
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String file = fileNameReader.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String str;
        StringBuilder sb = new StringBuilder();

        while ((str = reader.readLine()) != null) {
            sb.append(str.replaceAll("([\\p{Punct}…<<>><>—...])", "").toLowerCase() + " ");
        }

        String[] words = sb.toString().split("\\s+");

        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }

        fileNameReader.close();
        reader.close();
    }

    private void printWords(){
        System.out.println("Слова в алфавитном порядке: \n");

        for (String word : wordToCount.keySet())
            System.out.println(word);

        System.out.println("\n");
    }

    private void wordCount(){

        System.out.println("Частота повторений слов: \n");

        for (String word : wordToCount.keySet())
            System.out.println(word + " : " + wordToCount.get(word));

        System.out.println("\n");
    }

    private void maxWordCount(){

        System.out.println("Наиболее часто встречающиеся слова: \n");
        int maxValue = Collections.max(wordToCount.values());

        for (String word : wordToCount.keySet()){
            if(wordToCount.get(word) == maxValue){
                System.out.println(word + " : " + wordToCount.get(word));
            }
        }
    }


    public static void main(String[] args) throws IOException {

        CountWord countWord = new CountWord();

        countWord.readFile();
        countWord.printWords();
        countWord.wordCount();
        countWord.maxWordCount();
    }

}

