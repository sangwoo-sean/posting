package sangwoo.posting.comment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sangwoo.posting.article.Article;
import sangwoo.posting.article.ArticleRepository;
import sangwoo.posting.article.dto.ArticleDto;
import sangwoo.posting.auth.dto.SignupDto;
import sangwoo.posting.comment.dto.CommentCreateDto;
import sangwoo.posting.user.User;
import sangwoo.posting.user.UserRepository;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void createCommentParent() {
        //given
        User user = userRepository.save(User.register(new SignupDto()));
        Article article = articleRepository.save(Article.create(new ArticleDto(), user));
        String contentTest = "content test";

        CommentCreateDto commentDto = CommentCreateDto.builder()
                .content(contentTest)
                .articleId(article.getId())
                .userId(user.getId())
                .build();

        //when
        Long savedId = commentService.createComment(commentDto);

        //then
        Comment comment = commentRepository.findById(savedId)
                .orElseThrow(IllegalArgumentException::new);

        assertThat(comment.getContent()).isEqualTo(contentTest);
        assertThat(comment.getUser().getId()).isEqualTo(user.getId());
        assertThat(comment.getArticle().getId()).isEqualTo(article.getId());
    }

    @Test
    void createCommentChild() {
        //given
        User user = userRepository.save(User.register(new SignupDto()));
        Article article = articleRepository.save(Article.create(new ArticleDto(), user));
        String contentTest = "content test";

        CommentCreateDto parentCommentDto = CommentCreateDto.builder()
                .articleId(article.getId())
                .userId(user.getId())
                .build();
        Long parentId = commentService.createComment(parentCommentDto);

        CommentCreateDto childCommentDto = CommentCreateDto.builder()
                .content(contentTest)
                .articleId(article.getId())
                .userId(user.getId())
                .parentId(parentId)
                .build();

        //when
        Long childId = commentService.createComment(childCommentDto);

        //then
        Comment childComment = commentRepository.findById(childId)
                .orElseThrow(IllegalArgumentException::new);

        assertThat(childComment.getParent().getId()).isEqualTo(parentId);
        assertThat(childComment.getContent()).isEqualTo(contentTest);
        assertThat(childComment.getUser().getId()).isEqualTo(user.getId());
        assertThat(childComment.getArticle().getId()).isEqualTo(article.getId());
    }
}