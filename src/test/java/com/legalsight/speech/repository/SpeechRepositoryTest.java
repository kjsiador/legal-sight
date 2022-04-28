package com.legalsight.speech.repository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.legalsight.speech.SpeechApplication;
import com.legalsight.speech.entity.SpeechEntity;

/**
 * @author kristian.j.s.siador
 */
@SpringBootTest(classes = SpeechApplication.class)
@Sql("classpath:sql/test_data.sql")
@Transactional
public class SpeechRepositoryTest {
	
    @Autowired
    private SpeechRepository repository;

    //@Test
    @DisplayName("repository is injected")
    void repositoryInjected() {
        assertNotNull(repository);
    }

    //@Test
    void test_register() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	
    	SpeechEntity entity = SpeechEntity.builder().content("This is about kubernetes")
    			.author("Kubernetes Guy").subject("Kubernetes 101").createdAt(LocalDateTime.parse("2022-04-27 02:00", formatter)).build();

        final SpeechEntity actual = repository.save(entity);
        
        assertEquals("This is about kubernetes", actual.getContent());

    }
    
    //@Test
    void test_edit() {
    	
    	Integer isUpdated = repository.update("This is an update", 1);
    	assertEquals(1, isUpdated);
    	
    }
}
