package dao;

import java.util.List;

import entity.Admin;

public interface AdminDAO {
	//����
	public void add(Admin a) throws Exception;
	//ɾ��
	public void del(int id)throws Exception;
	//����id��
	public Admin findById(int id)throws Exception;
	//������Admin����
	public void update(Admin a)throws Exception;
	//������
	public List<Admin> findAll()throws Exception;
}
