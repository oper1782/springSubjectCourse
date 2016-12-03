package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;
import kr.ac.hansung.model.eSubject;

@Repository
public class SubjectDAO {

	private JdbcTemplate jdbcTemplateobject;

	@Autowired
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplateobject = new JdbcTemplate(datasource);
	}

	public int getRowcount() {
		String sqlStatement = "select count(*) from mysubject";
		return jdbcTemplateobject.queryForObject(sqlStatement, Integer.class);

	}

	public Subject getSubject(String subjectcode) {
		String sqlStatement = "select * from mysubject where subjectcode=?";
		return jdbcTemplateobject.queryForObject(sqlStatement, new Object[] { subjectcode }, new RowMapper<Subject>() {

			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();
				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setSubjectcode(rs.getString("subjectcode"));
				subject.setSubjectname(rs.getString("subjectname"));
				subject.setSection(rs.getString("section"));
				subject.setCredit(rs.getInt("credit"));
				
				return subject;
			}

		});
	}

	// multiful object
	public List<Subject> getSubject() {
		String sqlStatement = "select * from mysubject";
		return jdbcTemplateobject.query(sqlStatement, new RowMapper<Subject>() {

			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();
				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setSubjectcode(rs.getString("subjectcode"));
				subject.setSubjectname(rs.getString("subjectname"));
				subject.setSection(rs.getString("section"));
				subject.setCredit(rs.getInt("credit"));
				return subject;
			}

		});

	}

	public boolean insert(Subject subject) {
		
		int year=subject.getYear();
		int semester=subject.getSemester();
		String subjectcode=subject.getSubjectcode();
		String subjectname=subject.getSubjectname();
		String section=subject.getSection();
		int credit=subject.getCredit();
		
		String sqlStatement = "insert into mysubject (year, semester, subjectcode,subjectname,section,credit) values (?,?,?,?,?,?)";
		return (jdbcTemplateobject.update(sqlStatement, new Object[] { year, semester, subjectcode,subjectname,section, credit }) == 1);

	}
	public boolean einsert(eSubject esubject) {
		
		String esubjectcode=esubject.getEsubjectcode();
		String esubjectname=esubject.getEsubjectname();
		String esection=esubject.getEsection();
		int ecredit=esubject.getEcredit();
		
		String sqlStatement = "insert into esubject (esubjectname,esubjectcode,esection,ecredit) values (?,?,?,?)";
		return (jdbcTemplateobject.update(sqlStatement, new Object[] { esubjectcode,esubjectname,esection, ecredit }) == 1);

	}

	public boolean update(Subject subject) {
		int year=subject.getYear();
		int semester=subject.getSemester();
		String subjectcode=subject.getSubjectcode();
		String subjectname=subject.getSubjectname();
		String section=subject.getSection();
		int credit=subject.getCredit();
		String sqlStatement = "update mysubject set year=?, semester=?, subjectname=?, section=?, credit=? where subjectcode=?";
		return (jdbcTemplateobject.update(sqlStatement, new Object[] { semester, subjectname, section, credit,subjectcode }) == 1);

	}

	public boolean delete(String subjectcode) {
		String sqlstatement = "delete from mysubject where subjectcode=?";

		return (jdbcTemplateobject.update(sqlstatement, new Object[] { subjectcode }) == 1);

	}

	public List<Subject> getSemester() {
		String sqlStatement = "select year,semester,sum(credit) from mysubject group by year,semester";
		return jdbcTemplateobject.query(sqlStatement, new RowMapper<Subject>() {

			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();
				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setCredit(rs.getInt("sum(credit)"));
				return subject;
			}

		});

	}

	public List<Subject> getsection() {
		String sqlStatement = "select section,sum(credit) from mysubject group by section";
		return jdbcTemplateobject.query(sqlStatement, new RowMapper<Subject>() {

			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();
				subject.setSection(rs.getString("section"));
				subject.setCredit(rs.getInt("sum(credit)"));
				return subject;
			}

		});
	}

	public List<eSubject> geteSubject() {
		String sqlStatement = "select * from esubject";
		return jdbcTemplateobject.query(sqlStatement, new RowMapper<eSubject>() {

			public eSubject mapRow(ResultSet rs, int rowNum) throws SQLException {
				eSubject esubject = new eSubject();
				esubject.setEsubjectcode(rs.getString("esubjectcode"));
				esubject.setEsubjectname(rs.getString("esubjectname"));
				esubject.setEsection(rs.getString("esection"));
				esubject.setEcredit(rs.getInt("ecredit"));
				return esubject;
			}

		});

	}

	public List<Subject> getlist() {
		String sqlStatement = "select year,semester, subjectname from mysubject order by year,semester";
		return jdbcTemplateobject.query(sqlStatement, new RowMapper<Subject>() {

			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();
				subject.setSemester(rs.getInt("semester"));
				subject.setYear(rs.getInt("year"));
				subject.setSubjectname(rs.getString("subjectname"));
				return subject;
			}

		});
	}
}
