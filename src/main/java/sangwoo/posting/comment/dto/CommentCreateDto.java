package sangwoo.posting.comment.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateDto {
    private Long id;
    @NotEmpty
    private String content;
    @NotNull
    private Long userId;
    @NotNull
    private Long articleId;
    @Nullable
    private Long parentId;
}
