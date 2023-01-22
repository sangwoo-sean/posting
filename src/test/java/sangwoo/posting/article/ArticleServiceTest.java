package sangwoo.posting.article;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sangwoo.posting.article.dto.ArticleDto;
import sangwoo.posting.user.User;
import sangwoo.posting.user.UserRepository;
import sangwoo.posting.user.dto.UserDto;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ArticleServiceTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void createArticleTest() {
        //given
        UserDto userDto = new UserDto();
        userDto.setEmail("tester@tester.com");
        userDto.setPassword("testpw123");
        User user = User.register(userDto);
        userRepository.save(user);

        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle("test title");
        articleDto.setContent("test content");
        Article article = Article.create(articleDto, user);

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