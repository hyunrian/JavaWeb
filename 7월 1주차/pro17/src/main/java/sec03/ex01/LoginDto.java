package sec03.ex01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본생성자
//@RequiredArgsConstructor // final 변수를 정의하기 위함
@AllArgsConstructor // 필드생성자
@Getter
@Setter
@ToString
public class LoginDto {
	
//	private final int number;
	private String id, pwd;
	
}
