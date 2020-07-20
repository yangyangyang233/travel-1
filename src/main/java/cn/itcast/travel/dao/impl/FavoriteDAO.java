package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.Collect;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FavoriteDAO {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public void add(int rid, int uid) {
        String sql = "insert into tab_favorite values(?, ?, ?)";
        template.update(sql, rid, new Date(), uid);
    }
    public void remove(int rid,int uid){
        String sql="delete from tab_favorite where rid=? and uid=?";
        template.update(sql,rid,uid);
    }

    public List<Integer> findRidsByUid(int uid){
        String sql="select * from tab_favorite where uid=?";
        List<Collect> favorites = template.query(sql,new BeanPropertyRowMapper<Collect>(Collect.class),uid);
        List<Integer> rids = new ArrayList<Integer>();

        for(Collect favorite:favorites){
            rids.add(favorite.getRid());
        }
        return rids;
    }

}
