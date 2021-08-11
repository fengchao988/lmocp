/*
import com.snszyk.iiot.marketization.demo.DemoApplication;
import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.PositionInfRepository;
import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.jpa.AuthorRepository;
import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.jpa.BookRepository;
import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.one2many.Author;
import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.one2many.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class TestOne2Many {

    @Autowired
    PositionInfRepository positionInfRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testOne2many() {
        Author author = new Author();
        author.setId(2l);
        author.setName("Alicia Tom");
        author.setAge(38);
        author.setGenre("Anthology");

        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setIsbn("001-AT");
        book.setTitle("The book of swords");

        Book book2 = new Book();
        book2.setIsbn("002-AT");
        book2.setTitle("The book of HLIBOTER");

        bookList.add(book);
        bookList.add(book2);

        author.setBooks(bookList);

        authorRepository.save(author);
    }
}
*/
