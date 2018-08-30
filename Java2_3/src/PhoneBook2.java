import java.util.*;

public class PhoneBook2 {
    private Map<String, Set<String>> phoneBook;
    public PhoneBook2() {
        phoneBook = new HashMap<>();
    }
    public void add(String name, String phone) {
        Set<String> phones;
        if(phoneBook.containsKey(name)) {
            phones = phoneBook.get(name);
        } else {
            phones = new HashSet<>();
        }
        phones.add(phone);
        phoneBook.put(name, phones);
    }
    public Set<String> get(String name) {
        return phoneBook.get(name);
    }
}
