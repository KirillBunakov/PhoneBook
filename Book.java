import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Book {
  private HashMap<String, TreeSet<String>> phoneBook;

  public Book() {
    phoneBook = new HashMap<>();
  }

  public void addContact(String name, String phoneNumber) {
    TreeSet<String> phones = phoneBook.getOrDefault(name, new TreeSet<>());
    phones.add(phoneNumber);
    phoneBook.put(name, phones);
  }

  public HashMap<String, TreeSet<String>> getAllContacts() {
    return phoneBook;
  }

  private void printBook() {
    for (String name : phoneBook.keySet()) {
      TreeSet<String> phones = phoneBook.get(name);
      System.out.println(name + ": " + phones);
    }
  }

  public List<String> sortConactsByPhones() {
    List<Map.Entry<String, TreeSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
    sortedEntries.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size());

    List<String> result = new ArrayList<>();
    for (Map.Entry<String, TreeSet<String>> entry : sortedEntries) {
      result.add(entry.getKey() + ": " + entry.getValue());
    }

    return result;
  }

  public static void main(String[] args) {
    Book phoneBook = new Book();
    phoneBook.addContact("Ivan", "123456");
    phoneBook.addContact("Petr", "345678");
    phoneBook.addContact("Evgeny", "654321");
    phoneBook.addContact("Kirill", "765424");
    phoneBook.addContact("Kirill", "1243142");
    phoneBook.getAllContacts();
    phoneBook.printBook();
    System.out.println();
    System.out.println("Сортированный вывод");
    List<String> sortedContacts = phoneBook.sortConactsByPhones();
    for (String contact : sortedContacts) {
      System.out.println(contact);
    }
  }

}