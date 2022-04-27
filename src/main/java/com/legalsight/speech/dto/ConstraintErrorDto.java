package com.legalsight.speech.dto;


import java.util.List;

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
public class ConstraintErrorDto {
	
	private String errorId;
	
	private List<String> errorMessage;

}
