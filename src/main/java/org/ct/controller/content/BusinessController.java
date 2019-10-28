package org.ct.controller.content;

import org.ct.constant.DicTypeConst;
import org.ct.constant.PageCodeEnum;
import org.ct.dto.BusinessDto;
import org.ct.bean.Business;
import org.ct.service.IBusinessService;
import org.ct.service.IDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商户信息管理controller
 */
@RequestMapping(path = "/business")
@Controller
public class BusinessController {

    @Autowired
    private IBusinessService businessService;

    @Autowired
    private IDicService dicService;

    /*显示初始化界面*/
    @RequestMapping()
    public String init(Model model){
        BusinessDto businessDto = new BusinessDto();
        model.addAttribute("businessList",businessService.findCurrentByPage(businessDto));
        model.addAttribute("page", businessDto.getPage());
        return "content/listBusiness";
    }

    /*显示列表页面*/
    @RequestMapping(path = "/listBusiness")
    public String BusinessList(BusinessDto businessDto, Model model) {
        List<BusinessDto> currentByPage = businessService.findCurrentByPage(businessDto);
        model.addAttribute("businessList",currentByPage);
        model.addAttribute("page", businessDto.getPage());
        return "content/listBusiness";
    }

    /*将请求转发到新增商户信息页面*/
    @RequestMapping(path = "/toAddBusiness")
    public String toAddBusiness(Model model) {
        //城市
        model.addAttribute("citys", dicService.findByType(DicTypeConst.CITY));
        //类别
        model.addAttribute("categorys", dicService.findByType(DicTypeConst.CATEGORY));
        return "content/addBusiness";
    }

    /*增加商户信息*/
    @RequestMapping(path = "/addBusiness")
    public String addBusiness(BusinessDto businessDto, Model model) {
        boolean isAddBusiness = businessService.addBusiness(businessDto);
        if (isAddBusiness) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.INSERT_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.INSERT_FALI);
        }
        return "content/addBusiness";
    }

    //修改商户信息
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public String exitBusiness(@PathVariable("id") Long id, Model model, BusinessDto businessDto) {
        boolean isUpdateSuccess = businessService.updateBusiness(businessDto);
        if (isUpdateSuccess) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.UPDATE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.UPDATE_FALI);
        }
        return "redirect:/business/listBusiness";
    }

    /*获得修改的商户的初始信息信息*/
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String updateBusiness(@PathVariable("id") Long id, Model model) {
        Business business = businessService.findBusiness(id);
        model.addAttribute("business", business);
        //城市
        model.addAttribute("citys", dicService.findByType(DicTypeConst.CITY));
        //类别
        model.addAttribute("categorys", dicService.findByType(DicTypeConst.CATEGORY));
        return "content/exitBusiness";
    }

    /*删除商户信息*/
    @RequestMapping(value = "/{id}/{pageCurrent}", method = RequestMethod.DELETE)
    public String deleteBusiness(BusinessDto businessDto, Model model, @PathVariable("pageCurrent") Integer pageCurrent) {
        boolean isDelete = businessService.deleteBusiness(businessDto);
        model.addAttribute("pageCurrent", pageCurrent);
        if (isDelete) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DELETE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DELETE_FAIL);
        }
        return "redirect:/business/listBusiness";
    }
}
