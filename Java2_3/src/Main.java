import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words  = new ArrayList<>(10);
        setWords(words);
        findUnique(words);

/*        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("as", "222");
        phoneBook.add("as", "233");
        phoneBook.add("bb", "111");
        phoneBook.add("bb", "112");
        phoneBook.add("df", "999");
        phoneBook.add("sd", "555");
        System.out.println(phoneBook.get("bb"));
*/
        PhoneBook2 phoneBook2 = new PhoneBook2();
        phoneBook2.add("as", "222");
        phoneBook2.add("as", "233");
        phoneBook2.add("bb", "111");
        phoneBook2.add("bb", "112");
        phoneBook2.add("df", "999");
        phoneBook2.add("sd", "555");
        System.out.println(phoneBook2.get("as"));


    }
    private static void setWords(List<String> words) {
        words.add("as");
        words.add("sb");
        words.add("bf");
        words.add("bb");
        words.add("cb");
        words.add("bb");
        words.add("cc");
        words.add("bc");
        words.add("cc");
        words.add("bb");
    }
    private static void findUnique(List<String> words) {
        Collections.sort(words);
        System.out.println(words);
        List<String> uniqueWords = new ArrayList<>();
        uniqueWords.add(words.get(0));
        int count = 1;
        for (int i = 1; i < words.size(); i++) {
            if(words.get(i) == uniqueWords.get(uniqueWords.size() - 1)) {
                count++;
            } else {
                System.out.println(uniqueWords.get(uniqueWords.size() - 1) + " " + count);
                uniqueWords.add(words.get(i));
                count = 1;
            }
        }
        System.out.println(uniqueWords);

    }

}
