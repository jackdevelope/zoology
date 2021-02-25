package domain;

import lombok.Data;
/**
 * promotion_ad广告实体
 * */
@Data
public class Promotion_ad {
    private Integer promotion_ad_id;//广告id
    private String promotion_ad_num;//广告编号
    private String  promotion_ad_name;//广告名称
    private Integer promotion_ad_keyword;//广告关键字
    private String promotion_ad_htmlContent;//广告文本内容
    private String promotion_ad_img;//图片链接
    private String promotion_ad_link;//跳转地址
    private java.sql.Timestamp promotion_ad_creatTime;//广告创建时间
    private java.sql.Timestamp promotion_ad_updateTime;//广告最后更新时间
    private java.sql.Timestamp promotion_ad_startTime;//广告开始时间
    private java.sql.Timestamp promotion_ad_endTime;//广告结束时间
    private Integer promotion_ad_is_del;//是否删除，0未删除，1删除
    private Integer promotion_ad_status;//广告状态:1.上架2.下架
    private Integer promotion_ad_priority;//广告优先级
    private String remark;//备注
    private Integer promotion_space_id;//广告位id
    private String promotion_space_num;//广告位编号
    private String promotion_space_name;//广告位名
    private Promotion_space promotion_space;//广告位集合
    @Override
    public String toString() {
        return "Promotion_ad{" +
                "promotion_ad_id=" + promotion_ad_id +
                ", promotion_ad_num='" + promotion_ad_num + '\'' +
                ", promotion_ad_name='" + promotion_ad_name + '\'' +
                ", promotion_ad_keyword=" + promotion_ad_keyword +
                ", promotion_ad_htmlContent='" + promotion_ad_htmlContent + '\'' +
                ", promotion_ad_img='" + promotion_ad_img + '\'' +
                ", promotion_ad_link='" + promotion_ad_link + '\'' +
                ", promotion_ad_creatTime=" + promotion_ad_creatTime +
                ", promotion_ad_updateTime=" + promotion_ad_updateTime +
                ", promotion_ad_startTime=" + promotion_ad_startTime +
                ", promotion_ad_endTime=" + promotion_ad_endTime +
                ", promotion_ad_is_del=" + promotion_ad_is_del +
                ", promotion_ad_status=" + promotion_ad_status +
                ", promotion_ad_priority=" + promotion_ad_priority +
                ", remark='" + remark + '\'' +
                ", promotion_space_id=" + promotion_space_id +
                ", promotion_space_num='" + promotion_space_num + '\'' +
                ", promotion_space_name='" + promotion_space_name + '\'' +
                ", promotion_space=" + promotion_space +
                '}';
    }
}
