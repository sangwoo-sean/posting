package sangwoo.posting.comment.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private String content;
    private Long userId;
    private Long articleId;
    private Long parentId;
}
