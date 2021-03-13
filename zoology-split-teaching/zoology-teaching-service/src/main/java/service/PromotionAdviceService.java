package service;

import domain.Promotion_ad;
/**
 * 广告Service层
 */
public interface PromotionAdviceService {
    //查询广告与广告位信息
    public Promotion_ad findPromotionAdAndSpaceInformation();
    //根据广告id查询广告信息
    public Promotion_ad findPromotionAdByPromotionAdIdInformation(int promotion_ad_id);
    //增加广告信息
    public int addPromotionAdInformation(Promotion_ad promotion_ad);
    //修改广告信息
    public int editPromotionAdInformation(Promotion_ad promotion_ad);
    //删除广告信息
    public int deletePromotionAdInformation(String promotion_ad_num);
}
