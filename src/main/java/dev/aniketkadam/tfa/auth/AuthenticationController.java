package dev.aniketkadam.tfa.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.StringToClassMapItem.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @Operation(
            description = "Register the User",
            summary = "Register the user",
            requestBody = @RequestBody(
                    description = "User register request body",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RegisterRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ) {
        AuthenticationResponse response = service.register(request);
        if (request.isTfaEnabled()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(
            @RequestBody VerificationRequest verificationRequest
    ) {
        System.out.println("We are entered in the verifyCode() method");
        return ResponseEntity.ok(service.verifyCode(verificationRequest));
    }


}
