package com.SpringBoot_Lezione7_exercise.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot_Lezione7_exercise.models.Moto;

public interface MotoPageRepository extends PagingAndSortingRepository<Moto, Long> {

}
