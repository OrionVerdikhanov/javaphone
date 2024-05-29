import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addPhone(String name, String phone) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phone);
    }

    public List<Map.Entry<String, Set<String>>> getSortedEntries() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        return entries;
    }

    public void printPhoneBook() {
        getSortedEntries().forEach(entry -> 
            System.out.println("Name: " + entry.getKey() + ", Phones: " + entry.getValue())
        );
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhone("John Doe", "123456789");
        phoneBook.addPhone("John Doe", "987654321");
        phoneBook.addPhone("Jane Smith", "555555555");
        phoneBook.addPhone("Jane Smith", "444444444");
        phoneBook.addPhone("Jane Smith", "333333333");
        phoneBook.addPhone("Emily Davis", "111111111");
        phoneBook.printPhoneBook();
    }
}
