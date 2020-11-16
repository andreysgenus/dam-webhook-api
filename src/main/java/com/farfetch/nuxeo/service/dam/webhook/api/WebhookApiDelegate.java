package com.farfetch.nuxeo.service.dam.webhook.api;

import com.farfetch.nuxeo.service.dam.webhook.model.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

/**
 * A delegate to be called by the {@link WebhookApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
public interface WebhookApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /webhook : Send a webhook to be processed by the Farfetch platform.
     * Each request is transformed in a event or command to the Farfetch platform. _**The processing of events or commands is asynchronous**_ 
     *
     * @param requestBody  (required)
     * @return Accepted - The event or command was successfully queued for processing. (status code 202)
     *         or Bad Request - The request body is malformed. Please read the schemas part of this document. (status code 400)
     *         or Unauthorized - The credentials used on the request are invalid. (status code 401)
     *         or Internal Server Error - The application that receives the events or commands has an issue. (status code 500)
     *         or Bad Gateway - The location where the events or commands are stored was unreachable. (status code 502)
     * @see WebhookApi#webhookPost
     */
    default ResponseEntity<Void> webhookPost(RequestBody requestBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String requestStr = objectMapper.writeValueAsString(requestBody);
            System.out.println("Request processed successfully. HTTP Response code = 202");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
