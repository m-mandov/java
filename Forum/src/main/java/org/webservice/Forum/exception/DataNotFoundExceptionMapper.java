package org.webservice.Forum.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.webservice.Forum.model.ErrorMessage;

@Produces(MediaType.APPLICATION_JSON)
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException arg0) {
		System.out.println("DataNotFoundExceptionMapper executed!");
		ErrorMessage myErrorMessage = new ErrorMessage(arg0.getMessage(), 404);
		return Response.status(Status.NOT_FOUND)
						.entity(myErrorMessage)
						.build();
	}

}
