package co.simplon.fileapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.fileapi.dtos.ProfileDetailView;
import co.simplon.fileapi.entities.Profile;

public interface ProfileRepository
	extends JpaRepository<Profile, Long> {

    ProfileDetailView findProjectedById(Long id);
}
