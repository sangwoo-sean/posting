package sangwoo.posting.point;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("points")
@RequiredArgsConstructor
public class ResearchPointController {
    private final ResearchPointService researchPointService;

    @GetMapping
    void getPoints() {
        //todo
    }

    @PostMapping
    void accumulatePoints() {
        //todo
    }
}
