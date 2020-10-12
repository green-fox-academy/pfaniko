package com.greenfoxacademy.movieapp.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
                       AuthenticationException authException) throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    response.setContentType("application/json;charset=UTF-8");
    response.setStatus(403);

    try {
      response.getWriter().write(String.valueOf(new JSONObject()
      .put("timestamp", new Date())
      .put("status", response.getStatus())
      .put("error", HttpStatus.valueOf(response.getStatus()).getReasonPhrase())
      .put("path", request.getRequestURI())
      .put("message", "Access denied")));
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}
