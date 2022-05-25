import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDb {
    private  Scanner scanner = new Scanner(System.in);
    //private String update = "update jdbc_telephonebook set first_name = ? ,last_name = ?,phone=?,email = ? where id = ? ";


//    private String getName = "Введите имя: ";
//    private String getNameContact = "Введите номер контакта:";
//    private String setName = "Изменить имя: ДА/НЕТ";
//    private int index;
    private  PreparedStatement pr;


    public  void updateDb(String update, String getNameContact, String getName, String setName, int index) throws SQLException {
        pr = ConnectionDb.getNewConnection().prepareStatement(update);
        System.out.println(getNameContact);
        int id = scanner.nextInt();
        pr.setInt(5, id);

        while (true) {
            System.out.println(getName);
            String name = scanner.nextLine();
            if ("да".equalsIgnoreCase(name)) {
                System.out.println(setName);
                String newName = scanner.nextLine();
                pr.setString(index, newName);
                break;
            } else if (name.equalsIgnoreCase("нет")) {
                break;
            } else {
                System.out.println("введите ДА или НЕТ");
                continue;
            }
        }
    }



}
