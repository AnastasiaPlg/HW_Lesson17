package task2;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<String> documentNumber = new ArrayList<>();
    private List<String> email = new ArrayList<>();
    private List<String> phoneNumber = new ArrayList<>();

    public List<String> getDocumentNumber() {
        return documentNumber;
    }

    public List<String> getEmail() {
        return email;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void addToList(String information) {
        if (information.matches("\\+\\(\\d{2}\\)\\d{7}")) {
            phoneNumber.add(information);
        } else if (information.matches("(\\d{4}-[A-Za-zА-Яа-я]{3}-){2}(\\d[A-Za-zА-Яа-я]){2}")) {
            documentNumber.add(information);
        } else if (information.matches("([A-Za-z0-9]+\\p{Punct}*[A-Za-z0-9]*)@([a-z]{3,10})\\.[a-z]{2,5}")) {
            email.add(information);
        }
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentNumber=" + documentNumber +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
