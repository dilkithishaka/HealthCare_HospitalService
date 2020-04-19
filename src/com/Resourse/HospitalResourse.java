package com.Resourse;

import java.util.List;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.Model.Hospital;
import com.Repository.HospitalRepository;


@Path("Hospital")
public class HospitalResourse {
	HospitalRepository hs = new HospitalRepository();
			
			@GET
			@Produces(MediaType.APPLICATION_XML)
			public List<Hospital> viewHospitals(){
				return hs.viewHospitals();
			}
			
			@GET
			@Produces(MediaType.APPLICATION_XML)
			public List <Hospital> viewDoctors(){
				return hs.viewDoctors();
			}
			
			@GET
			@Produces(MediaType.APPLICATION_XML)
			public List <Hospital> viewPayments(){
				return hs.viewPayments();
			}
			
			@GET
			@Path("search/{hospitalID}")
			@Produces(MediaType.APPLICATION_XML)
			public Hospital searchHospital(@PathParam("hospitalID")int hospitalID) {
				System.out.println("View...");
				return hs.searchHospital(hospitalID);
			}
			
			@POST
			@Path("create")
			public Hospital addHospital(Hospital h){
				hs.create(h);
				return h;
			}
			

			@PUT
			@Path("update")
			public Hospital updateHospital(Hospital h){
				System.out.println(h);
				if(hs.searchHospital(h.getHospitalID()).getHospitalID() == 0) {
						System.out.println("Invalid Hospital");
				}
				else {
					hs.update(h);
				}
				return h;
			}
			
			@DELETE
			@Path("delete/{hospitalID}")
			public Hospital deleteHospital(@PathParam("hospitalID") int hospitalID){
				Hospital h = hs.searchHospital(hospitalID);
				
				if(h.getHospitalID()!= 0) {
						hs.delete(hospitalID);
				}
				return h;
			}
			
			
			
			
			
			
			
			
			
			
			
}
