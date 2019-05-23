package com.dhcc.csr.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.dhcc.csr.db.greendao.gen.DaoSession;
import com.dhcc.csr.db.greendao.gen.UserInfoDao;

/**
 * @author wlsh
 * @date 2019/1/17 11:50
 * @description 用户
 */
@Entity(active = true,nameInDb = "USER_INFO")
public class UserInfo {
    private Long id;
    private String name;  //人员名称
    private String loginname; //用户工号*(用户登录账号)
    private String password; //用户密码
    private String weight;  //排序 暂时不用这个字段排序
    private String email;  //电子邮箱
    private String mobile;  //手机号码
    private String phone;  //电话号码
    private String rtxid;  //RTX号码
    private String gender;  //性别
    private String levelgroupid; //暂无用处
    private String levelgroupname;//暂无用处
    private String path;  //路径
    private String pathName; //路径名称
    private String parentid; //机构父级编号
    private String orgId;  //机构编号
    private String orgName;  //机构名称
    private String roleId;  //角色编码
    private String roleName; //角色名称
    private String jobId;  //职位编号
    private String jobName;  //职位名称
    private String groupId;  //岗位编号
    private String groupName; //岗位名称
    private String relation; //关系  暂无用处
    private String isLocal;  //部门信息是否为远程数据  0表示远程 1表示本地
    private String isDelete; //部门删除地点 1表示删除 0表示未删除
    private String isUdelete; //人员删除字段 1表示删除 0表示未删除
    private String isULocal; //人员信息是否为远程数据  0表示远程 1表示本地
    private String valid;  // 移动端登录是有成功 0成功 1 密码或者账户错误
    private String politicalStatus; //政治面貌
    private String jobCity;  //工作城市
    private String notionality; //国籍
    private String jobLayer; //职位等级编号
    private String skillLevel;  //人才等级编号
    private String jobType;  //职务类型
    private Long deptSort; //部门排序
    private Long userSort; //人员排序
    private String deptLevel; //部门层级
    private String jobSituation;//员工在职情况
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 437952339)
    private transient UserInfoDao myDao;

    @Generated(hash = 1633328855)
    public UserInfo(Long id, String name, String loginname, String password,
            String weight, String email, String mobile, String phone, String rtxid,
            String gender, String levelgroupid, String levelgroupname, String path,
            String pathName, String parentid, String orgId, String orgName,
            String roleId, String roleName, String jobId, String jobName,
            String groupId, String groupName, String relation, String isLocal,
            String isDelete, String isUdelete, String isULocal, String valid,
            String politicalStatus, String jobCity, String notionality,
            String jobLayer, String skillLevel, String jobType, Long deptSort,
            Long userSort, String deptLevel, String jobSituation) {
        this.id = id;
        this.name = name;
        this.loginname = loginname;
        this.password = password;
        this.weight = weight;
        this.email = email;
        this.mobile = mobile;
        this.phone = phone;
        this.rtxid = rtxid;
        this.gender = gender;
        this.levelgroupid = levelgroupid;
        this.levelgroupname = levelgroupname;
        this.path = path;
        this.pathName = pathName;
        this.parentid = parentid;
        this.orgId = orgId;
        this.orgName = orgName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.jobId = jobId;
        this.jobName = jobName;
        this.groupId = groupId;
        this.groupName = groupName;
        this.relation = relation;
        this.isLocal = isLocal;
        this.isDelete = isDelete;
        this.isUdelete = isUdelete;
        this.isULocal = isULocal;
        this.valid = valid;
        this.politicalStatus = politicalStatus;
        this.jobCity = jobCity;
        this.notionality = notionality;
        this.jobLayer = jobLayer;
        this.skillLevel = skillLevel;
        this.jobType = jobType;
        this.deptSort = deptSort;
        this.userSort = userSort;
        this.deptLevel = deptLevel;
        this.jobSituation = jobSituation;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRtxid() {
        return rtxid;
    }

    public void setRtxid(String rtxid) {
        this.rtxid = rtxid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLevelgroupid() {
        return levelgroupid;
    }

    public void setLevelgroupid(String levelgroupid) {
        this.levelgroupid = levelgroupid;
    }

    public String getLevelgroupname() {
        return levelgroupname;
    }

    public void setLevelgroupname(String levelgroupname) {
        this.levelgroupname = levelgroupname;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(String isLocal) {
        this.isLocal = isLocal;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIsUdelete() {
        return isUdelete;
    }

    public void setIsUdelete(String isUdelete) {
        this.isUdelete = isUdelete;
    }

    public String getIsULocal() {
        return isULocal;
    }

    public void setIsULocal(String isULocal) {
        this.isULocal = isULocal;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getJobCity() {
        return jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }

    public String getNotionality() {
        return notionality;
    }

    public void setNotionality(String notionality) {
        this.notionality = notionality;
    }

    public String getJobLayer() {
        return jobLayer;
    }

    public void setJobLayer(String jobLayer) {
        this.jobLayer = jobLayer;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Long getDeptSort() {
        return deptSort;
    }

    public void setDeptSort(Long deptSort) {
        this.deptSort = deptSort;
    }

    public Long getUserSort() {
        return userSort;
    }

    public void setUserSort(Long userSort) {
        this.userSort = userSort;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getJobSituation() {
        return jobSituation;
    }

    public void setJobSituation(String jobSituation) {
        this.jobSituation = jobSituation;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 821180768)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserInfoDao() : null;
    }
}
