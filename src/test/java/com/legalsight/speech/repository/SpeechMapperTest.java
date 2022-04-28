package com.legalsight.speech.repository;

import javax.transaction.Transactional;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.CollectionUtils;

import com.legalsight.speech.SpeechApplication;
import com.legalsight.speech.dto.SearchSpeechRequestDto;
import com.legalsight.speech.dto.SpeechResponseItemDto;

/**
 * @author kristian.j.s.siador
 */
@SpringBootTest(classes = SpeechApplication.class)
@Sql("classpath:sql/test_data.sql")
@Transactional
public class SpeechMapperTest {
	
    @Autowired
    private SpeechMapper mapper;

    @Test
    @DisplayName("repository is injected")
    void repositoryInjected() {
        assertNotNull(mapper);
    }

    @Test
    void test_viewAll() {

        final List<SpeechResponseItemDto> actual = mapper.viewAll();

        assertFalse(CollectionUtils.isEmpty(actual));
    }
    
    @Test
    void test_searchByContent() {
    	
    	SearchSpeechRequestDto request = SearchSpeechRequestDto.builder().speechContent("Docker").build();

    	final List<SpeechResponseItemDto> actual = mapper.search(request);

        assertFalse(CollectionUtils.isEmpty(actual));
    }
    
    @Test
    void test_searchByContentButNoData() {
    	
    	SearchSpeechRequestDto request = SearchSpeechRequestDto.builder().speechContent("DockerX").build();

    	final List<SpeechResponseItemDto> actual = mapper.search(request);

        assertTrue(CollectionUtils.isEmpty(actual));
    }
    
    @Test
    void test_searchByAuthor() {
    	
    	SearchSpeechRequestDto request = SearchSpeechRequestDto.builder().author("Docker").build();

    	final List<SpeechResponseItemDto> actual = mapper.search(request);

        assertFalse(CollectionUtils.isEmpty(actual));
    }
    
    @Test
    void test_searchByAuthorButNoData() {
    	
    	SearchSpeechRequestDto request = SearchSpeechRequestDto.builder().author("DockerX").build();

    	final List<SpeechResponseItemDto> actual = mapper.search(request);

        assertTrue(CollectionUtils.isEmpty(actual));
    }
    
    @Test
    void test_searchBySubject() {
    	
    	SearchSpeechRequestDto request = SearchSpeechRequestDto.builder().subject("Docker").build();

    	final List<SpeechResponseItemDto> actual = mapper.search(request);

        assertFalse(CollectionUtils.isEmpty(actual));
    }
    
    
    @Test
    void test_searchBySubjectButNoData() {
    	
    	SearchSpeechRequestDto request = SearchSpeechRequestDto.builder().subject("DockerX").build();

    	final List<SpeechResponseItemDto> actual = mapper.search(request);

        assertTrue(CollectionUtils.isEmpty(actual));
    }
    
    @Test
    void test_searchByDate() {
    	
    	SearchSpeechRequestDto request = SearchSpeechRequestDto.builder().startDate("2022-04-27 02:00")
    			.endDate("2022-04-27 03:00").build();

    	final List<SpeechResponseItemDto> actual = mapper.search(request);

        assertFalse(CollectionUtils.isEmpty(actual));
    }
    
    @Test
    void test_searchByDateOutOfRange() {
    	
    	SearchSpeechRequestDto request = SearchSpeechRequestDto.builder().startDate("2022-04-27 12:00")
    			.endDate("2022-04-27 12:30").build();

    	final List<SpeechResponseItemDto> actual = mapper.search(request);

        assertTrue(CollectionUtils.isEmpty(actual));
    }

}
