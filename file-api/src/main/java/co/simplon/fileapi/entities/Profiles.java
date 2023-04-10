package co.simplon.fileapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Profiles {

    @Entity
    @Table(name = "profile_file")
    public class Profile {
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "description")
	private String description;

	public Profile() {

	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public String getAvatar() {
	    return avatar;
	}

	public void setAvatar(String avatar) {
	    this.avatar = avatar;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	@Override
	public String toString() {
	    return "{id=" + id + ", avatar=" + avatar
		    + ", description=" + description + "}";
	}

    }
}
