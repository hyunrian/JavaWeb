package sec03.ex01;

public class LoginDtoTest {

	public static void main(String[] args) {

		LoginDto dto1 = new LoginDto();
		dto1.setId("hong");
		dto1.setPwd("1234");
		System.out.println(dto1.toString());
		
		LoginDto dto2 = new LoginDto("kim", "5678");
		System.out.println("id: " + dto2.getId() + ", pwd: " + dto2.getPwd());
	}
}
