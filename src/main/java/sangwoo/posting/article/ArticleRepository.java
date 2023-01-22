package sangwoo.posting.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sangwoo.posting.article.dto.ArticleListDto;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select new sangwoo.posting.article.dto.ArticleListDto(a.id, a.title, a.content, a.viewCount, a.createdAt, u.email)" +
            " from Article a" +
            " join a.user u on u.id=a.user.id" +
            " where a.deletedAt = null" +
            " order by a.createdAt desc")
    List<ArticleListDto> findAllReadableArticles();
}
