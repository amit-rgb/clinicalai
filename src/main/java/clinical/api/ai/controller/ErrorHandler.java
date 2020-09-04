package clinical.api.ai.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@RestController
class ErrorHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        System.out.println("inside error");
        return "/error";
    }

    @RequestMapping("/error")
    public String getErrorPage(HttpServletRequest httpRequest) {
        Object status = httpRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());
            if(statusCode == 404)
                return "error/error-404";
        }
        return "error";
    }
}
