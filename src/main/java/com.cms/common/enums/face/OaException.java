package com.cms.common.enums.face;

import com.pandawork.core.common.exception.IBizExceptionMes;

/**
 * 就业办公平台异常枚举类
 * Created by Administrator on 2014/8/21.
 */
public enum OaException implements IBizExceptionMes {
    SystemException("系统异常！", 1),
    //    UploadFileFail("上传文件失败！", 2),
    DownloadFileFail("文件下载失败！", 3),
    TimeConflict("时间有冲突", 4),
    ContactExist("联系人已存在", 5),
    JobRequestExist("已存在该岗位需求", 6),
    RolePermissionExist("角色权限关联已存在", 7),
    UserRoleExist("用户角色关联已存在", 8),
    UsernameExist("用户名已存在", 9),
    ContactTypeIsNull("联系人类型不允许为空", 10),
    PasswordNotEqual("两次密码输入不一致", 11),
    ParamWrong("参数输入不合法", 12),
    PwdWrong("密码不正确", 13),
    PlaceExist("地点已存在", 14),
    LakeParam("缺少必要参数", 15),
    StudentExist("学生已存在", 16),
    JYOACompanyWrong("查询JYOA单位失败", 17),
    LoginFailed("登录失败，请检查用户名/密码是否正确", 23),
    UserNameNotNull("用户名不能为空", 24),
    ImportInfoIllegal("导入的数据不合法，请检查后重新导入", 26),
    UserInfoQueryFailed("查询用户信息失败", 27),
    UserInfoInsertFailed("添加用户信息失败", 28),
    UserInfoUpdateFailed("修改用户信息失败", 29),
    UserInfoDeleteFailed("删除用户信息失败", 30),
    CounsellorMajorsNotNull("请添加辅导员管理专业", 31),

    //上传
    ImageCompressedFail("图片压缩失败!", 18),
    UploadFileNotNull("上传的文件不能为空!", 19),
    UploadPathNotNull("上传的文件路径不能为空!", 20),
    UploadDirCreateFail("上传文件夹创建失败!", 21),
    UploadFileFail("文件上传失败", 22),

    //通用
    IdIllegal("Id为空或小于等于0", 1001),

    //学籍信息和学籍修改信息
    StuStatusInfoInsertFailed("添加学籍信息失败", 10001),
    StuStatusInfoUpdateFailed("修改学籍信息失败", 10002),
    StuStatusInfoDeleteFailed("删除学籍信息失败", 10003),
    StuStatusInfoQueryFailed("查询学籍信息失败", 10004),
    StuStatusInfoNotNull("学生信息不能为空", 10005),
    StuUpdateInfoInsertFailed("添加学籍修改信息失败", 10006),
    StuUpdateInfoQueryFailed("查询学籍修改信息失败", 10007),
    StuNumberNotNull("学号不能为空", 10008),
    StuUpdateInfoUpdateFailed("更新学籍修改信息失败", 10009),
    StuUpdateInfoNotNull("更新学籍修改信息失败", 10010),
    StuUpdateTypeIllegal("学籍修改类型类型不合法", 10011),
    BeforeAfterEqual("学籍修改前后信息不能相同", 10012),
    StuNumberExist("学号已存在", 10013),
    CandidateNumberExist("考生号已存在", 10014),
    IdNumberExist("身份证号已存在", 10015),

    //general
    //材料相关
    StuStatusInfoIdIllegal("学籍id为空或小于等于0", 11001),
    MaterialInsertFailed("新增材料失败", 11002),
    MaterialQueryFailed("查询材料失败", 11003),
    MaterialDeleteFailed("删除材料失败", 11004),
    MaterialUpdateFailed("修改材料失败", 11005),
    MaterialNotNull("修改材料失败", 11006),
    MaterialTypeIllegal("材料类型不合法", 11007),

    //学院相关
    CollegeQueryFailed("学院信息查询失败", 11101),
    CollegeCodeNotNull("学院代码不能为空", 11102),

    //学历相关
    QualificationQueryFailed("学历查询失败", 11201),
    QualificationCodeNotNull("学历代码不能为空", 11202),

    //地区相关
    PlaceQueryFailed("学历查询失败", 11301),
    PlaceCodeNotNull("学历代码不能为空", 11302),

    //困难生相关
    DifficultyQueryFailed("困难生查询失败", 11401),
    DifficultyCodeIllegal("困难生代码不能为空或不能为0", 11402),

    //民族相关
    NationQueryFailed("民族信息查询失败", 11501),
    NationIdNotNull("民族代码不能为空", 11502),

    //政治面貌相关
    PoliticalQueryFailed("政治面貌信息查询失败", 11601),
    PoliticalStandIdNotNull("政治面貌代码不能为空", 11602),

    //省份相关
    ProvinceQueryFailed("省份查询失败", 11701),
    ProvinceCodeNotNull("省份代码不能为空", 11702),

