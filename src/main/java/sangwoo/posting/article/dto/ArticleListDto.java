package sangwoo.posting.article.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<String> tags;

    public ArticleListDto(Long id, String title, String content, Long viewCount, LocalDateTime createdAt, String author, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
        this.author = author;
        this.tags = tags;
    }
}
