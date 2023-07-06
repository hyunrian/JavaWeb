package com.spring.ex03;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDao) {
		this.memberDAO = memberDao;
	}
	
	@Override
	public void listMembers() {
		memberDAO.listMembers();
	}

	
	
}
