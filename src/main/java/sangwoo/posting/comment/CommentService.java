package sangwoo.posting.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sangwoo.posting.article.Article;
import sangwoo.posting.article.ArticleRepository;
import sangwoo.posting.comment.dto.CommentDto;
import sangwoo.posting.user.User;
import sangwoo.posting.user.UserRepository;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public void createComment(CommentDto commentDto) {
        User user = userRepository.findById(commentDto.getUserId())
                .orElseThrow(IllegalArgumentException::new);

        Article article = articleRepository.findById(commentDto.getArticleId())
                .orElseThrow(IllegalArgumentException::new);

        Comment parent = commentRepository.findById(commentDto.getParentId())
                .orElse(null);

        Comment comment = Comment.create(commentDto, user, article, parent);

        commentRepository.save(comment);
    }
}
