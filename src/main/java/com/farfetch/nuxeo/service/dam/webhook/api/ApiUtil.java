package com.farfetch.nuxeo.service.dam.webhook.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class ApiUtil {

    public static final Logger log = LoggerFactory.getLogger(ApiUtil.class);

    public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
        try {

            HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
            res.setCharacterEncoding("UTF-8");
            res.addHeader("Content-Type", contentType);
            res.getWriter().print(example);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRequestBody(NativeWebRequest req, String contentType, String example) {
        try {

            HttpServletRequest request = req.getNativeRequest(HttpServletRequest.class);
            return request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
