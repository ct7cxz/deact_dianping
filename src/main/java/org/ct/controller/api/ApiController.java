package org.ct.controller.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ct.cache.TokenCache;
import org.ct.constant.ApiCodeEnum;
import org.ct.dto.*;
import org.ct.service.*;
import org.ct.util.CommontUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController     //定义接受请求方式，RequestBody
@RequestMapping(path = "/api")
public class ApiController {

    @Autowired
    private IAdService adService;

    @Autowired
    private IBusinessService businessService;

    @Autowired
    private IMemberService memberService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICommentService commentService;

    @Value("${pageAd}")
    private Integer pageAd;

    @Value("${apiPageBusiness}")
    private Integer pageBusiness;

    //广告
    @RequestMapping(path = "/homead", method = RequestMethod.GET)
    public List<AdDto> homead() {
        AdDto adDto = new AdDto();
        adDto.getPage().setPageNumber(pageAd);
        return adService.findAppCurrent(adDto);
    }

    /**
     * 首页 —— 推荐列表（猜你喜欢）
     *
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(path = "/homelist/{city}/{page.pageCurrent}", method = RequestMethod.GET)
    public BusinessListDto homelist(BusinessDto businessDto) {
        System.out.println("接收到的" + businessDto.getPage().getPageCurrent());
        BusinessListDto businessListDto = businessService.findAppCurrentByPage(businessDto);
        return businessListDto;
    }

    /**
     * 搜索结果页 - 搜索结果 - 三个参数
     *
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(path = "/search/{page.pageCurrent}/{city}/{category}/{keyword}", method = RequestMethod.GET)
    public BusinessListDto searchByKeyword(BusinessDto businessDto) {
        BusinessListDto businessListDto = businessService.findAppCurrentByPage(businessDto);
        return businessListDto;
    }

    /**
     * 搜索结果页 - 搜索结果 - 两个参数
     *
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(path = "/search/{page.pageCurrent}/{city}/{category}", method = RequestMethod.GET)
    public BusinessListDto search(BusinessDto businessDto) {
        BusinessListDto businessListDto = businessService.findAppCurrentByPage(businessDto);
        return businessListDto;
    }

    /**
     * 详情页 - 商户信息
     *
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(path = "/detail/info/{id}", method = RequestMethod.GET)
    public BusinessDto detail(@PathVariable("id") Long id) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\"title\":\"天下第一锅\",\"star\":4,\"price\":\"88\",\"subTitle\":\"重庆 & 四川 麻辣火锅\",\"desc\":\"营业时间 11:00 - 21:00 <br> 电话订购 11:00 - 19:00 <br> 网络订购 11:00 - 19:00\"}";
        return mapper.readValue(s, new TypeReference<BusinessDto>() {
        });
    }

    /*发送会员消息验证*/
    @RequestMapping(path = "/sms", method = RequestMethod.POST)
    public ApiCodeDto ams(@RequestParam("username") Long phone) {
        ApiCodeDto apiCodeDto;
        //判断用户是否已经注册过
        if (memberService.exists(phone)) {
            //生成6位数的code
            String code = CommontUtil.getRandomNum(6) + "";
            //保存手机号对应的验证码信息
            if (memberService.save(phone, code)) {
                //调用对应的通道，将用户信息发送到对应的手机号码上
                if (memberService.send(phone, code)) {
                    apiCodeDto = new ApiCodeDto(ApiCodeEnum.SUCCESS.getError(), code);
                } else {
                    apiCodeDto = new ApiCodeDto(ApiCodeEnum.SEND_FAIL);
                }
            } else {
                apiCodeDto = new ApiCodeDto(ApiCodeEnum.REPEAT_REQUEST);
            }
        } else {
            apiCodeDto = new ApiCodeDto(ApiCodeEnum.USER_NOT_EXISTS);
        }
        return apiCodeDto;
    }

    /**
     * 登录校验
     *
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ApiCodeDto login(@RequestParam("username") Long phone, @RequestParam("code") String code) {
        ApiCodeDto apiCodeDto;
        //取出缓存的验证码信息
        String saveCode = memberService.getCode(phone);
        if (saveCode != null) {
            if (saveCode.length() == 6) {
                //如果校验成功，则生成一个32位token信息
                String token = CommontUtil.uuid();
                //将生成信息存放到TokenCache中
                TokenCache.getInstance().saveToken(token, phone);
                //将生成的token信息返回给前端页面
                apiCodeDto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
                apiCodeDto.setToken(token);
            } else {
                apiCodeDto = new ApiCodeDto(ApiCodeEnum.CODE_ERROR);
            }
        } else {
            apiCodeDto = new ApiCodeDto(ApiCodeEnum.CODE_INVALID);
        }
        return apiCodeDto;
    }

    /**
     * 买单
     *
     * @param orderForBuyDto
     * @return
     */
    @RequestMapping(path = "/order", method = RequestMethod.POST)
    public ApiCodeDto order(OrderForBuyDto orderForBuyDto) {
        //校验token信息
        ApiCodeDto apiCodeDto;
        Long phone = TokenCache.getInstance().getPhone(orderForBuyDto.getToken());
        if (orderForBuyDto.getToken() != null && orderForBuyDto.getUsername().equals(phone)) {
            //检验通过
            OrdersDto ordersDto = new OrdersDto();
            Long memberId = memberService.getIdByPhone(orderForBuyDto.getToken());
            ordersDto.setNum(orderForBuyDto.getNum());
            ordersDto.setPrice(orderForBuyDto.getPrice());
            ordersDto.setBusinessId(orderForBuyDto.getId());
            ordersDto.setMemberId(memberId);
            orderService.add(ordersDto);
            apiCodeDto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
        } else {
            apiCodeDto = new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
        }
        return apiCodeDto;
    }

    /**
     * 订单列表
     */
    @RequestMapping(value = "/orderlist/{username}", method = RequestMethod.GET)
    public List<OrdersDto> orderlist(@PathVariable("username") Long username) {
        // 根据手机号取出会员ID
        Long memberId = memberService.getIdBy(username);
        return orderService.getListByMemberId(memberId);
    }

    /**
     * 提交评论
     */
    @RequestMapping(value = "/submitComment", method = RequestMethod.POST)
    public ApiCodeDto submitComment(CommentForSubmitDto dto) {
        ApiCodeDto result;
        // TODO 需要完成的步骤：
        // 1、校验登录信息：token、手机号
        Long phone = memberService.getIdByPhone(dto.getToken());
        if (phone != null && phone.equals(dto.getUsername())) {
            // 2、根据手机号取出会员ID
            Long memberId = memberService.getIdBy(phone);
            // 3、根据提交上来的订单ID获取对应的会员ID，校验与当前登录的会员是否一致
            OrdersDto ordersDto = orderService.getById(dto.getId());
            if(ordersDto.getMemberId().equals(memberId)) {
                // 4、保存评论
                commentService.add(dto);
                result = new ApiCodeDto(ApiCodeEnum.SUCCESS);
                // TODO
                // 5、还有一件重要的事未做
            } else {
                result = new ApiCodeDto(ApiCodeEnum.NO_AUTH);
            }
        } else {
            result = new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
        }
        return result;
    }


    //评论
    @RequestMapping(path = "/submitComment", method = RequestMethod.POST)
    public Map<String, Object> submitComment() {
        Map<String, Object> map = new HashMap<>();
        map.put("errno", 0);
        map.put("msg", "ok");
        return map;
    }
}
