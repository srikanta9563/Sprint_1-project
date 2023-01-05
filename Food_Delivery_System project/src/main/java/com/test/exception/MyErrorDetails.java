package com.test.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MyErrorDetails {

	private LocalDateTime timestamp;
	private String message;
	private String description;

	
}
