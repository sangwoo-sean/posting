package sangwoo.posting.article;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sangwoo.posting.article.dto.ArticleDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("article")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<Object> createArticle(@Validated @RequestBody ArticleDto articleDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(bindingResult.getFieldError());
        }

        Long articleId = articleService.createArticle(articleDto);
        return ResponseEntity.ok(articleId);
    }
}
