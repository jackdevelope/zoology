package mapper;

import domain.Resource;
import domain.Resource_category;
import domain.ResourseListBillManyPager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 资源mapper层
 */
public interface ResourceMapper {
    //多条件模糊查询所有资源
    public List<Resource> selAllResourceByPage(ResourseListBillManyPager resourseListBillManyPager);
    //查询所有资源分类
    public List<Resource_category> selAllResourceCategory();
    //增加资源
    public int addAllResourceCategory(Resource_category resource_category);
    //修改资源
    public int updateAllResourceCategory(Resource_category resource_category);
    //删除资源
    public int deleteAllResourceCategory(String resource_category_num);
}
