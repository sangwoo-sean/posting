package sangwoo.posting.article.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sangwoo.posting.article.Article;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ArticleListDto {

    private Long id;
    private String title;
    private String content;
    private Long viewCount;
    private LocalDateTime createdAt;
    private String author;

    public ArticleListDto(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
        this.viewCount = article.getViewCount();
        this.createdAt = article.getCreatedAt();
        this.author = article.getUser().getEmail();
    }
}
