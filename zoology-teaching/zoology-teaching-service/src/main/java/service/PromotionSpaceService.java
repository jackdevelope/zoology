package service;

import domain.Promotion_space;

import java.util.List;

public interface PromotionSpaceService {
    //查询所有广告位
    public List<Promotion_space> findPromotion_space(Promotion_space promotion_space);
    //根据广告位id查询广告位信息
    public Promotion_space findPromotionSpaceByPromotionSpaceId(int promotion_space_id);
    //新增有广告位
    public int savePromotion_space(Promotion_space promotion_space);
    //修改广告位
    public int editPromotion_space(Promotion_space promotion_space);
    //删除广告位
    public int removePromotion_space(String promotion_space_num);
}
