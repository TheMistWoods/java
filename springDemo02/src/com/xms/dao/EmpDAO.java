package com.xms.dao;

import java.util.List;

import com.xms.annotation.MyAnnotation;
import com.xms.entity.Emp;

@MyAnnotation
public interface EmpDAO {
	
	List<Emp> findAll();
	
	Emp findByEmpno(int empno);
	
	void save(Emp emp);
	
	void update(Emp emp);
	
	void delete(int empno);
}
