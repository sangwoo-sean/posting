package sangwoo.posting.user;

import lombok.Getter;
import sangwoo.posting.article.Article;
import sangwoo.posting.auth.dto.SignupDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String name;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "user")
    private List<Article> articles = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static User register(SignupDto signupDto) {
        User user = new User();
        user.name = signupDto.getName();
        user.email = signupDto.getEmail();
        user.password = signupDto.getPassword();
        return user;
    }

    public void update() {
        //todo: update info
    }
}
