package com.dio.live.exception;

import com.dio.live.Utils.MessageUtils;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super(MessageUtils.NO_RECORDS_FOUND);
	}
}