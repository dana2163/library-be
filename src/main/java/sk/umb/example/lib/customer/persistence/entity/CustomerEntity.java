package sk.umb.example.lib.customer.persistence.entity;

  import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.Id;
  import jakarta.persistence.ManyToOne;
  import sk.umb.example.library.address.persistence.entity.AddressEntity;

@Entity(name = "customer")
public class CustomerEntity {
  @Id
  @GeneratedValue
  private Long id;

  private String firstName;

  private String lastName;

  private String emailContact;

  @ManyToOne
  private AddressEntity address;

  public AddressEntity getAddress() {
    return address;
  }

  public void setAddress(AddressEntity address) {
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
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

  public String getEmailContact() {
    return emailContact;
  }

  public void setEmailContact(String emailContact) {
    this.emailContact = emailContact;
  }
}
