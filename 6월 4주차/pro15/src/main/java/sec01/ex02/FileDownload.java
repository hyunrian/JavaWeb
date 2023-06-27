package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		String fileName = request.getParameter("fileName");
		String filePath = "C:/file_repo/" + fileName;
		File f = new File(filePath);
		
		// 브라우저의 이미지저장공간에 저장하지 않음 설정
		response.setHeader("Cache-Control", "no-cache"); 
		// 파일이름대로 다운로드되도록 설정
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName); 
		
		OutputStream out = response.getOutputStream();

		// 파일을 읽은 후 내보내기
		FileInputStream input = new FileInputStream(f);
		byte[] buffer = new byte[1024 * 8]; // 8kb의 버퍼 만들기
		while (true) {
			int count = input.read(buffer);
			if (count == -1) break; // 파일을 다 읽었다면 중단
			out.write(buffer, 0, count);
		}
		out.close();
		input.close();
	}
	
}
