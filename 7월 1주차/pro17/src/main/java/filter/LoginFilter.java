package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/board/*", "/comment/*"})
public class LoginFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
							throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		String loginId = (String)session.getAttribute("loginId");
		if (loginId == null) {
			((HttpServletResponse)response).sendRedirect("/login/loginForm");
		} else {
			chain.doFilter(request, response); // 계속 진행함
		}
	}
}
