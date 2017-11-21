package cn.ly.app.biz.domain.query.auth;


import cn.ly.app.core.lang.BaseQuery;

import java.util.Date;


/**
 * PersonQuery 
 * @author  
 * 
 */ 
public class PersonQuery extends BaseQuery {

   //id
	private Long id;
   //创建人
	private Long creatorId;
   //更新人
	private Long updaterId;
   //创建时间
	private Date createTime;
   //更新时间
	private Date updateTime;
   //0
	private Integer isDelete;
   //登录账号
	private String account;
   //手机号
	private String phone;
   //密码
	private String pwd;
   //是否可以登录，1-是 0-否
	private Integer canLogin;
   //是否是管理员
	private Integer isAdmin;
   //上级pid
	private Long superPid;
   //名称
	private String name;
   //电子邮件
	private String email;
   //头像
	private String headPic;
   //toC加价比率
	private Float toCusPlus;
   //B-b加价比率,单位%
	private Float busSubbusPlus;
   //B-b拥金,单位%
	private Float busSubbusCom;
   //地址
	private String address;
   //01干线 02支线 03直配, 多个;分隔
	private String logistic;
   //合同开始时间
	private Date contractStartTime;
   //合同失效时间
	private Date contractEndTime;
   //SAP编号
	private String sapNo;
   //大B的eCard卡号
	private String ecardNo;
	//昵称
	private String nickName;
	//备注
	private String remark;
	//所属公司名称
	private String company;
	//从excel导入的唯一标识
	private Long excelNo;
	//客户端类型:1-app端;2-admin后台管理端
	private Integer systemType;

 public void setId(Long id){
 this.id=id;
}

 public Long  getId(){
    return this.id;
}

 public void setCreatorId(Long creatorId){
 this.creatorId=creatorId;
}

 public Long  getCreatorId(){
    return this.creatorId;
}

 public void setUpdaterId(Long updaterId){
 this.updaterId=updaterId;
}

 public Long  getUpdaterId(){
    return this.updaterId;
}

 public void setCreateTime(Date createTime){
 this.createTime=createTime;
}

 public Date  getCreateTime(){
    return this.createTime;
}

 public void setUpdateTime(Date updateTime){
 this.updateTime=updateTime;
}

 public Date  getUpdateTime(){
    return this.updateTime;
}

 public void setIsDelete(Integer isDelete){
 this.isDelete=isDelete;
}

 public Integer  getIsDelete(){
    return this.isDelete;
}

 public void setAccount(String account){
 this.account=account;
}

 public String  getAccount(){
    return this.account;
}

 public void setPhone(String phone){
 this.phone=phone;
}

 public String  getPhone(){
    return this.phone;
}

 public void setPwd(String pwd){
 this.pwd=pwd;
}

 public String  getPwd(){
    return this.pwd;
}

 public void setCanLogin(Integer canLogin){
 this.canLogin=canLogin;
}

 public Integer  getCanLogin(){
    return this.canLogin;
}

 public void setIsAdmin(Integer isAdmin){
 this.isAdmin=isAdmin;
}

 public Integer  getIsAdmin(){
    return this.isAdmin;
}

 public void setSuperPid(Long superPid){
 this.superPid=superPid;
}

 public Long  getSuperPid(){
    return this.superPid;
}

 public void setName(String name){
 this.name=name;
}

 public String  getName(){
    return this.name;
}

 public void setEmail(String email){
 this.email=email;
}

 public String  getEmail(){
    return this.email;
}

 public void setHeadPic(String headPic){
 this.headPic=headPic;
}

 public String  getHeadPic(){
    return this.headPic;
}

 public void setToCusPlus(Float toCusPlus){
 this.toCusPlus = toCusPlus;
}

 public Float getToCusPlus(){
    return this.toCusPlus;
}

 public void setBusSubbusPlus(Float busSubbusPlus){
 this.busSubbusPlus=busSubbusPlus;
}

 public Float  getBusSubbusPlus(){
    return this.busSubbusPlus;
}

 public void setBusSubbusCom(Float busSubbusCom){
 this.busSubbusCom=busSubbusCom;
}

 public Float  getBusSubbusCom(){
    return this.busSubbusCom;
}

 public void setAddress(String address){
 this.address=address;
}

 public String  getAddress(){
    return this.address;
}

 public void setLogistic(String logistic){
 this.logistic=logistic;
}

 public String  getLogistic(){
    return this.logistic;
}

 public void setContractStartTime(Date contractStartTime){
 this.contractStartTime=contractStartTime;
}

 public Date  getContractStartTime(){
    return this.contractStartTime;
}

 public void setContractEndTime(Date contractEndTime){
 this.contractEndTime=contractEndTime;
}

 public Date  getContractEndTime(){
    return this.contractEndTime;
}

 public void setSapNo(String sapNo){
 this.sapNo=sapNo;
}

 public String  getSapNo(){
    return this.sapNo;
}

 public void setEcardNo(String ecardNo){
 this.ecardNo=ecardNo;
}

 public String  getEcardNo(){
    return this.ecardNo;
}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getExcelNo() {
		return excelNo;
	}

	public void setExcelNo(Long excelNo) {

		this.excelNo = excelNo;
	}

	public Integer getSystemType() {
		return systemType;
	}

	public void setSystemType(Integer systemType) {
		this.systemType = systemType;
	}
}