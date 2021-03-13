package service.impl;

import domain.Promotion_space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import service.PromotionSpaceService;

import java.util.List;
@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    @Autowired
    PromotionSpaceService promotionSpaceService;
    //查询所有广告位
    @Override
    public List<Promotion_space> findPromotion_space(@RequestBody Promotion_space promotion_space) {
        return promotionSpaceService.findPromotion_space(promotion_space);
    }
    //根据广告位id查询广告位信息
    @Override
    public Promotion_space findPromotionSpaceByPromotionSpaceId(int promotion_space_id) {
        return promotionSpaceService.findPromotionSpaceByPromotionSpaceId(promotion_space_id);
    }
    //新增有广告位
    @Override
    public int savePromotion_space(@RequestBody Promotion_space promotion_space) {
        return promotionSpaceService.savePromotion_space(promotion_space);
    }
    //修改广告位
    @Override
    public int editPromotion_space(Promotion_space promotion_space) {
        return promotionSpaceService.editPromotion_space(promotion_space);
    }
    //删除广告位
    @Override
    public int removePromotion_space(String promotion_space_num) {
        return promotionSpaceService.removePromotion_space(promotion_space_num);
    }
}
