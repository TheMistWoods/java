package dao;

import java.util.List;

import entity.Emp;

public interface EmpDAO {
	
	List<Emp> findAll() throws Exception;
	
	Emp findByEmpno(int empno) throws Exception;
	
	void update(Emp emp) throws Exception;
	
	void save(Emp emp) throws Exception;
	
	void delete(int empno) throws Exception;
}
