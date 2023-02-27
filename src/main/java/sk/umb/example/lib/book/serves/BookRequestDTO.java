package sk.umb.example.lib.book.serves;

public class BookRequestDTO {
    private String firstName;
    private String lastName;

    private String emailContact;

    public static String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public static String getEmailContact() {
      return emailContact;
    }

    public void setEmailContact(String emailContact) {
      this.emailContact = emailContact;
    }
  }
