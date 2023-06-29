package ex03;

public class StudentVo {

	String sno, sname, gender, major;
	int syear, score;
	
	public StudentVo(String sno, String name, String gender, String major, int syear, int score) {
		super();
		this.sno = sno;
		this.sname = name;
		this.gender = gender;
		this.major = major;
		this.syear = syear;
		this.score = score;
	}

	public StudentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getSyear() {
		return syear;
	}

	public void setSyear(int syear) {
		this.syear = syear;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentVo [sno=" + sno + ", sname=" + sname + ", gender=" + gender + ", major=" + major + ", syear="
				+ syear + ", score=" + score + "]";
	}
	
}
