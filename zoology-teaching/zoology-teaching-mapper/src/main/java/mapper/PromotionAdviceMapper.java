package mapper;

import domain.Promotion_ad;

/**
 * 广告mapper层
 */
public interface PromotionAdviceMapper {
    //查询广告与广告位信息
    public Promotion_ad selPromotionAdAndSpace();
    //根据广告id查询广告信息
    public Promotion_ad selPromotionAdByPromotionAdId(int promotion_ad_id);
    //增加广告信息
    public int addPromotionAd(Promotion_ad promotion_ad);
    //修改广告信息
    public int editPromotionAd(Promotion_ad promotion_ad);
    //删除广告信息
    public int deletePromotionAd(String promotion_ad_num);
}
