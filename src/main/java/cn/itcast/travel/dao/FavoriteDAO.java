package cn.itcast.travel.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteDAO {
    public void add(@Param("rid") int rid,@Param("uid") int uid);
    public void remove(@Param("rid") int rid,@Param("uid") int uid);
    public List<Integer> findRidsByUid(int uid);
}
