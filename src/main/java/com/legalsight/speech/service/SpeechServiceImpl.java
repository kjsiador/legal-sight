package com.legalsight.speech.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.legalsight.speech.dto.EditSpeechRequestDto;
import com.legalsight.speech.dto.RegisterSpeechRequestDto;
import com.legalsight.speech.dto.SearchSpeechRequestDto;
import com.legalsight.speech.dto.SpeechResponseDto;
import com.legalsight.speech.dto.SpeechResponseItemDto;
import com.legalsight.speech.entity.SpeechEntity;
import com.legalsight.speech.exception.SpeechException;
import com.legalsight.speech.repository.SpeechMapper;
import com.legalsight.speech.repository.SpeechRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kristian.j.s.siador
 */
@Service
@Slf4j
@Transactional
public class SpeechServiceImpl implements SpeechService{
	
	@Autowired
	SpeechRepository repository;
	
	@Autowired
	SpeechMapper mapper;
	
    private final String BAD_REQUEST = "400";

    private final String SEARCH_ERR = "Error during search";

    private final String REGISTER_ERR = "Error during register";
    
    private final String UPDATE_ERR = "Error during update";
    
    private final String DELETE_ERR = "Error during delete";

    private final String NOT_FOUND = "Data not found";

    private final String LOG_TEMPLATE = "{}::{}() - {}";
    

	@Override
	public SpeechResponseDto viewAll() throws SpeechException {
		List<SpeechResponseItemDto> responseItemList = new ArrayList<>();

		try {
			responseItemList = mapper.viewAll();

	        if (!CollectionUtils.isEmpty(responseItemList)) {
	        	return SpeechResponseDto.builder().speeches(responseItemList).build();
	        } else {
	        	throw new SpeechException(BAD_REQUEST, NOT_FOUND);
	        }
		} catch (final PersistenceException pe) {

			log.error(LOG_TEMPLATE,
					getClass().getSimpleName(),
	                Thread.currentThread().getStackTrace()[1].getMethodName(),
	                pe.getMessage());

			throw new SpeechException(BAD_REQUEST, SEARCH_ERR);
		}     
	}
	
	@Override
	public SpeechResponseItemDto register(RegisterSpeechRequestDto request) throws SpeechException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
        final SpeechEntity entity = SpeechEntity.builder()
                .content(request.getSpeechContent())
                .author(request.getAuthor())
                .subject(request.getSubject())
                .createdAt(LocalDateTime.parse(request.getCreatedAt(), formatter))
                .build();

        SpeechEntity savedEntity = new SpeechEntity();
        try {
            savedEntity = repository.save(entity);
        } catch (final DataAccessException ex) {

            log.error(LOG_TEMPLATE,
                    getClass().getSimpleName(),
                    Thread.currentThread().getStackTrace()[1].getMethodName(),
                    ex.getMessage());

            throw new SpeechException(BAD_REQUEST, REGISTER_ERR);
        }

        log.debug("Saved Entity", savedEntity);

        return SpeechResponseItemDto.builder()
        		.speechId(savedEntity.getSpeechId())
                .speechContent(savedEntity.getContent())
                .author(savedEntity.getAuthor())
                .subject(savedEntity.getSubject())
                .createdAt(formatDate(savedEntity.getCreatedAt()))
                .build();
	}
	
	@Override
	public void edit(EditSpeechRequestDto request) throws SpeechException {
		
		try {
			repository.update(request.getSpeechContent(), request.getSpeechId());
					
		} catch (final DataAccessException ex) {

            log.error(LOG_TEMPLATE,
                    getClass().getSimpleName(),
                    Thread.currentThread().getStackTrace()[1].getMethodName(),
                    ex.getMessage());

            throw new SpeechException(BAD_REQUEST, UPDATE_ERR);
        }
	}
	
	@Override
	public void delete(Integer speechId) throws SpeechException{
		
		try {
			repository.deleteById(speechId);
					
		} catch (final DataAccessException ex) {

            log.error(LOG_TEMPLATE,
                    getClass().getSimpleName(),
                    Thread.currentThread().getStackTrace()[1].getMethodName(),
                    ex.getMessage());

            throw new SpeechException(BAD_REQUEST, DELETE_ERR);
        }
	
	}
	
	@Override
	public SpeechResponseDto search(SearchSpeechRequestDto request) throws SpeechException {
		
		List<SpeechResponseItemDto> responseItemList = new ArrayList<>();

		try {
			responseItemList = mapper.search(request);

	        if (!CollectionUtils.isEmpty(responseItemList)) {
	        	return SpeechResponseDto.builder().speeches(responseItemList).build();
	        } else {
	        	throw new SpeechException(BAD_REQUEST, NOT_FOUND);
	        }
		} catch (final PersistenceException pe) {

			log.error(LOG_TEMPLATE,
					getClass().getSimpleName(),
	                Thread.currentThread().getStackTrace()[1].getMethodName(),
	                pe.getMessage());

			throw new SpeechException(BAD_REQUEST, SEARCH_ERR);
		}    
	
		
	}
    
    private String formatDate(LocalDateTime date) {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	 
    	 return date.format(formatter);
    	
    }

}
