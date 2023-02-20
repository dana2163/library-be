package sk.umb.example.lib.book.controller;

import org.springframework.web.bind.annotation.*;


class BookController {

    @GetMapping("/api/books")
    public void listResource(@RequestParam(required = false, name = "paramName") String paramValue) {
        System.out.println("List Resource with parameter: " + paramValue);
    }

    @GetMapping("/api/books/{bookId}")
    public void retrieveDetail(@PathVariable Long bookId) {
        System.out.println("Book detail.");
    }

    @PostMapping("/api/books")
    public void createResourcer() {
        System.out.println("Create book named:");
    }

    @PutMapping("/api/books/{bookId}")
    public void updateResource(@PathVariable Long bookId) {
        System.out.println("Update book called: ID = " + bookId);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteCustomer(@PathVariable Long bookId) {
        System.out.println("Delete book called: ID = " + bookId);
    }
}
