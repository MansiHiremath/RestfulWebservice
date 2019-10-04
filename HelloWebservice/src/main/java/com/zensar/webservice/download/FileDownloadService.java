package com.zensar.webservice.download;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class FileDownloadService {
private static final String textFile="D:\\file1.txt";
@GET
@Path("/text")
@Produces("text/plain")
public Response getTextFile() {
	File file=new File(textFile);
	ResponseBuilder builder=Response.ok(file);
	builder.header("Content-Disposition", "attachment;filename=hello_file.txt");
	return builder.build();
}
private static final String imageFile="D:\\mansi\\HTML_CSS\\images\\campus.jpg";
@GET
@Path("/image")
@Produces("image/jpg")
public Response getImageFile() {
	File file=new File(imageFile);
	ResponseBuilder builder=Response.ok(file);
	builder.header("Content-Disposition", "attachment;filename=hello_file.jpg");
	return builder.build();
}
private static final String pdfFile="C:\\Users\\Zensar123\\Downloads\\java-persistence-developer-guide.pdf";
@GET
@Path("/pdf")
@Produces("application/pdf")
public Response getpdfFile() {
	
	File file=new File(pdfFile);
	ResponseBuilder builder=Response.ok(file);
	builder.header("Content-Disposition", "attachment;filename=hello_file.pdf");
	return builder.build();
}


}
