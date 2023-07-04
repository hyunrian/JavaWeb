package sec03.ex01;

public class LoginService {

	private LoginDao dao = LoginDao.getInstance();
	
	private static LoginService instance = new LoginService();
	
	private LoginService() {}
	
	public static LoginService getInstance() {
		return instance;
	}
	
	public boolean login(LoginDto dto) {
		return dao.login(dto);
	}
	
}
