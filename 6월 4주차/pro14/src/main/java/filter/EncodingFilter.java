package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/*") // 모든 요청에 대해 필터 적용
public class EncodingFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
							throws IOException, ServletException {
		
		// 필터 적용 전에 할 내용 코딩
		request.setCharacterEncoding("utf-8");
		
		// 필터 적용
		chain.doFilter(request, response);
		
		// 필터 적용 후에 할 내용 코딩
	}
}
