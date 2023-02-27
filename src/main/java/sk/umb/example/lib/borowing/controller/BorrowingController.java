package sk.umb.example.lib.borowing.controller;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;

public class BorrowingController {

  @Autowired
  private BorrowingService borrowingService;

  @GetMapping("/api/borrowing")
  public List<BorrowingDetailDTO> searchBorrowing(@RequestParam(required = false) String lastName) {
    System.out.println("Search borrowing called.");

    return Strings.isEmpty(lastName) ? borrowingService.getAllBorrowing()
      : borrowingService.searchBorrowingrByLastName(lastName);
  }

  @GetMapping("/api/borrowing/{borrowingId}")
  public BorrowingDetailDTO getBorrowing(@PathVariable Long borrowingId) {
    System.out.println("Get customer called.");
    return borrowingService.getBorrowingById(borrowingId);
  }

  @PostMapping("/api/borrowing")
  public Long createBorrowing(@RequestBody BorrowingRequestDTO borrowingRequestDTO) {
    System.out.println("Create borrowing called:");
    return borrowingService.createBorrowing(BorrowingRequestDTO);
  }

  @PutMapping("/api/borrowing/{borrowingId}")
  public void updateBorrowing(@PathVariable Long borrowingId, @RequestBody BorrowingRequestDTO borrowingRequestDTO) {
    System.out.println("Update borrowing called: ID = " + borrowingId);
    borrowingService.updateBorrowing(borrowingId, borrowingRequestDTO);
  }

  @DeleteMapping("/api/borrowing/{customerId}")
  public void deleteBorrowing(@PathVariable Long borrowingId) {
    System.out.println("Delete borrowing called: ID = " + borrowingId);
    borrowingService.deleteBorrowing(BorrowingId);
  }
}
