package spring.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "optionsDataMapper")
public interface OptionsDataMapper {
	void insertProList(@Param("o_reStep") int o_reStep,
			@Param("proList") List<OrderProducts> proList);
}
