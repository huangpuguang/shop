package ${package_mapper};
import ${package_pojo}.${Table};
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: ${Table}的Dao
 *****/
@Repository
public interface ${Table}Mapper extends Mapper<${Table}> {
}
