package life.silenceradio.community.mapper;

import life.silenceradio.community.dto.QuestionDTO;
import life.silenceradio.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title, description, gmt_create, gmt_modified, creator, tag) values (#{title},#{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{tag})")
    public void create(Question question);

    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(@Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select * from question where creator = #{userId} limit #{offset}, #{size}")
    List<Question> listByUserId(@Param("userId") Integer userId, @Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(id) from question")
    Integer count();

    @Select("select * from question where id = #{id}")
    Question findById(@Param("id") Integer id);

    @Select("select count(id) from question where creator = #{userId}")
    Integer countByUserId(@Param("userId") Integer userId);
}
