package service;

import com.github.pagehelper.PageInfo;
import domain.Resource;
import domain.Resource_category;
import domain.Resource_categorySign;
import domain.ResourseListBillManyPager;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


public interface ResourceService {
   //多条件分页查询所有资源
    public PageInfo<Resource> findAllResourceNameAndUrlCategoryNum(ResourseListBillManyPager resourseListBillManyPager);
    //查询所有分类资源
    public List<Resource_category> findAllResourceCategory();
    //添加和修改资源分类
    public String saveOrEditResourceCategory(Resource_categorySign resource_categorySign) throws InvocationTargetException, IllegalAccessException;
    //删除资源分类
    public int removeAllResourceCategory(String resource_category_num);
}
