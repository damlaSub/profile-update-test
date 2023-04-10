package co.simplon.fileapi.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.fileapi.dtos.ProfileUpdateDto;
import co.simplon.fileapi.entities.Profile;
import co.simplon.fileapi.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
    private ProfileRepository profiles;

    @Value("${profiles-api.uploads.location}")
    private String uploadDir;

    public ProfileServiceImpl(ProfileRepository profiles) {
	this.profiles = profiles;
    }

    @Override
    public void update(ProfileUpdateDto inputs, Long id) {
	Profile entity = profiles.findById(id).get();
	entity.setDescription(inputs.getDescription());
	MultipartFile file = inputs.getAvatar();
	String baseName = UUID.randomUUID().toString();
	String fileName = baseName + ".jpg";
	entity.setAvatar(fileName);
	profiles.save(entity);
	store(file, fileName);

    }

    private void store(MultipartFile file,
	    String fileName) {
	Path uploadPath = Paths.get(uploadDir);
	Path target = uploadPath.resolve(fileName);
	try (InputStream in = file.getInputStream()) {
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}
    }
}
