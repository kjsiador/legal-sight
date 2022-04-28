package com.legalsight.speech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import com.legalsight.speech.SpeechApplication;
import com.legalsight.speech.dto.SpeechResponseDto;
import com.legalsight.speech.dto.SpeechResponseItemDto;
import com.legalsight.speech.exception.SpeechException;
import com.legalsight.speech.repository.SpeechMapper;
import com.legalsight.speech.repository.SpeechRepository;
import com.legalsight.speech.utils.TestMethodSource;

/**
 * @author kristian.j.s.siador
 */
@SpringBootTest(classes = SpeechApplication.class)
public class SpeechServiceTest {
	
    @InjectMocks
    private SpeechServiceImpl service;

    @Mock
    private SpeechRepository repository;
    
    @Mock
    private SpeechMapper mapper;
    
    //@Test
    void whenViewAllSuccess() throws SpeechException {

        when(mapper.viewAll()).thenReturn(TestMethodSource.getResponseList());

        final SpeechResponseDto response = service.viewAll();

        assertEquals(1, response.getSpeeches().size());

        verify(mapper, times(1)).viewAll();

    }
    
    //@Test
    void whenViewAll_butEmpty() throws SpeechException {

        when(mapper.viewAll()).thenReturn(Collections.emptyList());

        SpeechException exception = assertThrows(SpeechException.class, () -> {
            service.viewAll();
        });
        
        assertEquals(TestMethodSource.NOT_FOUND, exception.getErrMessage());

    }
    
    //@Test
    void whenViewAll_butError() throws SpeechException {

        when(mapper.viewAll()).thenThrow(PersistenceException.class);

        SpeechException exception = assertThrows(SpeechException.class, () -> {
            service.viewAll();
        });
        
        assertEquals(TestMethodSource.SEARCH_ERR, exception.getErrMessage());

    }
    
    //@Test
    void whenRegisterSucess() throws SpeechException {

        when(repository.save(any())).thenReturn(TestMethodSource.getSpeechEntity());

        final SpeechResponseItemDto response = service.register(TestMethodSource.getRegistDto());

        assertNotNull(response);

        verify(repository, times(1)).save(any());
    }
    
    //@Test
    void whenRegister_butError() throws SpeechException {

        when(repository.save(any())).thenThrow(new DataAccessException("") {

            private static final long serialVersionUID = 4689585630069714995L;

        });

        SpeechException exception = assertThrows(SpeechException.class, () -> {
            service.register(TestMethodSource.getRegistDto());
        });
        
        assertEquals(TestMethodSource.REGISTER_ERR, exception.getErrMessage());

    }
    
    //@Test
    void whenUpdateSucess() throws SpeechException {

        when(repository.update(any(), any())).thenReturn(1);

        service.edit(TestMethodSource.getEditDto());

        verify(repository, times(1)).update(any(), any());
    }
    
    //@Test
    void whenUpdate_butError() throws SpeechException {

        when(repository.update(any(), any())).thenThrow(new DataAccessException("") {

            private static final long serialVersionUID = 4689585630069714995L;

        });

        SpeechException exception = assertThrows(SpeechException.class, () -> {
            service.edit(TestMethodSource.getEditDto());
        });
        
        assertEquals(TestMethodSource.UPDATE_ERR, exception.getErrMessage());

    }
    
    //@Test
    void whenDeleteSuccess() throws SpeechException {

        doNothing().when(repository).deleteById(any());

        service.delete(1);

        verify(repository, times(1)).deleteById(any());
    }
    
    //@Test
    void whenDelete_butError() throws SpeechException {
    	
    	doThrow(new DataAccessException("") {

            private static final long serialVersionUID = 4689585630069714995L;

        }).when(repository).deleteById(any());

        SpeechException exception = assertThrows(SpeechException.class, () -> {
            service.delete(1);
        });
        
        assertEquals(TestMethodSource.DELETE_ERR, exception.getErrMessage());

    }
    
    //@Test
    void whenSearchSuccess() throws SpeechException {

        when(mapper.search(any())).thenReturn(TestMethodSource.getResponseList());

        final SpeechResponseDto response = service.search(TestMethodSource.getSearchDto());

        assertEquals(1, response.getSpeeches().size());

        verify(mapper, times(1)).search(any());

    }
    
    //@Test
    void whenSearch_butEmpty() throws SpeechException {

        when(mapper.search(any())).thenReturn(Collections.emptyList());

        SpeechException exception = assertThrows(SpeechException.class, () -> {
            service.search(TestMethodSource.getSearchDto());
        });
        
        assertEquals(TestMethodSource.NOT_FOUND, exception.getErrMessage());

    }
    
    //@Test
    void whenSearch_butError() throws SpeechException {

        when(mapper.search(any())).thenThrow(PersistenceException.class);

        SpeechException exception = assertThrows(SpeechException.class, () -> {
            service.search(any());
        });
        
        assertEquals(TestMethodSource.SEARCH_ERR, exception.getErrMessage());

    }


}
