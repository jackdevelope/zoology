package mapper;

import domain.Promotion_space;

import java.util.List;

public interface PromotionSpaceMapper {
    //查询所有广告位
    public List<Promotion_space> selPromotion_space(Promotion_space promotion_space);
    //根据广告位id查询广告位信息
    public Promotion_space selPromotionSpaceByPromotionSpaceId(int promotion_space_id);
    //新增有广告位
    public int addPromotion_space(Promotion_space promotion_space);
    //修改广告位
    public int editPromotion_space(Promotion_space promotion_space);
    //删除广告位
    public int delPromotion_space(Promotion_space promotion_space);
}
