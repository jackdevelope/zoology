package domain;

import lombok.Data;

import java.util.Date;
/**
 * resource_category资源列表实体
 */
@Data
public class Resource_category {

    private String resource_category_num;//资源列表编号
    private String resource_category_name;//资源列表名
    private Integer resource_category_sort;//资源所属类别排序
    private Date resource_created_time;//资源类别创建时间
    private Date resource_updated_time;//资源类别修改时间
    private String resource_created_by;//资源类别创建人
    private String resource_updated_by;//资源类别修改人
    @Override
    public String toString() {
        return "ResourceCategory{" +
                "resource_category_num='" + resource_category_num + '\'' +
                ", resource_category_name='" + resource_category_name + '\'' +
                ", resource_category_sort=" + resource_category_sort +
                ", resource_created_time=" + resource_created_time +
                ", resource_updated_time=" + resource_updated_time +
                ", resource_created_by='" + resource_created_by + '\'' +
                ", resource_updated_by='" + resource_updated_by + '\'' +
                '}';
    }
}
