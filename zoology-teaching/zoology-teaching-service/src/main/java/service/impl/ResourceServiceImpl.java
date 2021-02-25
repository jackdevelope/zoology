package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import domain.Resource;
import domain.Resource_category;
import domain.Resource_categorySign;
import domain.ResourseListBillManyPager;
import mapper.ResourceMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ResourceService;
import util.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
/**
 * 资源Service实现层
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    //实时时间存储器
    java.util.Date date = DateUtils.getDateFormart();

    public ResourceServiceImpl() throws ParseException {
    }

    //多条件分页查询所有资源
    @Override
    public PageInfo<Resource> findAllResourceNameAndUrlCategoryNum(ResourseListBillManyPager resourseListBillManyPager) {
        //设置分页
        PageHelper.startPage(resourseListBillManyPager.getCurrentPage(),resourseListBillManyPager.getPageSize());
        //获取结果
        List<Resource> resourceList=resourceMapper.selAllResourceByPage(resourseListBillManyPager);
        PageInfo<Resource> resourcePageInfo=new PageInfo<>(resourceList);
        return resourcePageInfo;
    }
    //查询所有分类资源
    @Override
    public List<Resource_category> findAllResourceCategory() {
        return resourceMapper.selAllResourceCategory();
    }
    //添加和修改资源分类
    @Override
    public String saveOrEditResourceCategory(Resource_categorySign resource_categorySign) throws InvocationTargetException, IllegalAccessException {
        String result="";
        Resource_category resource_category=new Resource_category();
        BeanUtils.copyProperties(resource_category,resource_categorySign);
        //封装其余信息
        resource_category.setResource_created_time(date);
        resource_category.setResource_updated_time(date);
        resource_category.setResource_created_by("system");
        resource_category.setResource_updated_by("system");
        if (resource_categorySign.getResource_category_sign().equalsIgnoreCase("add")){
            result="响应为"+resourceMapper.addAllResourceCategory(resource_category)+"新增成功";
        }else {
            result="响应为"+resourceMapper.updateAllResourceCategory(resource_category)+"修改成功";
        }
        return result;
    }
    //删除资源分类
    @Override
    public int removeAllResourceCategory(String resource_category_num) {
        return resourceMapper.deleteAllResourceCategory(resource_category_num);
    }
}
