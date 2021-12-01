package othoniepsen.unidtools.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import othoniepsen.unidtools.domain.model.Tag;
import othoniepsen.unidtools.domain.model.Tool;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
	
	Tag findByName(String name); 
	
	
}
