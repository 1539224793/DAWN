
import cn.dawn.demo03.dao.ICategoryDAO;
import cn.dawn.demo03.dao.IDeptDAO;
import cn.dawn.demo03.dao.IEmpDAO;
import cn.dawn.demo03.dao.ITeacherDAO;
import cn.dawn.demo03.entity.*;
import cn.dawn.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dawn on 2018/2/26.
 */
public class Test20180226 {

    /*自关联*/
    @Test
    public void t6selfPk(){
        SqlSession session= MyBatisUtils.getSession();

        ICategoryDAO mapper = session.getMapper(ICategoryDAO.class);
        List<Category> lists = mapper.findAllCategorySetBypid(0);
        System.out.println(lists);


        session.close();

    }

    /*多对多*/
    @Test
    public void t5MorePkMore(){
        SqlSession session= MyBatisUtils.getSession();

        ITeacherDAO mapper = session.getMapper(ITeacherDAO.class);
        Teacher teacher = mapper.findAllStudentsByTid(1);
        System.out.println(teacher.getTname());
        for (Student item:teacher.getStus()) {
            System.out.println(item.getSname());
        }



        session.close();

    }


    /*多对一多条sql*/
    @Test
    public void t4MorePkOneMoreSQL(){
        SqlSession session= MyBatisUtils.getSession();

        IEmpDAO mapper = session.getMapper(IEmpDAO.class);
        Emp emp = mapper.findempnoALLDeptMoreSQL(1);
        System.out.println("员工姓名==================="+emp.getEmpName());
        System.out.println("员工部门名称==================="+emp.getDept().getDeptName());



        session.close();

    }


    /*多对一单条sql*/
    @Test
    public void t3MorePkOneOneSQL(){
        SqlSession session= MyBatisUtils.getSession();

        IEmpDAO mapper = session.getMapper(IEmpDAO.class);
        Emp emp = mapper.findempnoALLDept(1);
        System.out.println("员工姓名==================="+emp.getEmpName());
//        System.out.println("员工部门名称==================="+emp.getDept().getDeptName());



        session.close();

    }


    /*一对多多条sql*/
    @Test
    public void t2OnePkMoreMoreSQL(){
        SqlSession session= MyBatisUtils.getSession();

        IDeptDAO mapper = session.getMapper(IDeptDAO.class);
        Dept depts = mapper.findDeptnoALLEmpsMoreSql(1);
        System.out.println(depts.getDeptName()+"================"+depts.getDeptNo());
        for (Emp item:depts.getEmps()) {
            System.out.println(item.getEmpName());
        }


        session.close();

    }

    /*一对多单条sql*/
    @Test
    public void t1OnePkMoreOneSQL(){
        SqlSession session= MyBatisUtils.getSession();

        IDeptDAO mapper = session.getMapper(IDeptDAO.class);
        Dept depts = mapper.findDeptnoALLEmps(1);
        System.out.println(depts.getDeptName()+"================"+depts.getDeptNo());
        for (Emp item:depts.getEmps()) {
            System.out.println(item.getEmpName());
        }


        session.close();

    }
}
