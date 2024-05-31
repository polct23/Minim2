package edu.upc.dsa.services;

import edu.upc.dsa.WeaponList;
import edu.upc.dsa.WeaponListImpl;
import edu.upc.dsa.models.Weapon;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Api(value = "/weapons", description = "Endpoint to Weapon Service")
@Path("/weapons")
public class WeaponsService {
    private final WeaponList wl;

    public WeaponsService() {
        this.wl = WeaponListImpl.getInstance();
    }

    @GET
    @ApiOperation(value = "get all Weapons", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Weapon.class, responseContainer = "List")
    })
    @Path("/getWeapons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeapons() {
        List<Weapon> weapons = wl.getWeapons();
        GenericEntity<List<Weapon>> entity = new GenericEntity<List<Weapon>>(weapons) {};
        return Response.status(200).entity(entity).build();
    }

    @POST
    @ApiOperation(value = "create a new Weapon", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Weapon.class),
            @ApiResponse(code = 500, message = "Validation error")
    })
    @Path("/newWeapon")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newWeapon(Weapon weapon) {
        Weapon newWeapon = new Weapon(weapon.getIdWeapon(), weapon.getWeaponName(), weapon.getDescription(),
                weapon.getDamage(),weapon.getPrice());
        if(newWeapon.getIdWeapon()==null || newWeapon.getWeaponName()==null) return Response.status(500).entity(newWeapon).build();
        this.wl.addWeapon(newWeapon);
        return Response.status(201).entity(newWeapon).build();
    }
}
