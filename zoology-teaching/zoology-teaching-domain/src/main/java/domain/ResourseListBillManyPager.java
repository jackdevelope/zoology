package domain;

import lombok.Data;

/**
 *user用户分页信息接收工具Bean
 */
@Data
public class ResourseListBillManyPager {

    private Integer currentPage;//当前页
    private Integer pageSize;//总页数
    private String resource_name;//资源名
    private String resource_url;//资源URL
    private String resource_category_num;//资源类别编号

    @Override
    public String toString() {
        return "ResourseListBillManyPager{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", resource_name='" + resource_name + '\'' +
                ", resource_url='" + resource_url + '\'' +
                ", resource_category_num='" + resource_category_num + '\'' +
                '}';
    }
}
