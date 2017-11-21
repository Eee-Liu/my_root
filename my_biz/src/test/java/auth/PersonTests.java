package auth;

import cn.ly.app.biz.dao.auth.PersonDao;
import cn.ly.app.biz.domain.dobj.auth.PersonDO;
import cn.ly.app.biz.domain.query.auth.PersonQuery;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//public class PersonTests extends AbstractTest{
public class PersonTests{

//    @SpringBeanByType
//    private PersonDao personDao;

    @Test
    public void springTests(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PersonDO personDO = (PersonDO)context.getBean("personDO");
        System.out.println(personDO.toString());
        context.close();
    }

    @Test
    public void aopTest(){
        PersonQuery query = new PersonQuery();
        query.setAccount("13215967515");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-import.xml");
        PersonDao personDao = (PersonDao)context.getBean("personDao");
        List<PersonDO> personDOS = personDao.query(query);
        personDOS.forEach(personDO -> {
            System.out.println(personDO);
        });
    }
}
