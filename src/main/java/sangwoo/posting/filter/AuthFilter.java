package sangwoo.posting.filter;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sangwoo.posting.auth.JwtProvider;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AuthFilter implements Filter {

    private final JwtProvider jwtProvider;

    private List<String> allowedUrls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowedUrls.add("/login");
        allowedUrls.add("/signup");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (allowedUrls.contains(req.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        String authorization = req.getHeader("Authorization");
        if (!StringUtils.hasText(authorization)) {
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        Claims claims = jwtProvider.parseJwtToken(authorization);
        if (Objects.isNull(claims)) { //token 만료
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        chain.doFilter(request, response);
    }
}
