package hu.temetkezes.demo.utils;

import hu.temetkezes.demo.domain.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static java.time.LocalTime.now;

public class RequestUtils {

    public static Response getResponse(HttpServletRequest request, Map<?,?> data, String message, HttpStatus status){
        return new Response(now().toString(),status.value(),request.getRequestURI(),HttpStatus.valueOf(status.value()),message,"",data);
    }
}
