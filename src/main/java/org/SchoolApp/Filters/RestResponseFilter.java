package org.SchoolApp.Filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class RestResponseFilter implements Filter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        System.out.println("Filtering request for URI: " + requestURI);

        // Skip filtering for specific URIs
        if (requestURI.startsWith("/api-docs") || requestURI.startsWith("/swagger-ui") || requestURI.equals("/swagger-ui.html")) {
            chain.doFilter(request, response);
            return;
        }

        // Wrap the response to capture the output
        CharResponseWrapper responseWrapper = new CharResponseWrapper(httpResponse);

        // Proceed with the next filter or target resource
        chain.doFilter(request, responseWrapper);

        // Get captured response body as a string
        String responseBody = responseWrapper.getCaptureAsString();
        System.out.println("Captured Response Body: " + responseBody);

        // Format the response body
        String formattedResponse = formatResponse(httpResponse.getStatus(), responseBody);

        // Set the content type and write the formatted response to the original response
        httpResponse.setContentType("application/json");
        if (!httpResponse.isCommitted()) {
            PrintWriter out = httpResponse.getWriter();
            out.write(formattedResponse);
            out.flush();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }

    // Inner class to capture the response body
    private class CharResponseWrapper extends HttpServletResponseWrapper {
        private final StringWriter writer = new StringWriter();
        private final PrintWriter printWriter = new PrintWriter(writer);

        public CharResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return printWriter;
        }

        @Override
        public void flushBuffer() throws IOException {
            printWriter.flush(); // Ensure all content is flushed to the writer
            super.flushBuffer();
        }

        public String getCaptureAsString() {
            printWriter.flush(); // Ensure all content is written to the StringWriter
            return writer.toString();
        }
    }

    // Method to format the response
    private String formatResponse(int statusCode, String data) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", statusCode);

        // Parsing and handling response data as an array or object
        Object parsedData;
        try {
            parsedData = objectMapper.readTree(data); // Attempt to parse JSON array or object
        } catch (Exception e) {
            parsedData = data.isEmpty() ? null : data;
        }

        responseMap.put("data", parsedData);
        responseMap.put("message", statusCode == 200 ? "Success" : "Error");

        try {
            return objectMapper.writeValueAsString(responseMap);
        } catch (Exception e) {
            return "{\"code\":500, \"data\":null, \"message\":\"Error processing response\"}";
        }
    }
}
