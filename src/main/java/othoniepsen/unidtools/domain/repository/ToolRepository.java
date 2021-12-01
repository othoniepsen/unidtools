package othoniepsen.unidtools.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import othoniepsen.unidtools.domain.model.Tag;
import othoniepsen.unidtools.domain.model.Tool;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
	
	List<Tool> findAllByTagsIn(List<Tag> tags);
	
	
}
