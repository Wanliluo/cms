package com.cms.mapper.face;


import com.cms.common.entity.face.FaceRectangle;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 用户Mapper
 * user:
 * date:
 * time:
 */
public interface FaceRectangleMapper {
    /**
     * 根据PersonId查找表情测试指数列表
     * @param personId
     * @return
     * @throws Exception
     */
    public List<FaceRectangle> queryByPersonId(@Param("personId") Integer personId) throws Exception;

    /**
     * 通过ID查找表情测试指数
     * @param id
     * @return
     * @throws Exception
     */
    public FaceRectangle queryById(@Param("id") Integer id) throws Exception;

    /**
     * 删除用户表情测试指数
     * @param id
     * @throws Exception
     */
    public void delFaceRectangle(@Param("id") Integer id) throws Exception;
}
