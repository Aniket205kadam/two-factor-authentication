package dev.aniketkadam.tfa.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
@Tag(name = "Management_Controller")
public class ManagementController {

    @Operation(
            description = "Get endpoint for manager",
            summary = "This is summary for management get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            ref = "here we write reference"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "200",
                            ref = "here we write reference"
                    )
            }
    )
    @GetMapping
    public String get() {
        return "GET:: management controller";
    }
    @PostMapping
    public String post() {
        return "POST:: management controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: management controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: management controller";
    }
}
