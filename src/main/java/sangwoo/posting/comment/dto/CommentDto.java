package sangwoo.posting.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String content;
    private Long userId;
    private Long articleId;
    private Long parentId;
}
