package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouteDao {

    /**
     * 根据cid查询总记录数
     */
    public int findTotalCount(int cid);

    /**
     * 根据cid，start,pageSize查询当前页的数据集合
     */
    public List<Route> findByPage(int cid, int start, int pageSize);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(int rid);
}
