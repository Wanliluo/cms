package com.cms.service.face;

import com.cms.common.entity.face.FaceRectangle;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Service
 * user:ouym
 * date: 2014/9/13
 * time: 17:09
 */
public interface FaceRectangleService {
    /**
     * 根据PersonId查找表情测试指数列表
     * @param personId
     * @return
     * @throws Exception
     */
    public List<FaceRectangle> queryByPersonId(Integer personId) throws Exception;

    /**
     * 通过ID查找表情测试指数
     * @param id
     * @return
     * @throws Exception
     */
    public FaceRectangle queryById(Integer id) throws Exception;

    /**
     * 添加用户表情测试指数
     * @param faceRectangle
     * @throws SSException
     */
    public void addFaceRectangle(FaceRectangle faceRectangle) throws SSException;

    /**
     * 删除用户表情测试指数
     * @param id
     * @throws Exception
     */
    public void delFaceRectangle(Integer id) throws Exception;

    /**
     * 表情识别
     * @param address
     * @return
     * @throws Exception
     */
    public FaceRectangle face(String address) throws Exception;

    /**
     * 上传本地图片表情识别
     * @param address
     * @return
     * @throws Exception
     */
    public FaceRectangle face1(String address) throws Exception;


}
