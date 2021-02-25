package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.ResponseResult;
import util.ResponseState;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传Controller
 */
@RestController
public class FileUploadController {
    //生成返回容器
    private static Map<String,String> result = new HashMap<>();
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        System.out.println("file:"+file);
     try {
        //1.判断文件是否为空
        if (file.isEmpty()){
            throw new RuntimeException();
        }
        //2.设定文件上传路径:D:\apache-tomcat-8.5.56\webapps\
        //获取tomact当前项目部署路径：D:\apache-tomcat-9.0.34\webapps\zoology_teaching_web_war_exploded\
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("realPath:"+realPath);
        String webappsPath = realPath.substring(0,realPath.indexOf("zoology_teaching_web_war"));
         System.out.println("webappsPath:"+webappsPath);
        //3.获取原文件名
        String fileName = file.getOriginalFilename();
        //4.获取新文件名
        String newFileName =System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
        //5.将文件上传到指定目录
        //(1)进行下载文件设置
        String uploadPath = webappsPath+"upload\\";
        //(2)生成下载文件对象
        File finallyPlace = new File(uploadPath,newFileName);
        //(3)判断下载文件是否存在,存在传输,不存在创建再传输
        if(!finallyPlace.getParentFile().exists()){
            finallyPlace.getParentFile().mkdirs();
            System.out.println("创建目录:"+finallyPlace);
        }else {
           file.transferTo(finallyPlace);
        }
        //6.将文件名和文件路径返回
        result.put("filename",newFileName);
        result.put("filePath","http://localhost:8080/upload/"+newFileName);
        ResponseResult responseResult = new ResponseResult(true, ResponseState.SUCCESS.getCode(),"文件上传成功",result);
        return responseResult;
        } catch (Exception e) {
            ResponseResult responseResult = new ResponseResult(false, ResponseState.PARAM_ERROR.getCode(),"文件上传失败",result);
            return responseResult;
        }
    }
}
