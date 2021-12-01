package othoniepsen.unidtools.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import othoniepsen.unidtools.domain.model.Tag;
import othoniepsen.unidtools.domain.model.Tool;
import othoniepsen.unidtools.domain.repository.TagRepository;
import othoniepsen.unidtools.domain.repository.ToolRepository;
import othoniepsen.unidtools.domain.service.ToolRegisterService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tools")
public class ToolController {
	
	@Autowired
	private ToolRepository toolRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private ToolRegisterService toolRegisterService;
	
	@ResponseStatus
	@GetMapping
	public ResponseEntity<?> list(String tag){
		List<Tool> tools;
		if(tag!=null){
			List<Tag> tags = new ArrayList<>();
			tags.add(tagRepository.findByName(tag));
			tools = toolRepository.findAllByTagsIn(tags);
		}else{
			tools = toolRepository.findAll();
		}
		if(tools != null) {
			return ResponseEntity.ok(tools);
		}else{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Tool tool){
		try{
			Tool createdTool = toolRegisterService.save(tool);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdTool);

		}catch (Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try{
			Optional<Tool> tool = toolRepository.findById(id);

			if(tool.isPresent()){
				toolRegisterService.delete(id);
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
}
