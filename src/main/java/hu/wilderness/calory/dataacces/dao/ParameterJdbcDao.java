package hu.wilderness.calory.dataacces.dao;

import hu.wilderness.calory.dataacces.dao.parents.BaseJdbcDao;
import hu.wilderness.calory.dataacces.mapper.ParameterMapper;
import hu.wilderness.calory.domain.Parameter;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParameterJdbcDao extends BaseJdbcDao {

    @Override
    public String getTableName() {
        return "parameter";
    }

    public List<Parameter> findAll() {
        String sql = "select * from "+getTableName();
        List<Parameter> result = jdbcTemplate.query(sql, new ParameterMapper());
        return result;
    }

    public Parameter findByKeyAndActive(String key) {
        String sql = "select * from " + getTableName() + " p where p.value_key = ? and active";
        Object[] params = {key};
        try {
            Parameter p = jdbcTemplate.queryForObject(sql, params, new ParameterMapper());
            return p;
        } catch (DataAccessException e) {
            return null;
        }
    }

    public Parameter insert(Parameter p) {

        Map<String, Object> parameters = new HashMap();
        parameters.put("value_key", p.getKey());
        parameters.put("value", p.getValue());
        parameters.put("description", p.getDescription());
        parameters.put("active", p.getActive());

        Number result = insert.executeAndReturnKey(parameters);

        p.setId(result.intValue());

        return p;
    }

    public Parameter update(Parameter p) {
        if (p.getId() == null)
            return null;
        String sql = "update " + getTableName() + " set " +
                "     value_key=?, " +
                "     value_data=?, " +
                "     description=?, " +
                "     active=? " +
                "where " +
                "     id=? ";
        Object[] parameters = {
                p.getKey(),
                p.getValue(),
                p.getDescription(),
                p.getActive(),
                p.getId()
        };
        int result = jdbcTemplate.update(sql, parameters);
        return p;
    }


}