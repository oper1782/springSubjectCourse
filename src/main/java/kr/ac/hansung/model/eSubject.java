package kr.ac.hansung.model;

public class eSubject {
	private String esubjectcode;
	private String esubjectname;
	private String esection;
	private int ecredit;
	public String getEsubjectcode() {
		return esubjectcode;
	}
	public void setEsubjectcode(String esubjectcode) {
		this.esubjectcode = esubjectcode;
	}
	public String getEsubjectname() {
		return esubjectname;
	}
	public void setEsubjectname(String esubjectname) {
		this.esubjectname = esubjectname;
	}
	public String getEsection() {
		return esection;
	}
	public void setEsection(String esection) {
		this.esection = esection;
	}
	public int getEcredit() {
		return ecredit;
	}
	public void setEcredit(int ecredit) {
		this.ecredit = ecredit;
	}
	@Override
	public String toString() {
		return "과목코드 =" + esubjectcode + ", 과목 이름=" + esubjectname + ", 이수 구분=" + esection
				+ ", 학점=" + ecredit;
	}
	
}
