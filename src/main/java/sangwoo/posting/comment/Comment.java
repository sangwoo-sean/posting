package sangwoo.posting.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sangwoo.posting.article.Article;
import sangwoo.posting.comment.dto.CommentCreateDto;
import sangwoo.posting.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name = "commentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2000)
    private String content;
    private LocalDateTime createdAt;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "articleId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Comment parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Comment> children = new ArrayList<>();

    public static Comment create(CommentCreateDto commentDto, User user, Article article, Comment parent) {
        Comment comment = new Comment();
        comment.content = commentDto.getContent();
        comment.user = user;
        comment.article = article;

        if (parent != null) { //대댓글인 경우
            comment.parent = parent;
            parent.children.add(comment);
        }

        return comment;
    }


    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
