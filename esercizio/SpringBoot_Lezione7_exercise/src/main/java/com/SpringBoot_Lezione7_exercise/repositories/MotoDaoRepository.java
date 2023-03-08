package com.SpringBoot_Lezione7_exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import com.SpringBoot_Lezione7_exercise.models.Moto;

public interface MotoDaoRepository extends CrudRepository<Moto, Long> {

}
