package io.mostafaeldahshan.simon_and_kucher.repos;

import io.mostafaeldahshan.simon_and_kucher.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SequenceRepository extends JpaRepository<Sequence, String> {
}
