package sangwoo.posting.article;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sangwoo.posting.article.dto.ArticleDto;
import sangwoo.posting.article.dto.ArticleListDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<Long> createArticle(@Validated @RequestBody ArticleDto articleDto) {
        Long articleId = articleService.createArticle(articleDto);
        return ResponseEntity.ok(articleId);
    }

    @GetMapping("{articleId}")
    public ResponseEntity<ArticleDto> findArticle(@PathVariable Long articleId) {
        ArticleDto articleDto = articleService.findById(articleId);
        return ResponseEntity.ok(articleDto);
    }

    @GetMapping
    public ResponseEntity<List<ArticleListDto>> findAllArticles() {
        List<ArticleListDto> articleList = articleService.findAllArticles();
        return ResponseEntity.ok(articleList);
    }
}
