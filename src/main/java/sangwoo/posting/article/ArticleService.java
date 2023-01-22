package sangwoo.posting.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sangwoo.posting.article.dto.ArticleDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long createArticle(ArticleDto articleDto) {
        Article savedArticle = articleRepository.save(Article.create(articleDto));
        return savedArticle.getId();
    }

    public ArticleDto findById(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(IllegalArgumentException::new);
        return new ArticleDto(article);
    }

    public List<ArticleDto> findAllArticles() {
        return articleRepository.findAllByDeletedAt(null).stream()
                .map(ArticleDto::new)
                .collect(Collectors.toList());
    }
}
