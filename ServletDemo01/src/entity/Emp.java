package entity;

public class Emp {
	
	private Integer empno;
	private String ename;
	private Double salary;
	private Integer deptno;
	private String dname;
	
	public Emp(){}
	public Emp(Integer empno, String ename, Double salary, String dname) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.dname = dname;
	}
	public Emp(Integer empno, String ename, Double salary, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
}
