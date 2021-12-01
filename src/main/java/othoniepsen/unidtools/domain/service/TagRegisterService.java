package othoniepsen.unidtools.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import othoniepsen.unidtools.domain.model.Tag;
import othoniepsen.unidtools.domain.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagRegisterService {
	
	@Autowired
	TagRepository tagRepository;

	public Tag save(Tag tag){
		return tagRepository.save(tag);
	}
	
}
