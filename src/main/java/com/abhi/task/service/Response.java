package com.abhi.task.service;



import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Response<T> {
	private T object;
    private Status status;
	
    public Response(T object, Status status) {
		super();
		this.object = object;
		this.status = status;
	}
    public enum Status{
    	CREATED,
        NOT_CREATED,
        RECEIVED,
        NOT_RECEIVED
    }
}

