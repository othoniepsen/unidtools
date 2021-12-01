package othoniepsen.unidtools.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import othoniepsen.unidtools.domain.model.Tool;
import othoniepsen.unidtools.domain.repository.TagRepository;
import othoniepsen.unidtools.domain.repository.ToolRepository;
import othoniepsen.unidtools.domain.service.TagRegisterService;
import othoniepsen.unidtools.domain.service.ToolRegisterService;

import java.util.List;

@RestController
@RequestMapping(value = "/tags")
public class TagController {
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private TagRegisterService tagRegisterService;
	
	
	
	
	
	
	
	
	
}
