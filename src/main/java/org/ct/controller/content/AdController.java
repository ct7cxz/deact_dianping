package org.ct.controller.content;

import org.ct.constant.PageCodeEnum;
import org.ct.dto.AdDto;
import org.ct.bean.Ad;
import org.ct.service.IAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/ad")
public class AdController {

    @Autowired
    IAdService adService;

    /*跳转到新增页面*/
    @RequestMapping(path = "/toAddAd")
    public String toAddAd(){
        return "content/addAd";
    }

    /*处理新增广告界面传递过来的内容*/
    @RequestMapping(path = "/saveAd")
    public String saveAd(AdDto adDto, Model model) {
        boolean isSaveAd = adService.saveAd(adDto);
        if (isSaveAd) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
        }
        return "content/addAd";
    }

    /*初始化广告列表界面*/
    @RequestMapping()
    public String init(Model model){
        AdDto adDto = new AdDto();
        //查找列表信息
        List<AdDto> list = adService.findCurrentByPage(adDto);
        //查询页面信息
        model.addAttribute("list",list);
        model.addAttribute("page", adDto.getPage());
        return "content/listAd";
    }


    /*展示列表的详情信息*/
    @RequestMapping(path = "/listAd")
    public String listAd(AdDto adDto, Model model) {
        //查找列表信息
        List<AdDto> list = adService.findCurrentByPage(adDto);
        //查询页面信息
        model.addAttribute("list",list);
        model.addAttribute("page", adDto.getPage());
        return "content/listAd";
    }

    /*删除用户的信息*/
    @RequestMapping(path = "/adDelete")
    public String adDelete(@RequestParam("id") Integer id, @RequestParam("pageCurrent") Integer pageCurrent, Model model) {
        boolean isDelete = adService.adDelete(id);
        model.addAttribute("page.pageCurrent", pageCurrent);
        if (isDelete) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DELETE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DELETE_FAIL);
        }
        return "forward:/ad/listAd";
    }

    /*展示需要修改的广告信息*/
    @RequestMapping(path = "/showAdUpdate")
    public String showAdUpdate(@RequestParam("id") Integer id, Model model) {
        Ad ad = adService.showAdUpdate(id);
        model.addAttribute("ad", ad);
        return "content/exitAd";
    }

    /*修改修改信息*/
    @RequestMapping(path = "/updateAd")
    public String updateAd(AdDto adDto, Model model) {
        Boolean isUpdate = adService.adUpdate(adDto);
        if (isUpdate) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.UPDATE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.UPDATE_FALI);
        }
        return "redirect:/ad/listAd";
    }
}
