package sangwoo.posting.point;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResearchPointService {
    private final ResearchPointRepository researchPointRepository;
}
