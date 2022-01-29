package org.restapi.crud.crud.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.restapi.crud.crud.model.crudmodel;
import org.restapi.crud.crud.service.crudservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class crudresource 
{
	
	crudservice service = new crudservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addStud(crudmodel stud) 
	{
		 return service.insertStud(stud);
		
	}
	
	 @Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getStud() throws SQLException {
		 return service.getStud();
		
	}
	
    @Path("/retrieveById/{sno}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getStud(@PathParam("sno") int id) throws SQLException {
		return service.getStudById(id);
		
	}
	
	
	@Path("/update")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel updateUser(crudmodel stud) {
		 return service.updatetStud(stud);
	}
	
	@Path("/deleteById/{sno}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteStud(@PathParam("sno") int id) 
	{
		return service.deletetStud(id);
		
	}
}
