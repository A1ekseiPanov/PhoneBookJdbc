import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        TelephoneBookDAO telephoneBookDAO = new TelephoneBookDAOJDBCimpl();
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.println("Добро пожаловать в телефонную книгу");
            System.out.println("1.Посмотреть список контактов");
            System.out.println("2.Добавить контакт");
            System.out.println("3.Редактировать контакт");
            System.out.println("4.Удалить контакт");
            System.out.println("5.Удалить все контакты");
            System.out.println("6.Выход");

            System.out.println("Выберете пункт: ");
            int id_menu = console.nextInt();
            if (id_menu == 1) {
                System.out.println(telephoneBookDAO.getAllContact().toString());
                ;
            } else if (id_menu == 2) {
                telephoneBookDAO.addContact();
            } else if (id_menu == 3) {
                telephoneBookDAO.update();
            } else if (id_menu == 4) {
                telephoneBookDAO.deleteContact();
            } else if (id_menu == 5) {
                telephoneBookDAO.deleteAllContacts();
                ;
            } else if (id_menu == 6) {
                System.exit(0);
            } else {
                System.err.println("пункта в меню не существует");
            }


        }
    }
}
