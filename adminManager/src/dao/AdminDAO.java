package dao;

import java.util.List;

import entity.Admin;

public interface AdminDAO {
	//增加
	public void add(Admin a) throws Exception;
	//删除
	public void del(int id)throws Exception;
	//根据id查
	public Admin findById(int id)throws Exception;
	//根据新Admin更新
	public void update(Admin a)throws Exception;
	//查所有
	public List<Admin> findAll()throws Exception;
}
