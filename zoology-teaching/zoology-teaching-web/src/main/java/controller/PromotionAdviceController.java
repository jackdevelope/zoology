package controller;

import domain.Promotion_ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.PromotionAdviceService;

/**
 * 广告位controller层
 */
public class PromotionAdviceController {
    @Autowired
    PromotionAdviceService promotionAdviceService;
    //查询广告与广告位信息
    @GetMapping(value = "/findPromotionAdAndSpace")
    public Promotion_ad findPromotionAdAndSpaceInformation() {
        return promotionAdviceService.findPromotionAdAndSpaceInformation();
    }
    //根据广告id查询广告信息
    @GetMapping(value = "/findPromotionAdByPromotionAdId")
    public Promotion_ad findPromotionAdByPromotionAdIdInformation(int promotion_ad_id) {
        return promotionAdviceService.findPromotionAdByPromotionAdIdInformation(promotion_ad_id);
    }
    //增加广告信息
    @PostMapping(value = "/addPromotionAd")
    public int addPromotionAdInformation(@RequestBody Promotion_ad promotion_ad) {
        return promotionAdviceService.addPromotionAdInformation(promotion_ad);
    }
    //修改广告信息
    @PutMapping(value = "/editPromotionAd")
    public int editPromotionAdInformation(@RequestBody Promotion_ad promotion_ad) {
        return promotionAdviceService.editPromotionAdInformation(promotion_ad);
    }
    //删除广告信息
    @DeleteMapping(value = "/deletePromotionAd")
    public int deletePromotionAdInformation(String promotion_ad_num) {
        return promotionAdviceService.deletePromotionAdInformation(promotion_ad_num);
    }
}
