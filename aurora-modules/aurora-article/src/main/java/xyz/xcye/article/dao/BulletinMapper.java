package xyz.xcye.article.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.xcye.article.po.Bulletin;
import xyz.xcye.data.entity.Condition;

import java.util.List;

@Mapper
public interface BulletinMapper {
    /**
     * delete by primary key
     * @param uid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long uid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Bulletin record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Bulletin record);

    /**
     * select by primary key
     * @param condition 查询条件,其中keyword->content(like模糊查询),show->is_show, status->is_timing
     * @return object by primary key
     */
    List<Bulletin> selectByCondition(@Param("condition") Condition condition);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Bulletin record);

    int updateByPrimaryKeyWithBLOBs(Bulletin record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Bulletin record);
}