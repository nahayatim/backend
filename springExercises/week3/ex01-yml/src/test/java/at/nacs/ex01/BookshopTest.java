package at.nacs.ex01;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertThat;

@SpringBootTest
class BookshopTest {

    @Autowired
    Bookshop bookshop;

    @ParameterizedTest
    @CsvSource({"harrypotter,3", "thefoundation,2", "thelordOftherings,4"})
    void setBooks(String bookName, Integer copies) {
        Map<String, Integer> books = bookshop.getBooks();
        Assertions.assertTrue(books.containsKey(bookName) && books.containsValue(copies));
        assertThat(books, IsMapContaining.hasEntry(bookName, copies));
    }
}