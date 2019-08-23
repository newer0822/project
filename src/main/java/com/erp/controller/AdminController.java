package com.erp.controller;

import com.erp.Util.JwtTokenUtil;
import com.erp.Util.SecurityCode;
import com.erp.Util.SecurityImage;
import com.erp.domain.Admin;
import com.erp.service.AdminService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${auth.header}") //application.yml 获取auth.header的值
    private String header;
    private String str;//程序输出的验证码

    /**
     *
     * dadadad
     * 登陆
     * @param username
     * @param pwd
     * @param yzm
     * @return
     */
    @PostMapping("/getAdmin")
    public ResponseEntity<?> checkName(@RequestParam("username") String username,
                                       @RequestParam("pwd")String pwd,
                                       @RequestParam("yzm") String yzm
                                     ){
        String token;
        Admin admin=adminService.Login(username,pwd);
        System.out.println(admin+"====>");
        if (str.equals(yzm)){//判断验证码

            if (admin!=null){//用户名和密码在用户表中存

                 token=jwtTokenUtil.createJwt(username);


            }else {
                token= "用户名或密码错误";
            }
        }else {
            token= "验证码错误";
        }

        return new ResponseEntity<>(token,HttpStatus.OK);
    }


    /**
     * 生成图片验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/img")
    public void createImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        str = SecurityCode.getSecurityCode();
        BufferedImage bufimg = SecurityImage.createImage(str);
        // 设置响应头部不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("cache-Control", "no-cache");
        // 设置内容响应格式
        response.setContentType("image/jpeg");
        // 设置过期时间
        response.setDateHeader("Expirs", 0);
        // 通过图片io流写出去
        ImageIO.write(bufimg, "JPEG", response.getOutputStream());
    }


    @RequestMapping("/check")
    public ResponseEntity<?> check(HttpServletRequest request){
        String token= request.getHeader(header);
        Admin ad=null;
        System.out.println(token);
        if (token!=null){

            Claims claims=jwtTokenUtil.parseJWT(token);
            System.out.println(claims.getIssuer());
            //调用根据用户名查询用户数据方法
            ad=adminService.getAdmin(claims.getIssuer());
            //密码隐藏
            ad.setPwd("*****");
            System.err.println(ad);
        }
        return new ResponseEntity<>(ad,HttpStatus.OK);
    }

}
