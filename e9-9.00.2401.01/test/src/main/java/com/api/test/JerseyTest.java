package com.api.test;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.*;

@Path("/workflow/v1")
public class JerseyTest {

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        return JSON.toJSONString("success！！！");
    }

    @GET
    @Path("/downloadFile")
    public void downloadFile(@Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException {
//        String fileName = request.getParameter("fileName");

        File file = new File("\\home\\WEAVER\\ecology-9\\Ecology_setup_forLinux_v2.66_forPythony3_ubuntuAndRedHat.py");

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + "fileNametest" + "\"");
        response.setContentLength((int) file.length());

        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        fileInputStream.close();
        outputStream.close();
    }

}
