package edu.upc.dsa.services;


import edu.upc.dsa.MessageService;
import edu.upc.dsa.models.Badge;
import edu.upc.dsa.models.Message;
import edu.upc.dsa.models.Weapon;
import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Api(value = "/messages", description = "Endpoint to User Service")
@Path("/messages")
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages() {
        List<Message> messages = messageService.getMessages();
        GenericEntity<List<Message>> entity = new GenericEntity<List<Message>>(messages) {};
        return Response.status(200).entity(entity).build();
    }
}

