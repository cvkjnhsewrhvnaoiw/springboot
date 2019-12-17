package com.hg.conterllor;

import com.hg.entity.Boke;
import com.hg.service.BokeService;
import com.hg.util.MdToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 888 on 2019/11/14.
 */
@Controller
@RequestMapping("boke")
public class BokeConterllor {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private BokeService bokeService;
    @RequestMapping("show.do")
    @ResponseBody
    public Map<String,Object> show(Integer page,Integer rows,String searchField,String searchString,String searchOper){
        /*
        * rows 每页记录数
        * page 当前页数
        * */
        Map<String,Object> map = new HashMap<>();
        //查询总条数/记录数
        List<Boke> bokes = bokeService.queryAll();
        Integer total = bokes.size();
        //计算总页数
        Integer totalPage = total%rows==0?total/rows:(total/rows)+1;
        //分页结果
        List<Boke> list = bokeService.queryMany(page,rows);
        map.put("rows",list);//返回的查询结果
        map.put("page",page);//当前页
        map.put("total",totalPage);//总页数
        map.put("records",total);//总记录数
        return map;
    }
    @RequestMapping("findById")
    public ModelAndView findById(String id,String qian){
        ModelAndView mv = new ModelAndView();
        Boke boke = bokeService.queryById(id);
        String convert = MdToHtml.convert(boke.getContent());
        boke.setContent(convert);

        mv.addObject("boke",boke);
        if (qian != null) {
            mv.setViewName("forward:/jsp/ditl.jsp");
        } else {
            mv.setViewName("forward:/jsp/update.jsp");
        }
        return mv;
    }
    @RequestMapping("edit")
    @ResponseBody
    public  void edit(String oper,Boke boke){
        bokeService.delete(boke.getId());
    }
    @RequestMapping("update")
    public  String update(Boke boke){
        bokeService.update(boke);
        return "jsp/main";
    }
    @RequestMapping("add")
    public String add(Boke boke){
        bokeService.add(boke);
        return "jsp/main";
    }
    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<Boke> bokes = bokeService.queryAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",bokes);
        mv.setViewName("forward:/jsp/index.jsp");
        return mv;
    }

}
