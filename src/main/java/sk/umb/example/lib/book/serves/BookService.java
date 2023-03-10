package sk.umb.example.lib.book.serves;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final AtomicLong lastIndex = new AtomicLong(0);

    private final Map<Long, BookDetailDTO> bookDatabase = new HashMap();

    public List<BookDetailDTO> getAllCustomers() {
        return new ArrayList<>(bookDatabase.values());
    }

    public List<BookDetailDTO> searchCustomerByLastName(String lastName) {
        return bookDatabase.values().stream()
                                        .filter(dto -> lastName.equals(dto.getLastName()))
                                        .toList();
    }

    public BookDetailDTO getBookById(Long bookId) {
        validateBookrExists(bookId);

        return bookDatabase.get(bookId);
    }

    public Long createBook(BookRequestDTO bookRequestDTO) {
        BookDetailDTO bookDetailDTO = mapToBookDetailDTO(lastIndex.getAndIncrement(),
                                                                    bookRequestDTO);

        bookDatabase.put(bookDetailDTO.getId(), bookDetailDTO);

        return bookDetailDTO.getId();
    }

    private static BookDetailDTO mapToCustomerDetailDTO(Long index, BookRequestDTO bookRequestDTO) {
        BookDetailDTO dto = new BookDetailDTO();

        dto.setId(index);
        dto.setLastName(BookRequestDTO.getLastName());
        dto.setFirstName(BookRequestDTO.getFirstName());
        dto.setEmailContact(BookRequestDTO.getEmailContact());
        dto.setTitle(bookRequestDTO.getTitle());
        dto.setCount(bookRequestDTO.getCount());
        dto.setIsbn(bookRequestDTO.getIsbn());
        dto.setCategoryIds(index);

        return dto;
    }

    public void updateCBook(Long bookId, BookRequestDTO BookRequestDTO) {
        validateBookExists(bookId);

        BookDetailDTO bookDetailDTO = bookDatabase.get(bookId);

        if (! Strings.isEmpty(BookRequestDTO.getFirstName())) {
            BookDetailDTO.setFirstName(BookRequestDTO.getFirstName());
        }

        if (! Strings.isEmpty(BookRequestDTO.getLastName())) {
            BookDetailDTO.setLastName(BookRequestDTO.getLastName());
        }

        if (! Strings.isEmpty(BookRequestDTO.getEmailContact())) {
            BookDetailDTO.setEmailContact(BookRequestDTO.getEmailContact());
        }
    }

    private void validateBookExists(Long bookId) {
        if (! bookDatabase.containsKey(bookId)) {
            throw new IllegalArgumentException("BookId: " + bookId + " does not exists!");
        }
    }

    public void deleteBook(Long bookId) {
        bookDatabase.remove(bookId);
    }
}
