package com.legalsight.speech.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kristian.j.s.siador
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SPEECH")
public class SpeechEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPEECH_ID", nullable = false)
    private Integer speechId;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;


}
