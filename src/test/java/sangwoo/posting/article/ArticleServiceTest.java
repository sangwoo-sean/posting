package sangwoo.posting.article;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sangwoo.posting.article.dto.ArticleDto;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ArticleServiceTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void createArticleTest() {
        //given
        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle("test title");
        articleDto.setContent("test content");
        Article article = Article.create(articleDto, author);

        //when
        Article savedArticle = articleRepository.save(article);

        //then
        Article findArticle = articleRepository.findById(savedArticle.getId())
                .orElseThrow(IllegalArgumentException::new);

        assertThat(findArticle.getId()).isEqualTo(savedArticle.getId());
        assertThat(findArticle.getTitle()).isEqualTo(articleDto.getTitle());
        assertThat(findArticle.getContent()).isEqualTo(articleDto.getContent());
    }

}