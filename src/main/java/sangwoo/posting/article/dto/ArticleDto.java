package sangwoo.posting.article.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sangwoo.posting.article.Article;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ArticleDto {

    private Long id;

    @NotBlank(message = "제목은 공백일 수 없습니다.")
    @Size(max = 100, message = "제목은 100자를 넘을 수 없습니다.")
    private String title;

    @NotBlank(message = "내용은 공백일 수 없습니다.")
    @Size(max = 4000, message = "내용은 4000자를 넘을 수 없습니다.")
    private String content;

    private Long viewCount;

    private LocalDateTime createdAt;

    public ArticleDto(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
        this.viewCount = article.getViewCount();
        this.createdAt = article.getCreatedAt();
    }
}
