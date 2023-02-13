package sangwoo.posting.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class CommentReadDto {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private Long parentId;

    public CommentReadDto(Long id, String content, String author, LocalDateTime createdAt, Long parentId) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.parentId = parentId;
    }
}
