package sangwoo.posting.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sangwoo.posting.comment.dto.CommentCreateDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody @Validated CommentCreateDto commentDto) {
        commentService.createComment(commentDto);
        return ResponseEntity.ok(null);
    }
}
