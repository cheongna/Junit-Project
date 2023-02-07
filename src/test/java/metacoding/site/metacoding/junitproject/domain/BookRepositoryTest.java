package metacoding.site.metacoding.junitproject.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

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

     // 책 등록
     @Test
     public void save_test(){
        System.out.println("save_test 시작");
     }
    
}
