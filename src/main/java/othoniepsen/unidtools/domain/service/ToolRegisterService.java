package othoniepsen.unidtools.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import othoniepsen.unidtools.domain.model.Tag;
import othoniepsen.unidtools.domain.model.Tool;
import othoniepsen.unidtools.domain.repository.TagRepository;
import othoniepsen.unidtools.domain.repository.ToolRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToolRegisterService {
	
	@Autowired
	private ToolRepository toolRepository;
	@Autowired
	private TagRepository tagRepository;
	
	public Tool save(Tool tool){

		List<Tag> tags = new ArrayList<>();
		
		tool.getTags().forEach(tag -> {
			Tag tagExistent = tagRepository.findByName(tag.getName());
			if(tagExistent == null){
				tag = tagRepository.save(tag);
			} else {
				tag = tagExistent;

			}
			tags.add(tag);
		});
		tool.setTags(tags);
		return toolRepository.save(tool);
	}
	
	public void delete(Long id){
			toolRepository.deleteById(id);
	}
	
	
}
