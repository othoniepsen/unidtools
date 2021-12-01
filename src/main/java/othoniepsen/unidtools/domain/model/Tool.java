package othoniepsen.unidtools.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Tool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String link;
	
	@Column(nullable = false)
	private String description;
	
	@ManyToMany
	@JoinTable (name = "tool_tag",joinColumns = @JoinColumn(name = "tool_id"),inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags =  new ArrayList<>();

	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Tool))
			return false;
		Tool tool = (Tool) o;
		return getId().equals(tool.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
