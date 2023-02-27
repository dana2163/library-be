package sk.umb.example.lib.borowing.server;

public class BorrowingDetailDTO {
    private Long id;
    private String BookDetailDTO;
    private String CustomerDetailDto;

    private String date;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getBookDetailDTO() {
      return BookDetailDTO;
    }

    public void setBookDetailDTO(String BookDetailDTO){
      this.BookDetailDTO = BookDetailDTO;
    }

    public String getCustomerDetailDto() {
      return CustomerDetailDto;
    }

    public void setCustomerDetailDto(String CustomerDetailDto) {
      this.CustomerDetailDto = CustomerDetailDto;
    }

    public String getDate() {
      return date;
    }

    public void setDate(String date) {
      this.date = date;
    }
  }


