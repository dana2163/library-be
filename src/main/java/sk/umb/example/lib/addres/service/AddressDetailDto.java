package sk.umb.example.lib.addres.service;

public class AddressDetailDto {
  private Long id;

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