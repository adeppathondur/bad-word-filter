package com.target.objectionable.services;
 
/**
* @author Arpit Mandliya
*/
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("ConversionService")
public class ObjectionableServices {
	
	 @GET
     @Path("/InchToFeet/{userInput}")
      @Produces(MediaType.APPLICATION_JSON)
      public Response identifyObjectionableContent(@PathParam("userInput") String input) {
		 
		 BadWordsFilter badWordsFilterHash = new BadWordsFilter();
		badWordsFilterHash.start("/Users/adeppathondur/Downloads/RESTfulWebServiceExample-master/RESTfulWebServiceExample/src/bad_words.txt");
		
		StringBuffer response = new StringBuffer("");
		String[] inputSplit = input.split("\\s");
		
		
		for (int i=0; i < inputSplit.length; i++){
			response.append(badWordsFilterHash.filterBadWords(inputSplit[i]));
		    }
				
		
        return Response.status(200).entity(response.toString()).build();
      }
      
      
}