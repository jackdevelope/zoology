package service.impl;

import domain.Promotion_ad;
import mapper.PromotionAdviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import service.PromotionAdviceService;
/**
 * 广告Service实现层
 */
public class PromotionAdviceServiceImp implements PromotionAdviceService {
    @Autowired
    PromotionAdviceService promotionAdviceService;
    //查询广告与广告位信息
    @Override
    public Promotion_ad findPromotionAdAndSpaceInformation() {
        return promotionAdviceService.findPromotionAdAndSpaceInformation();
    }
    //根据广告id查询广告信息
    @Override
    public Promotion_ad findPromotionAdByPromotionAdIdInformation(int promotion_ad_id) {
        return promotionAdviceService.findPromotionAdByPromotionAdIdInformation(promotion_ad_id);
    }
    //增加广告信息
    @Override
    public int addPromotionAdInformation(Promotion_ad promotion_ad) {
        return promotionAdviceService.addPromotionAdInformation(promotion_ad);
    }
    //修改广告信息
    @Override
    public int editPromotionAdInformation( Promotion_ad promotion_ad) {
        return promotionAdviceService.editPromotionAdInformation(promotion_ad);
    }
    //删除广告信息
    @Override
    public int deletePromotionAdInformation(String promotion_ad_num) {
        return promotionAdviceService.deletePromotionAdInformation(promotion_ad_num);
    }
}
