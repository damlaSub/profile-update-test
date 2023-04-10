package co.simplon.fileapi.controller;

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

    @PatchMapping("/my")
    public void update(
	    @ModelAttribute ProfileUpdateDto inputs) {
	service.update(inputs, 1L);

	System.out.println(
		inputs.getAvatar().getOriginalFilename());
	System.out.println(inputs.getAvatar().getSize());
	System.out.println(inputs.getDescription());

    }

}
