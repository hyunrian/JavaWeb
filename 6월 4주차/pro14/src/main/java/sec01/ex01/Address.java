package sec01.ex01;

public class Address {
	
	private String sido;
	private String gugun;
	
	public Address() {
		super();
	}

	public Address(String sido, String gugun) {
		super();
		this.sido = sido;
		this.gugun = gugun;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	@Override
	public String toString() {
		return "Address [sido=" + sido + ", gugun=" + gugun + "]";
	}
	
}
