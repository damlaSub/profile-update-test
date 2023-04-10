package co.simplon.fileapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile_file")
public class Profile {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "file")
    private String file;

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

    public String getFile() {
	return file;
    }

    public void setFile(String file) {
	this.file = file;
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
		+ ", file=" + file + ", description="
		+ description + "}";
    }

}
