package sangwoo.posting.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sangwoo.posting.article.Article;
import sangwoo.posting.article.ArticleRepository;
import sangwoo.posting.comment.dto.CommentCreateDto;
import sangwoo.posting.user.User;
import sangwoo.posting.user.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    @Transactional
    public Long createComment(CommentCreateDto commentDto) {
        User user = userRepository.findById(commentDto.getUserId())
                .orElseThrow(IllegalArgumentException::new);

        Article article = articleRepository.findById(commentDto.getArticleId())
                .orElseThrow(IllegalArgumentException::new);

        Comment parent = null;
        if (commentDto.getParentId() != null) { //대댓글
            parent = commentRepository.findById(commentDto.getParentId())
                    .orElseThrow(IllegalArgumentException::new);
        }

        Comment comment = Comment.create(commentDto, user, article, parent);
        Comment save = commentRepository.save(comment);
        return save.getId();
    }
}
