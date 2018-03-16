import cn.dawn.demo04.dao.IDeptDAO;
import cn.dawn.demo04.entity.Dept;
import cn.dawn.demo04.entity.Emp;
import cn.dawn.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Dawn on 2018/2/27.
 */
public class Test20180227 {

    /*二级缓存*/
    @Test
    public void t4SecondCacheHasExist(){
        SqlSession session= MyBatisUtils.getSession();

        IDeptDAO mapper = session.getMapper(IDeptDAO.class);
        Dept depts = mapper.findDeptnoALLEmpsMoreSql(1);
        System.out.println(depts.getDeptName());
        session.close();

        System.out.println("===================我是高冷的分割线=====================");
        SqlSession session2= MyBatisUtils.getSession();

        IDeptDAO mapper2 = session2.getMapper(IDeptDAO.class);
        Dept depts2 = mapper2.findDeptnoALLEmpsMoreSql(1);
        System.out.println(depts2.getDeptName());
        session2.close();


    }



    /*增删改对一级缓存的影响*/
    @Test
    public void t3IUDForLevelOneCache(){
        SqlSession session= MyBatisUtils.getSession();

        IDeptDAO mapper = session.getMapper(IDeptDAO.class);
        Dept d1 = mapper.findDeptnoALLEmpsMoreSql(1);

        System.out.println(d1.getDeptName());

        Dept dept=new Dept();
        dept.setDeptName("无敌是多么寂寞部");
        mapper.addDept(dept);
        System.out.println("==================我是特别的高贵的分割线==================");
        Dept d2 = mapper.findDeptnoALLEmpsMoreSql(1);
        System.out.println(d2.getDeptName());

        session.close();

    }


    /*一级缓存存在性证明sql*/
    @Test
    public void t2LevelOneCacheHasExist(){
        SqlSession session= MyBatisUtils.getSession();

        IDeptDAO mapper = session.getMapper(IDeptDAO.class);
        Dept d1 = mapper.findDeptnoALLEmpsMoreSql(1);

        System.out.println(d1.getDeptName());
        System.out.println("==================我是特别的高贵的分割线==================");
        Dept d2 = mapper.findDeptnoALLEmpsMoreSql(1);
        System.out.println(d2.getDeptName());

        session.close();

    }


    /*一延迟加载*/
    @Test
    public void t1LongtimeLoad(){
        SqlSession session= MyBatisUtils.getSession();

        IDeptDAO mapper = session.getMapper(IDeptDAO.class);
        Dept depts = mapper.findDeptnoALLEmpsMoreSql(1);

        System.out.println("====================================分割线111111===============================");


        /*深度延迟*/
        System.out.println(depts.getDeptName()+"================"+depts.getDeptNo());
        System.out.println("====================================分割线222222===============================");
        System.out.println(depts.getEmps().size());

        /*侵入式延迟*/
        /*System.out.println(depts.getDeptName()+"================"+depts.getDeptNo());*/
        session.close();

    }
}
