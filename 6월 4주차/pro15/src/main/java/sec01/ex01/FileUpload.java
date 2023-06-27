package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

//		System.out.println("file1: " + request.getParameter("file1"));
//		System.out.println("file2: " + request.getParameter("file2"));
//		System.out.println("param1: " + request.getParameter("param1"));
//		System.out.println("param2: " + request.getParameter("param2"));
//		System.out.println("param3: " + request.getParameter("param3"));
		// HttpServletRequest는 binary data를 처리할 수 없음!! -> 라이브러리를 이용해야 함
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 업로드 파일 저장 위치 설정
		factory.setRepository(new File("C:/file_repo"));
		// 업로드 파일 최대 크기(사이즈) 설정
		factory.setSizeThreshold(1024 * 1024 * 10); // byte 단위. 10mb
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
//			System.out.println("list: " + list);
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) { // param1,2,3(input type="file"이 아닌 경우)
					String fieldName = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					System.out.println(fieldName + "=" + value);
				} else { // file1,2 (input type="file"인 경우)
					String fieldName = fileItem.getFieldName();
					String fileName = fileItem.getName(); // 파일의 이름 얻기
					long size = fileItem.getSize();
					System.out.println(fieldName + "=" + fileName + ", " + size + "bytes");
					
					// 사용자가 같은 이름의 파일을 업로드하면 파일명이 중복되어 덮어쓰기됨
					// -> 중복되지 않는 이름으로 파일명을 생성해야 함
					UUID uuid = UUID.randomUUID();

					if (size > 0) { // 파일 크기가 0보다 크다면 비어있는 파일이 아님
						fileItem.write(new File("C:/file_repo/" + uuid + "_" + fileName));
						// 나중에 사용자에게 파일명을 보여줘야 하는 경우 "_"를 구분자로 사용하여 fileName만 보여주면 됨
					} 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
