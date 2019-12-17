package com.hg.conterllor;

import com.hg.entity.Boke;
import com.hg.service.BokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/*@RestController
@RequestMapping("boke1")
public class BokeConterllor1 {
    @Autowired
    private BokeService bokeService;

    @GetMapping("/findById/{id}")
    public Boke findById(@PathVariable("id") String id) {
        System.out.println("================");
        Boke boke = bokeService.queryById(id);
        return boke;
    }

    @PostMapping("add")
    public void add(@RequestBody Boke boke) {
        bokeService.add(boke);
    }

    @PutMapping("update")
    public void update(@RequestBody Boke boke) {
        bokeService.update(boke);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") String id) {
        bokeService.delete(id);
    }

    @RequestMapping("text")
    public String text(HttpServletRequest request) {
        String id = request.getSession().getId();
        return id;
    }
}*/
