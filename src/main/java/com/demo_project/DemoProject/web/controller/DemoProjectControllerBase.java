package com.demo_project.DemoProject.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoProjectControllerBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoProjectControllerBase.class);

    protected static final String TRACKING_ID_LOG = "Tracking ID: {}; {}";
    //todo look

//    protected void sendError(HttpServletResponse response, int code, String message, String trackingId) throws IOException {
//        response.setStatus(code);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        try (PrintWriter writer = response.getWriter()) {
//            writer.println(getObjectMapper().writeValueAsString(new ExternalError(trackingId, message)));
//        }
//    }
}
