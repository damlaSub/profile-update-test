package co.simplon.fileapi.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.fileapi.dtos.ProfileUpdateDto;
import co.simplon.fileapi.services.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private ProfileService service;

    public ProfileController(ProfileService service) {

	this.service = service;
    }

    @PatchMapping("/1")
    public void update(
	    @ModelAttribute ProfileUpdateDto inputs) {
	service.update(inputs, 1L);

    }

}
