package com.octaviookumu.cruddemo.rest;

// Exception Handling
// step 1: create custom error response class (StudentErrorResponse)
// step 2: create a custom exception class (StudentNotFoundException)
// step 3: update REST service to throw exception (throw new StudentNotFoundException("Student id not found - " + studentId);)
// step 4: Add an exception handler using @ExceptionHandler

public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
