package metacoding.site.metacoding.junitproject.web.dto;

import lombok.Setter;
import metacoding.site.metacoding.junitproject.domain.Book;

@Setter
public class BookSaveReqDto {
    private String title;
    private String author;

    public Book toEntity(){
        return Book.builder()
        .title(title)
        .author(author)
        .build();
    } 
    
}