    //培养方式相关
    TrainingModeQueryFailed("培养方式查询失败", 11801),
    TrainingModeCodeNotNull("培养方式代码不能为空", 11802),


    //专业相关
    MajorQueryFailed("专业查询失败", 11901),
    MajorCodeNotNull("专业代码不能为空", 11902),

    //高校相关
    SchoolQueryFailed("专业查询失败", 12001),
    SchoolCodeNotNull("专业代码不能为空", 12002),

    //学生账户相关
    StudentUserInsertFailed("新增学生账户失败", 11901),
    StudentUserUpdateFailed("修改学生账户失败", 11902),
    StudentUserQueryFailed("查询学生账户失败", 11903),
    StudentUserRoleQueryFailed("查询学生-角色信息失败", 11903),
    StudentUserIsExist("学生账户已存在", 11904),
    StudentUserRoleIsExist("学生-角色信息已存在", 11905),
    StudentUserRoleInsertFailed("新增学生-角色信息失败", 11906),
    StudentUserRoleNotNull("学生-角色信息不能为空", 11907),

    //学院和学校管理派遣信息@Author QiuXiao
    DispatchUpdateFailed("学校或者学院派遣信息修改错误！", 20001),
    DispatchUpdateModelAtttributeError("学校或者学院修改", 20002),
    DispatchQueryFaild("条件查询派遣信息失败！", 20003),
    DispatchQueryModelAtttributeError("条件查询派遣信息失败！", 20004),
    DispatchUpdateRolePowerError("条件查询派遣信息失败！", 20005),
    DispatchParameterError("条件查询派遣信息参数错误！", 20006),
    JsonMapperProcessingError("条件查询派遣信息参数错误！", 20007),
    DispatchInfoIdIllegal("派遣信息id不合法", 20008),

    //变更业务
    QueryAlterInfoException("查询变更业务学生基本资料失败", 30001),
    QueryAlterMaterialException("查询变更业务材料失败", 30002),
    QueryAlterCheckException("查询变更业务审核结果失败", 30003),
    UpdateAlterCheckException("更改变更业务审核结果失败", 30004),
    CountCheckChangeException("变更业务计数失败", 30005),
    NewIdentityException("变更业务失败", 30006),
    QueryChangeCheckStatusFailed("查询变更业务审核结果失败", 30007),
    EnterFailedException("进入页面失败,您已提交过材料，若需修改，请联系辅导员!", 30008),

    //新协议
    QueryNewProtocolInfoException("查询申请新协议学生基本资料失败", 40001),
    QueryNewProtocolMaterialException("查询申请新业务材料失败", 40002),
    QueryNewProtocolCheckResultException("查询申请新协议审核结果失败", 40003),
    NewProtocolException("发放新协议失败", 40004),
    UpdateNewProtocolCheckException("更新发放新协议审核结果失败", 40005),
    CountCheckProtocolException("协议信息计数失败", 40006),
    ApplyForNewProtocolException("申请新协议失败", 40007),
    IsExistAgreementException("该协议编码编码已存在", 40008),
    NextStudentException("获取下一个学生失败", 40009),
    QueryProtocolCheckStatusFailed("查询申请新协议业务审核结果失败", 40010),


    //学生派遣信息
    StuDispatchInfoIsNotNull("派遣信息不能为空", 50001),
    StuDispatchInsertFailed("添加派遣信息失败", 50002),
    StuDispatchUpdateFailed("修改派遣信息失败", 50003),
    StuDispatchQueryFailed("查看派遣信息失败", 50004),

    //单位性质
    CompanyPropertyQueryFailed("单位性质查询失败", 51001),
    CompanyPropertyCodeNotNull("单位性质代码不能为空", 51002),

    //单位行业
    CompanyTradeQueryFailed("单位行业查询失败", 51101),
    CompanyTradeCodeNotNull("单位性质代码不能为空", 51102),

    //工作职位类别
    JobCodeQueryFailed("工作职位类别查询失败", 51201),
    JobCodeCodeNotNull("工作职位类别代码不能为空", 51202),

    //报到证类别
    ReportCodeQueryFailed("报到证类别查询失败", 51301),
    ReportCodeNotNull("报到证类别代码不能为空", 51302),

    //毕业去向
    WhereAboutGoQueryFailed("毕业去向查询失败", 51401),
    WhereAboutGoCodeNotNull("毕业去向代码不能为空", 51402),

    //办公信息
    CommentsInsertFailed("新增办公信息失败", 51501),
    CommentsUpdateFailed("修改办公信息失败", 51502),
    CommentsQueryFailed("查询办公信息失败", 51503),

    ;

    private String mes;
    private int code;

    OaException(String mes, int code) {
        this.mes = mes;
        this.code = code;
    }

    @Override
    public String getMes() {
        return mes;
    }

    @Override
    public int getCode() {
        //return Integer.parseInt(SMSEXCPTIONCODE + "" + code);
        return code;
    }
}
