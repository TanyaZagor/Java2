import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Person> phoneBook;

    public PhoneBook() {
        phoneBook = new ArrayList<>();
    }
    public void add(String name, String phone) {
        phoneBook.add(new Person(name, phone));
    }

    public List<String> get(String name) {
        List<String> phones = new ArrayList<>();
        for (Person person : phoneBook) {
            if (person.getName().equals(name)) {
                System.out.println(phones.add(person.getPhone()));
            }
        }
        return phones;
    }

}
