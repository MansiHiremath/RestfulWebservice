package com.zensar.webservice.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload")
public class uploadService {
	@POST
	@Produces
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	
public Response uploadFile(@FormDataParam("myFile")InputStream inputStream,@FormDataParam("myFile")FormDataContentDisposition fileDetails)
{
	
	
	String fileLocation="D:\\uploads"+fileDetails.getFileName();
	try {
		FileOutputStream fos=new FileOutputStream(new File(fileLocation));
		byte[] b=new byte[1024];
		int data=0;
		while((data=inputStream.read(b))!=-1) {
			fos.write(b,0,data);
		
		}
		fos.flush();
		fos.close();
		inputStream.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Response.status(200).entity("File uploaded to location"+fileLocation).build();
}
}
