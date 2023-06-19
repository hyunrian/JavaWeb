package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final float DOLLAR_RATE = 0.13F;
	private static final float EURO_RATE = 0.24F;
	private static final float POUND_RATE = 0.56F;
       
    public CalcSurvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String money = request.getParameter("money");
		String oper = request.getParameter("oper");
		String html = "";
		
		html += "<!doctype html>";
		html += "<html>";
		html += "<html>";
		html += "<head>";
		html += "<title>환율 계산기</title>";
		html += "<meta charset='utf-8'>";
		html += "</head>";
		html += "<body>";
		
		if (money == null) {
			html += "<h1>환율 계산기</h1>";
			html += "<form>";
			html += "원화: <input type='number' name='money' style='background-color:yellow'> ";
			html += "<select name='oper'>";
			html += "<option value='dollar'>달러</option>";
			html += "<option value='euro'>유로</option>";
			html += "<option value='pound'>파운드</option>";
			html += "</select> ";
			html += "<button>변환</button>";
			html += "</form>";
			
		} else {
			int iMoney = Integer.valueOf(money);
			float rateMoney = 0;
			
			switch (oper) {
			case "dollar" :
				rateMoney = iMoney * DOLLAR_RATE;
				break;
			case "euro" :
				rateMoney = iMoney * EURO_RATE;
				break;
			case "pound" :
				rateMoney = iMoney * POUND_RATE;
				break;
			}
			
			html += "<h1>변환 결과</h1>";
			html += "<h2>" + rateMoney + " " + oper + "</h2>";
			html += "<a href='calc'>환율 계산기</a>";
		}

		html += "</body>";
		html += "</html>";
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
