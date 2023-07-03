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
	
}
