package controller;

import domain.Promotion_space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.PromotionSpaceService;

import java.util.List;

/**
 * 广告controller层
 */
public class PromotionSpaceController {
    @Autowired
    PromotionSpaceService promotionSpaceService;
    //查询所有广告位
   @GetMapping(value = "/findPromotion_space")
    public List<Promotion_space> findPromotion_space(@RequestBody Promotion_space promotion_space) {
        return promotionSpaceService.findPromotion_space(promotion_space);
    }
    //根据广告位id查询广告位信息
    @GetMapping(value = "/findPromotion_spaceByPromotionSpaceId/{promotion_space_id}")
    public Promotion_space findPromotionSpaceByPromotionSpaceId(@RequestBody int promotion_space_id) {
        return promotionSpaceService.findPromotionSpaceByPromotionSpaceId(promotion_space_id);
    }
    //新增有广告位
    @PostMapping(value = "/savePromotion_space")
    public int savePromotion_space(@RequestBody Promotion_space promotion_space) {
        return promotionSpaceService.savePromotion_space(promotion_space);
    }
    //修改广告位
    @PutMapping(value = "/editPromotion_space")
    public int editPromotion_space(@RequestBody Promotion_space promotion_space) {
        return promotionSpaceService.editPromotion_space(promotion_space);
    }
    //删除广告位
    @DeleteMapping(value = "/removePromotion_space/{promotion_space_num}")
    public int removePromotion_space(String promotion_space_num) {
        return promotionSpaceService.removePromotion_space(promotion_space_num);
    }
}
