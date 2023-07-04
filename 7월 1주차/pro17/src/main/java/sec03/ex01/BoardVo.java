package sec03.ex01;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardVo {

	private int bno;
	private int bgroup;
	private int bseq;
	private int blevel;
	private String btitle;
	private String bcontent;
	private String id;
	private Date regdate;
	private int readcount;
	private String delete_yn;
	
	public BoardVo(int bno, int bgroup, int bseq, int blevel, String btitle, String bcontent, String id, Date regdate,
			int readcount) {
		super();
		this.bno = bno;
		this.bgroup = bgroup;
		this.bseq = bseq;
		this.blevel = blevel;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.id = id;
		this.regdate = regdate;
		this.readcount = readcount;
	}
}
