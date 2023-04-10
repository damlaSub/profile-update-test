package co.simplon.fileapi.services;

import co.simplon.fileapi.dtos.ProfileUpdateDto;

public interface ProfileService {

    void update(ProfileUpdateDto inputs, Long id);

}
