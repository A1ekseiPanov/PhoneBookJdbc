import java.util.List;

public interface TelephoneBookDAO {

    //void addContact(String first_name, String last_name, String phone, String email);
    void addContact();

    List<TelephoneBook> getAllContact();

    void update();
    //void update(int id, String first_name, String last_name, String phone, String email);

    //void deleteContact(int id);
    void deleteContact();

    void deleteAllContacts();


}
