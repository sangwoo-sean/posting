package sangwoo.posting.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sangwoo.posting.article.dto.ArticleDto;
import sangwoo.posting.article.dto.ArticleListDto;
import sangwoo.posting.user.User;
import sangwoo.posting.user.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long createArticle(ArticleDto articleDto) {
        User author = userRepository.findById(articleDto.getUserId())
                .orElseThrow(IllegalArgumentException::new);

        Article savedArticle = articleRepository.save(Article.create(articleDto, author));
        return savedArticle.getId();
    }

    public ArticleDto findById(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(IllegalArgumentException::new);
        return new ArticleDto(article);
    }

    public List<ArticleListDto> findAllArticles() {
        return articleRepository.findAllReadableArticles();
    }
}
