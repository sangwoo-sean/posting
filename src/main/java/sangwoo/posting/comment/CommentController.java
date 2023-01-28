package sangwoo.posting.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sangwoo.posting.comment.dto.CommentDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity createComment(@ModelAttribute @Validated CommentDto commentDto) {
        commentService.createComment(commentDto);
        return ResponseEntity.ok(null);
    }
}
