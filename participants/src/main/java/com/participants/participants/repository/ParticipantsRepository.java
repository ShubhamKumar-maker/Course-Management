package com.participants.participants.repository;

import org.springframework.data.repository.CrudRepository;
import com.participants.participants.entity.ParticipantsEntity;

public interface ParticipantsRepository extends CrudRepository<ParticipantsEntity, Long> {

}
