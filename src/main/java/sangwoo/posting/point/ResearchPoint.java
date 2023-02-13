package sangwoo.posting.point;

import lombok.Getter;
import sangwoo.posting.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class ResearchPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "researchPointId")
    private long id;

    private LocalDateTime createdAt;

    private String action; //포인트 적립/소진 액션 (게시글작성, 토큰 발행) -> to be enum
    private String type; //포인트 적립/소진 타입 (+/-) -> to be enum
    private int amount; // 적립 양

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 해당 유저
}
