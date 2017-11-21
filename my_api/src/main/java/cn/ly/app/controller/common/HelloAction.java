package cn.ly.app.controller.common;

import cn.ly.app.biz.ao.auth.PersonAO;
import cn.ly.app.biz.domain.dobj.auth.PersonDO;
import cn.ly.app.biz.domain.query.auth.PersonQuery;
import cn.ly.app.core.utils.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/common")
public class HelloAction {

    @Autowired
    private PersonAO personAO;

    @ResponseBody
    @RequestMapping(value = "/hello.do",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> hello(){
        PersonQuery query = new PersonQuery();
        query.setAccount("13215967515");
        List<PersonDO> personDOS = personAO.query(query);
        JSONObject object = new JSONObject();
        if (CollectionUtil.isNotEmpty(personDOS)){
            PersonDO personDO = personDOS.get(0);
            object.put("account",personDO.getAccount());
            object.put("name",personDO.getName());
        }
        return object;
    }

}
