package sangwoo.posting.article;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import sangwoo.posting.article.dto.ArticleDto;
import sangwoo.posting.config.converter.StringListConverter;
import sangwoo.posting.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@DynamicInsert
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

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "longtext")
    private List<String> tags;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static Article create(ArticleDto articleDto, User author) {
        Article article = new Article();
        article.title = articleDto.getTitle();
        article.content = articleDto.getContent();
        article.user = author;
        article.tags = articleDto.getTags();
        return article;
    }
}
