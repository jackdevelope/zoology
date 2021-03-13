package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
/**
 * promotion_ad广告位实体
 * */
@Data
public class Promotion_space {
    private Integer promotion_space_id;//广告位id
    private String promotion_space_num;//广告位编号
    private String promotion_space_name;//广告位名称
    private String promotion_space_spaceKey;//广告位标识
    private Integer promotion_space_isDel;//是否删除，0未删除，1删除
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp promotion_space_createTime;//广告位创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp promotion_space_updateTime;//广告位更新时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp promotion_delete_updateTime;//广告位删除时间
    private String remark;

    @Override
    public String toString() {
        return "Promotion_space{" +
                "promotion_space_id=" + promotion_space_id +
                ", promotion_space_num='" + promotion_space_num + '\'' +
                ", promotion_space_name='" + promotion_space_name + '\'' +
                ", promotion_space_spaceKey='" + promotion_space_spaceKey + '\'' +
                ", promotion_space_createTime='" + promotion_space_createTime + '\'' +
                ", promotion_space_updateTime='" + promotion_space_updateTime + '\'' +
                ", promotion_space_isDel=" + promotion_space_isDel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
