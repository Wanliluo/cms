package com.cms.web.controller.news;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.common.entity.news.Category;
import com.cms.service.news.CategoryService;
import com.cms.web.controller.common.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * 文章controller层
 */

@Controller
@RequestMapping(value = "/category")
public class CategoryController extends AbstractController{
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value ="/ajax/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray categoryList() {
            JSONArray ja = new JSONArray();
            Category category = new Category();
            category.setIsParent(-1);
            category.setDescription("");
            category.setId("");
            category.setName("");
            category.setParentIds("");
            category.setSiteId("");
        List<Category> list = null;
        try {
            list = categoryService.getListByCondition(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String isParent;
            for(Category category1 : list) {
               if(category1.getIsParent()==1){
                    isParent="ture";
               }else{
                    isParent="false";
               }
                JSONObject jo = new JSONObject();
                jo.put("id", category1.getId());
                jo.put("pId", category1.getParentId());
                jo.put("name", category1.getName());
                jo.put("isParent", isParent);
                ja.add(jo);
            }
            return ja;
    }
}
