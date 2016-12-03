package kr.ac.hansung.model;

public class Subject {
	
	private int year;
	private int semester;
	private String subjectcode;
	private String subjectname;
	private String section;
	private int credit;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getSection() {
		return section; 	
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return "이수년도=" + year + ", 이수학기=" + semester+", 과목명="
				+ subjectname;
	}

}
