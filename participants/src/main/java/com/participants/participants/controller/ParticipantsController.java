package com.participants.participants.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.participants.participants.entity.ParticipantsEntity;
import com.participants.participants.modle.Participants;
import com.participants.participants.repository.ParticipantsRepository;
import java.util.Optional;

@RestController
@RequestMapping("/testParticipants")
public class ParticipantsController {
	
	@Autowired
	private ParticipantsRepository participantsrepo;
	
	@PostMapping("/saveparticipants")
	public String saveparticipants(@RequestBody Participants participants)
	{
		ParticipantsEntity entity=new ParticipantsEntity();
		entity.setName(participants.getName());
		entity.setEmail(participants.getEmail());
		participantsrepo.save(entity);
		return "saved";	
	}
	@GetMapping("/getparticipants")
	public List<Participants> getparticaipants()
	{
		List<Participants>lt=new ArrayList<>();
		participantsrepo.findAll().forEach(p->{
			Participants participants =new Participants();
			participants.setId(p.getId());
			participants.setName(p.getName());
			participants.setEmail(p.getEmail());
			lt.add(participants);
		});
		return lt;
	}
	@GetMapping("/getparticipantsEmail")
	public List<String>getEmail()
	{
		List<String>lt=new ArrayList<>();
		participantsrepo.findAll().forEach(p->{
			String email=p.getEmail();
			lt.add(email);
		});
		return lt;
	}
	@GetMapping("/getparticipantsById/{id}")
	public Participants getparticaipantsbyid(@PathVariable long id)
	{
		Optional<ParticipantsEntity>entity=participantsrepo.findById(id);
		Participants object=new Participants();
		object.setId(entity.get().getId());
		object.setName(entity.get().getName());
		object.setEmail(entity.get().getEmail());
		return object;
	}
	
}
