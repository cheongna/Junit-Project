package metacoding.site.metacoding.junitproject.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import metacoding.site.metacoding.JunitProjectApplication;
import metacoding.site.metacoding.junitproject.domain.BookRepository;

@DataJpaTest
//@SpringBootTest(classes = JunitProjectApplication.class)
public class BookRepositoryTest {
    /*
     * 책 등록
     * 책 목록보기
     * 책 한권보기
     * 책 수정
     * 책 삭제
     */

     @Autowired
     private BookRepository bookRepository;

     //given값 만들기
     @BeforeEach
     public void 데이터준비(){
      String title = "author";
      String author = "김도현";
      Book book = Book.builder().title(title).author(author).build();
      bookRepository.save(book);
     }

     // 1 책 등록
     @Test
     public void save_test(){
      //given      
      String title = "author";
      String author = "김도현";
      Book book = Book.builder().title(title).author(author).build();
      //when
      Book bookPs = bookRepository.save(book);
      //then
      assertEquals(title, bookPs.getTitle());
      assertEquals(author, bookPs.getAuthor());
     }

    // 2 책 목록보기
     @Test
     public void checkList_test(){
      //given
      String title = "author";
      String author = "김도현";
      Book book = Book.builder().title(title).author(author).build();
      //when
      bookRepository.save(book);
      //when
      List<Book> books = bookRepository.findAll();
      //then
      System.out.println(books.size());
      assertEquals(title, books.get(0).getTitle());
      assertEquals(author, books.get(0).getAuthor());
     }

     // 3 책 한권보기
     @Sql("classpath:db/tableInit.sql")
     @Test
     public void lookBook_test(){
      //given
      String title = "author";
      String author = "김도현";
      Book book = Book.builder().title(title).author(author).build();
      bookRepository.save(book);
      //when
      Book bookPs = bookRepository.findById(1L).get();
      //then
      assertEquals(title, bookPs.getTitle());
      assertEquals(author, bookPs.getAuthor());
     }

     //4 책 삭제
     @Sql("classpath:db/tableInit.sql")
     @Test
     public void delete_test(){
      //given
      Long id = 1l;
      //when
      bookRepository.deleteById(id);
      //then
      assertFalse(bookRepository.findById(id).isPresent());
     }
}
