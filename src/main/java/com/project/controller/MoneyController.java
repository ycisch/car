package com.project.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.project.model.Money;
import com.project.util.AlipayConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-30 00:28
 */
public class MoneyController {

    /**
     *@Description: 跳转到支付页面
     *@Param: [modelAndView]
     *@return: org.springframework.web.servlet.ModelAndView
     *@Author: Administrator
     *@date: 2020/2/28
     */
    @RequestMapping("goMoneyView")
    public ModelAndView goMoneyView(ModelAndView modelAndView){
        modelAndView.setViewName("money/addMoney");
        return modelAndView;
    }

    /**
     *@Description: 跳转到交易记录页面
     *@Param: [modelAndView]
     *@return: org.springframework.web.servlet.ModelAndView
     *@Author: Administrator
     *@date: 2020/3/3
     */
    @RequestMapping("goMoneyList")
    public ModelAndView goMoneyList(ModelAndView modelAndView){
        modelAndView.setViewName("money/moneyList");
        return modelAndView;
    }

    /**
     *@Description: 支付金额
     *@Param: [request, response, id, money]
     *@return: void
     *@Author: Administrator
     *@date: 2020/2/28
     */
    @RequestMapping("applyMoney")
    public void applyMoney(HttpServletRequest request, HttpServletResponse response, String id, String money, String moneyType) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        Money.idmoney = id;
        Money.money = Float.parseFloat(money);
        request.getSession().setAttribute("moneyType",moneyType);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = id;
        //付款金额，必填
        String total_amount = money;
        //订单名称，必填
        String subject = "业主缴费";
        //商品描述，可空
        String body = "商品描述";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
            response.setContentType("text/html;charset=" + AlipayConfig.charset);
            response.getWriter().write(result);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            response.getWriter().write("捕获异常出错");
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *@Description: 进行记录与订单以及司机车辆信息更新
     *@Param: [request, response]
     *@return: void
     *@Author: Administrator
     *@date: 2020/2/28
     */
    @RequestMapping("updateInfo")
    public String updateMoney(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "common/success";
    }
}
