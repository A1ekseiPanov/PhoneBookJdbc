public class TelephoneBook {
    private int id;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;

    public TelephoneBook(){

    }

    public TelephoneBook(String first_name, String last_name, String phone, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Контакт №" + id +
                ", Имя: " + first_name +
                ", Фамилия: " + last_name +
                ", номер телефона: " + phone  +
                ", email: " + email +'\n';
    }
}