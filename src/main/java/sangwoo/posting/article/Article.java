package sangwoo.posting.article;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import sangwoo.posting.article.dto.ArticleDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Article {

    @Id
    @Column(name = "articleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 4000)
    private String content;
    @ColumnDefault("0")
    private Long viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static Article create(ArticleDto articleDto) {
        Article article = new Article();
        article.title = articleDto.getTitle();
        article.content = articleDto.getContent();
        return article;
    }
}
