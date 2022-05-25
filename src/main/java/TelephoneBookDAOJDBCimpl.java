import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelephoneBookDAOJDBCimpl implements TelephoneBookDAO {
    Scanner scanner = new Scanner(System.in);
//    int id=scanner.nextInt();
//    String first_name=scanner.nextLine();
//    String last_name=scanner.nextLine();
//    String phone=scanner.nextLine();
//    String email=scanner.nextLine();


    private final String USER = "postgres";
    private final String PASSWORD = "root";
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String jdbcDiver = "org.postgresql.Driver";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public TelephoneBookDAOJDBCimpl() {
        try {
            Class.forName(jdbcDiver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addContact() {
//        public void addContact(String first_name, String last_name, String phone, String email) {
        String insert = "INSERT INTO jdbc_telephonebook (first_name,last_name,phone,email) VALUES (?,?,?,?)";
        System.out.println("Введи имя: ");
        String first_name = scanner.nextLine();
        System.out.println("Введи фамилию: ");
        String last_name = scanner.nextLine();
        System.out.println("Введи номер телефона ");
        String phone = scanner.nextLine();
        System.out.println("Введи email: ");
        String email = scanner.nextLine();

        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TelephoneBook> getAllContact() {
        List<TelephoneBook> list = new ArrayList<TelephoneBook>();
        String select = "SELECT * FROM jdbc_telephonebook";


        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                TelephoneBook tb = new TelephoneBook();
                tb.setId(resultSet.getInt("id"));
                tb.setFirst_name(resultSet.getString("first_name"));
                tb.setLast_name(resultSet.getString("last_name"));
                tb.setPhone(resultSet.getString("phone"));
                tb.setEmail(resultSet.getString("email"));
                list.add(tb);
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    @Override
    //public void update(int id, String first_name, String last_name, String phone, String email) {
    public void update() {
        String update = "update jdbc_telephonebook set first_name = ? ,last_name = ?,phone=?,email = ? where id = ?";
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(update);

            while (true) {

                System.out.println("Выберите номер контакта: ");
                int id = scanner.nextInt();
                ps.setInt(5, id);
                while (true) {

                    System.out.println("Выбери пункт " + "\n" + "1.Изменить имя: " + "\n" + "2.Изменить фамилию: " + "\n" + "3.Изменить телефон: " + "\n" + "4.Изменить email: "
                            + "\n" + "5.Выйти в передидущее меню"
                    );
                    int id_menu = scanner.nextInt();
                    if (id_menu == 1) {
                        System.out.println("Введите имя:");
                        String first_name = scanner.nextLine();
                        ps.setString(1, first_name);
                        break;
                    } else if (id_menu == 2) {
                        System.out.println("Введи фамилию: ");
                        String last_name = scanner.nextLine();
                        ps.setString(2, last_name);
                        break;
                    } else if (id_menu == 3) {
                        System.out.println("Введи номер телефона ");
                        String phone = scanner.nextLine();
                        ps.setString(3, phone);
                        break;
                    } else if (id_menu == 4) {
                        System.out.println("Введи email: ");
                        String email = scanner.nextLine();
                        ps.setString(4, email);
                        break;
                    } else if (id_menu == 5) {
                        continue;
                    } else {
                        System.err.println("пункта в меню не существует");
                    }
                }
                ps.executeUpdate();
                connection.commit();

            }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    @Override
    public void deleteContact() {
        System.out.println("Выберете контакт: ");
        int id = scanner.nextInt();
        String deleteOneCont = "delete from jdbc_telephonebook where id = ? ";
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(deleteOneCont);


            ps.setInt(1, id);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteAllContacts() {
        String deleteAll = "delete from jdbc_telephonebook";
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(deleteAll);
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


