import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class DbManager {


    private String add = "INSERT INTO jdbc_telephonebook (first_name,last_name,phone,email) VALUES(?,?,?,?)";
    private String getAllContact="SELECT * FROM jdbc_telephonebook";
    private String update = "update jdbc_telephonebook set first_name = ? ,last_name = ?,phone=?,email = ? where id = ? ";
    private String delete = "delete from jdbc_telephonebook where id = ? ";
    Scanner scanner = new Scanner(System.in);

    private String getName="Введите имя: ";
    private String getNameContact="Введите номер контакта:";
    private String setName ="Изменить имя: ДА/НЕТ";
    private int index;





    public void add() throws SQLException {
        PreparedStatement pr = ConnectionDb.getNewConnection().prepareStatement(add);

        System.out.println("Введите имя:");
        String first_name = scanner.nextLine();
        pr.setString(1, first_name);

        System.out.println("Введите фамилию:");
        String last_name = scanner.nextLine();
        pr.setString(2, last_name);

        System.out.println("Введите телефон:");
        String phone = scanner.nextLine();
        pr.setString(3, phone);

        System.out.println("Введите email:");
        String email = scanner.nextLine();
        pr.setString(4, email);

        pr.executeUpdate();

    }


    public void getAllContact() throws SQLException{

        Statement statement = ConnectionDb.getNewConnection().createStatement();
        ResultSet rs = statement.executeQuery(getAllContact);
        while (rs.next()) {
            String str = rs.getString(1) + ") " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);

            System.out.println("Контакт № " + str);

        }
        System.out.println();
    }

    public void update() throws SQLException{

        PreparedStatement pr = ConnectionDb.getNewConnection().prepareStatement(update);
        System.out.println("Введите номер контакта:");
        int id = scanner.nextInt();
        pr.setInt(5, id);

        while (true) {
            System.out.println("Изменить имя: ДА/НЕТ");
            String name = scanner.nextLine();
            if ("да".equalsIgnoreCase(name)) {
                System.out.println("Введите имя:");
                String newName = scanner.nextLine();
                pr.setString(1, newName);
                break;
            } else if (name.equalsIgnoreCase("нет")) {
                break;
            } else {
                System.out.println("введите ДА или НЕТ");
                continue;
            }
        }

        while (true) {
            System.out.println("Изменить фамилию: ДА/НЕТ");
            String lastName = scanner.nextLine();
            if (lastName.equalsIgnoreCase("да")) {
                System.out.println("Введите фамилию:");
                String newLastName = scanner.nextLine();
                pr.setString(2, newLastName);
                break;
            } else if (lastName.equalsIgnoreCase("нет")) {

                break;
            } else {
                System.out.println("введите ДА или НЕТ:");
                continue;
            }
        }

        while (true) {
            System.out.println("Изменить номер телефона: ДА/НЕТ");

            String phone = scanner.nextLine();
            if ("да".equalsIgnoreCase(phone)) {
                System.out.println("Введите номер телефона:");
                String newPhone = scanner.nextLine();
                pr.setString(3, newPhone);
                break;
            } else if (phone.equalsIgnoreCase("нет")) {
                System.out.println("Изменить email: ДА/НЕТ");
                break;
            } else {
                System.out.println("введите ДА или НЕТ");
                continue;
            }
        }

        while (true) {
            System.out.println("Изменить email: ДА/НЕТ");

            String email = scanner.nextLine();
            if (email.equalsIgnoreCase("да")) {
                System.out.println("Введите email:");
                String newEmail = scanner.nextLine();
                pr.setString(4, newEmail);
                break;
            } else if (email.equalsIgnoreCase("нет")) {
                System.out.println("Контакт изменен");
                break;
            } else {
                System.out.println("введите ДА или НЕТ");
                continue;
            }
        }
        pr.executeUpdate();

    }

    public void delete() throws SQLException{

        PreparedStatement prSt = ConnectionDb.getNewConnection().prepareStatement(delete);
        System.out.println("Введите номер контакта: ");
        int id = scanner.nextInt();
        prSt.setInt(1, id);
        prSt.executeUpdate();
    }


    }







