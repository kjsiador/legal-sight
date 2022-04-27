package com.legalsight.speech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.legalsight.speech.entity.SpeechEntity;

/**
 * @author kristian.j.s.siador
 */

@Repository
public interface SpeechRepository extends JpaRepository<SpeechEntity, Integer>{
	
	@Modifying
	@Query(value = "UPDATE SPEECH SET CONTENT = :content WHERE SPEECH_ID = :id", nativeQuery = true)
	Integer update(@Param("content") String content, @Param("id") Integer speechId);
	

}
