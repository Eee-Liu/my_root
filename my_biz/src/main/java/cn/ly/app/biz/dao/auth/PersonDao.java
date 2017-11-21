package cn.ly.app.biz.dao.auth;

import cn.ly.app.biz.domain.dobj.auth.PersonDO;
import cn.ly.app.biz.domain.query.auth.PersonQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * PersonDao* 
 */
@Repository
public interface PersonDao {

 
/** 
  * 插入数据
  * @param personDO
  * @return 
  */
public Integer insert(PersonDO personDO);
 
/** 
  * 通过ID更新信息
  * @param personDO
  * @return 
  */
public Integer updateById(PersonDO personDO);
 
/** 
  * 通过ID获取信息
  * @param id
  * @return 
  */
public PersonDO queryById(Long id);
 
/** 
  * 根据条件查询信息
  * @param query
  * @return 
  */
public List<PersonDO> query(PersonQuery query);
 
/** 
  * 统计满足查询条件的记录个数
  * @param query
  * @return 
  */
public Integer count(PersonQuery query);
 
/** 
  * 通过ID删除信息
  * @param id
  * @return 
  */
public Integer deleteById(Long id);

	Integer deleteByExcelNo(Long excelNo);
/**
  * 根据ID批量查询信息
  * @param ids
  * @return 
  */
public List<PersonDO> queryByIds(List<Long> ids);
}