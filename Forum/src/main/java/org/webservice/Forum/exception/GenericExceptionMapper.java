package org.webservice.Forum.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.webservice.Forum.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable arg0) {
		ErrorMessage myErrorMessage = new ErrorMessage(arg0.getMessage(), 500);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(myErrorMessage)
						.build();
	}

}
