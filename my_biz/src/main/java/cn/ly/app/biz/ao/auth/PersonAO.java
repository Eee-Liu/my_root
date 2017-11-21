package cn.ly.app.biz.ao.auth;

import cn.ly.app.biz.dao.auth.PersonDao;
import cn.ly.app.biz.domain.dobj.auth.PersonDO;
import cn.ly.app.biz.domain.query.auth.PersonQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonAO {
    @Autowired
    private  PersonDao personDao;

    public  List<PersonDO> query(PersonQuery query) {
        List<PersonDO> personDOS = personDao.query(query);
        return personDOS;
    }
}
