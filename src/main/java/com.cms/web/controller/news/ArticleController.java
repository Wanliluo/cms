package com.cms.web.controller.news;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.common.entity.news.Article;
import com.cms.common.entity.news.Category;
import com.cms.common.util.Pagination;
import com.cms.service.news.ArticleService;
import com.cms.service.news.CategoryService;

import com.cms.web.controller.common.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 文章controller层
 */

@Controller
@RequestMapping(value = "/article")
public class ArticleController extends AbstractController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    //去首页
    @RequestMapping(value="/toindex", method =RequestMethod.GET)
    public String toList() {
        return "news/index";
    }

    //去列表页
    @RequestMapping(value="/tolist", method =RequestMethod.GET)
    public String toList(Model model) {
        try {
            List<Category> categoryList = categoryService.queryByIsParent(0);
            model.addAttribute("categoryList", categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "news/list";
    }

    //查询列表
    @RequestMapping(value = "/ajax/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryArticle(@RequestParam("page") int page,
                                   @RequestParam(value="categoryId", defaultValue = "") String categoryId,
                                   @RequestParam(value="title", defaultValue = "") String title,
                                   @RequestParam(value="categoryName", defaultValue = "") String Name) {
        Article article1 = null;
        JSONArray ja = new JSONArray();
        int dataCount = 0 ;

        System.out.println(Name);
        try {
            article1 = new Article();
            if(Name==null||"".equals(Name)){
                article1.setTitle(title);
                article1.setCategoryId(categoryId);
            }else {

                    Category category = categoryService.queryByName(Name);
                    article1.setTitle(title);
                     article1.setCategoryId(category.getId());

            }

            dataCount = 0;

            dataCount = articleService.getCount(article1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pagination page1 = new Pagination(dataCount,pageSize,page);
        try {
            List<Article> list = articleService.getArticleList(article1, page1);
            for(Article article2 :list){
                if (article2.getLastModifiedTime()==null||"".equals(article2.getLastModifiedTime())) {
                    article2.setLastModifiedTime1("无");
                } else {
                    article2.setLastModifiedTime1(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article2.getLastModifiedTime()));
                }
                JSONObject jo = new JSONObject();
                jo.put("id", article2.getId());
                jo.put("categoryName", categoryService.queryById(article2.getCategoryId()).getName());
                jo.put("title", article2.getTitle());
                jo.put("weight", article2.getWeight());
                jo.put("clicks", article2.getClicks());
                jo.put("author", article2.getAuthor());
                jo.put("time", article2.getLastModifiedTime1());
                ja.add(jo);
            }
            return sendJsonArray(ja, dataCount);
        } catch (Exception e) {
            e.printStackTrace();
            return sendErrMsgAndErrCode(e);
        }

    }

    //去详情页
    @RequestMapping(value="/todetail/{id}", method = RequestMethod.GET)
    public String toDetail(@PathVariable("id") String id, Model model) {
        try {
            Article article =articleService.getArticleById(id);
            if (article.getLastModifiedTime()==null||"".equals(article.getLastModifiedTime())) {
                article.setLastModifiedTime1("无");
            } else {
                article.setLastModifiedTime1(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(article.getLastModifiedTime()));
            }
            model.addAttribute("article", article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "news/detail";
    }

    //添加
    @RequestMapping(value ="/add", method = RequestMethod.GET)
    public String add(Article article) {
        try {
            article.setAuthor("环球时报");
            articleService.addArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/article/tolist";
    }

    //去修改页
    @RequestMapping(value ="/ajax/toupdate", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject toUpdate(@RequestParam("id") String id) {
        try {
            Article article = articleService.getArticleById(id);
            JSONObject jo = new JSONObject();
            jo.put("id", article.getId());
            jo.put("categoryName", categoryService.queryById(article.getCategoryId()).getName());
            jo.put("title", article.getTitle());
            jo.put("content", article.getContent());

            return sendJsonObject(jo);
        } catch (Exception e) {
            e.printStackTrace();
            return sendErrMsgAndErrCode(e);
        }
    }

    //修改
    @RequestMapping(value ="/update", method = RequestMethod.GET)
    public String update(Article article) {
        try {
            article.setAuthor("张三李四王五");
           articleService.updateArticleById(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/article/tolist";
    }

    //删除
    @RequestMapping(value ="/ajax/delete", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject delArticle(@RequestParam("id") String id) {
        try {
            articleService.delArticleById(id);
            JSONObject code = new JSONObject();
            code.put("code", 1);
            return  code;
        } catch (Exception e) {
            e.printStackTrace();
            return sendErrMsgAndErrCode(e);
        }
    }
}
