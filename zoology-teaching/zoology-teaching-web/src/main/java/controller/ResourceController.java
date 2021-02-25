package controller;

import com.github.pagehelper.PageInfo;
import domain.Resource;
import domain.Resource_category;
import domain.Resource_categorySign;
import domain.ResourseListBillManyPager;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.ResourceService;
import util.ResponseResult;
import util.ResponseState;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 资源Controller层
 */
@RestController
public class ResourceController {
    //view结果返回器
    private static ResponseResult responseResult =new ResponseResult();
    //状态结果返回器res
    private static int res=0;
    @Autowired
    private ResourceService resourceService;
    //多条件分页查询所有资源信息
    @GetMapping(value = "/findAllResourceNameAndUrlCategoryNum")
    public ResponseResult findAllResourceNameAndUrlCategoryNumInformation(@RequestBody ResourseListBillManyPager resourseListBillManyPager){
        PageInfo<Resource> resourceList=resourceService.findAllResourceNameAndUrlCategoryNum(resourseListBillManyPager);
       if (resourceList.getSize()>0){
           responseResult.setRes(true);
           responseResult.setState(ResponseState.SUCCESS.getCode());
           responseResult.setMessage(ResponseState.SUCCESS.getMessage());
           responseResult.setContent(resourceList);
       }else {
           responseResult.setRes(false);
           responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
           responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
           responseResult.setContent(resourceList);

       }
       return responseResult;
    }
    //查询所有分类资源信息
    @GetMapping(value = "/findAllResourceCategory")
    public ResponseResult findAllResourceCategoryInformation(){
        List<Resource_category> resource_categories=resourceService.findAllResourceCategory();
        if (resource_categories.size()>0){
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage(ResponseState.SUCCESS.getMessage());
            responseResult.setContent(resource_categories);
        }else {
            responseResult.setRes(false);
            responseResult.setState(ResponseState.DATABASE_ERROR.getCode());
            responseResult.setMessage(ResponseState.DATABASE_ERROR.getMessage());
            responseResult.setContent(resource_categories);

        }
        return responseResult;
    }
    //添加和修改资源分类信息
    @PostMapping(value = "/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategoryInformation(@RequestBody Resource_categorySign resource_categorySign){
        try {
            String temp=resourceService.saveOrEditResourceCategory(resource_categorySign);
            responseResult.setRes(true);
            responseResult.setState(ResponseState.SUCCESS.getCode());
            responseResult.setMessage(ResponseState.SUCCESS.getMessage());
            responseResult.setContent(temp);
            return responseResult;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setContent("方法内部错误");
            return responseResult;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            responseResult.setRes(false);
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setState(ResponseState.UNKNOWN_ERROR.getCode());
            responseResult.setContent("方法内部错误");
            return responseResult;
        }
    }
    //删除资源分类信息
    @DeleteMapping(value = "/removeAllResourceCategory/{resource_category_num}")
    public ResponseResult removeAllResourceCategoryInformation(@PathVariable String resource_category_num){
        int temp=resourceService.removeAllResourceCategory(resource_category_num);
        responseResult.setRes(true);
        responseResult.setState(ResponseState.SUCCESS.getCode());
        responseResult.setMessage(ResponseState.SUCCESS.getMessage());
        responseResult.setContent(temp);
        return responseResult;
    }
}
