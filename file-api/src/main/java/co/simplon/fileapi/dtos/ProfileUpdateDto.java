package co.simplon.fileapi.dtos;

import org.springframework.web.multipart.MultipartFile;

public class ProfileUpdateDto {

    private Long id;

    private MultipartFile file;

    private String description;

    public ProfileUpdateDto() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public MultipartFile getAvatar() {
	return file;
    }

    public void setAvatar(MultipartFile avatar) {
	this.file = avatar;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", file=" + file
		+ ", description=" + description + "}";
    }

}
