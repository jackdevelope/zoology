package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * resource资源实体
 */
@Data
public class Resource {
    private Integer resource_id;//资源id
    private String resource_name;//资源名称
    private String resource_url;//资源URL
    private String resource_category_num;//资源分类编号
    private String resource_category_name;//资源分类名
    private String resource_description;//资源描述
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date resource_created_time;//资源创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date resource_updated_time;//资源修改时间
    private String resource_created_by;//资源创建人
    private String resource_updated_by;//资源修改人
    @Override
    public String toString() {
        return "Resource{" +
                "resource_id=" + resource_id +
                ", resource_name='" + resource_name + '\'' +
                ", resource_url='" + resource_url + '\'' +
                ", resource_category_num='" + resource_category_num + '\'' +
                ", resource_category_name='" + resource_category_name + '\'' +
                ", resource_description='" + resource_description + '\'' +
                ", resource_created_time=" + resource_created_time +
                ", resource_updated_time=" + resource_updated_time +
                ", resource_created_by='" + resource_created_by + '\'' +
                ", resource_updated_by='" + resource_updated_by + '\'' +
                '}';
    }
}
