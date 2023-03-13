package sk.umb.example.lib.addres.persistence.entity;



@Entity(name = "address")
public class adressarEniti {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "city")
  private String city;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
