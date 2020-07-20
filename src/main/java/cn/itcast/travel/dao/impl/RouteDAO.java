package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;


public class RouteDAO {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
//        String sql = "select * from tab_route where cid = ? limit ?, ?";
        String sql = "select * from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }
        sb.append(" limit ?, ?");
        sql = sb.toString();

        params.add(start);
        params.add(pageSize);

        return template.query(sql,
                new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    public int findTotalCount(int cid) {
        String sql = "select count(*) from tab_route where cid = ?";
        return template.queryForObject(sql,Integer.class,cid);
    }


    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql,
                new BeanPropertyRowMapper<Route>(Route.class), rid);
    }

}
