package sangwoo.posting.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sangwoo.posting.comment.dto.CommentReadDto;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select new sangwoo.posting.comment.dto.CommentReadDto(c.id, c.content, c.user.name, c.createdAt, c.parent.id)" +
            " from Comment c" +
            " where c.article.id = :articleId" +
            " order by c.createdAt desc")
    List<CommentReadDto> findAllReadDtoByArticleId(@Param("articleId") Long articleId);
}
