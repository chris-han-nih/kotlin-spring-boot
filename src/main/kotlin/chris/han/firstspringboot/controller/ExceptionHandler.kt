package chris.han.firstspringboot.controller

import com.fasterxml.jackson.core.JsonParseException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandler {
  @ExceptionHandler(JsonParseException::class)
  fun jsonParseExceptionHandler(
    servletRequest: HttpServletRequest,
    exception: Exception
  ): ResponseEntity<ErrorResponse> {
    return ResponseEntity(
      ErrorResponse.create(exception, HttpStatus.BAD_REQUEST, "Invalid Request"), HttpStatus
      .BAD_REQUEST)
  }
  
  @ExceptionHandler(HttpMessageNotReadableException::class)
  fun httpMessageNotReadableExceptionHandler(
    servletRequest: HttpServletRequest,
    exception: Exception
  ): ResponseEntity<ErrorResponse> {
    return ResponseEntity(
      ErrorResponse.create(exception, HttpStatus.BAD_REQUEST, "Invalid Request"), HttpStatus.BAD_REQUEST)
  }
}
