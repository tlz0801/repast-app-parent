package com.aaa.eight.app.base;

import com.aaa.eight.app.status.LoginStatus;
import org.springframework.stereotype.Controller;

/**
 * @Project 102-repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/18 19:18
 **/
@Controller
public class BaseController {

     /**
       *  统一返回值，登录成功，使用系统消息返回
       *@Author TLZ
       *@Date 19:27  2019/12/18 
       *@Param 
       *@return 
       **/
    protected ResultData success(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     *  统一返回值，登录成功，使用自定义消息返回
     *@Author TLZ
     *@Date 19:28  2019/12/18
     *@Param
     *@return
     **/
    protected ResultData success(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *  统一返回值，登录成功，使用系统消息返回并返回数据
     *@Author TLZ
     *@Date 19:28  2019/12/18
     *@Param
     *@return
     **/
    protected ResultData success(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     *  统一返回值，登录成功，自定义返回消息并且返回结果
     *@Author TLZ
     *@Date 19:28  2019/12/18
     *@Param
     *@return
     **/
    protected ResultData success(String msg, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     *  统一返回值，登录成功，使用系统消息返回并返回数据
     *@Author TLZ
     *@Date 19:28  2019/12/18
     *@Param
     *@return
     **/
    protected ResultData failed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    protected ResultData getTokenFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(LoginStatus.LOGIN_FAILED.getMsg());
        return resultData;
    }

    // TODO 暂时未完成，需要什么方法自己添加

    protected ResultData failed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.NO_DATA.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
}
