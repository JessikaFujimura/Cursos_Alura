package com.br.Adopet_challenge_backend.repository;

import com.br.Adopet_challenge_backend.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
