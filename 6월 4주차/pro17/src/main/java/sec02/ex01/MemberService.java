package sec02.ex01;

import java.util.List;

public class MemberService { // 서비스에서 데이터베이스 작업을 dao에게 시킴
	
	private MemberDao memberDao = MemberDao.getInstance(); 
	private static MemberService instance = new MemberService();
	
	private MemberService() {}
	
	public static MemberService getInstance() {
		return instance;
	}

	
	public List<MemberVo> listMembers() {
		List<MemberVo> list = memberDao.listMembers();
		return list;
	}
	
}
