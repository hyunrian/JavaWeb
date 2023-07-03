package test02;

import java.util.List;

public class MemberService {
	
	MemberDao dao = MemberDao.getInstance();
	private static MemberService instance = new MemberService();
	
	private MemberService () {}
	
	public static MemberService getInstance () {
		return instance;
	}
	
	public List<MemberVo> getMemberList() {
		return dao.listMembers();
	}
	
	public boolean addMember(MemberVo vo) {
		return dao.addMember(vo);
	}

}
