

create table emp(
	empno int(4) primary key auto_increment,
	ename varchar(20) not null,
	salary double(7,2) not null,
	deptno int(2) not null
);
insert into emp values(null,'张三丰',99999.99,1);
insert into emp values(null,'张无忌',88888.88,1);
insert into emp values(null,'墨子',77777.77,4);
insert into emp values(null,'颜良',66666.66,3);

create table dept(
	deptno int(2) not null,
	dname varchar(30) not null
);
insert into dept values(1,'行政部');
insert into dept values(2,'销售部');
insert into dept values(3,'人事部');
insert into dept values(4,'研发部');


select e.*,d.dname from emp e join dept d on e.deptno=d.deptno;