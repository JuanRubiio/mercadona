package mercadona.springbootapp.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import mercadona.springbootapp.common.StandarizedApiExceptionResponse;
import mercadona.springbootapp.dto.AllProviderResponse;
import mercadona.springbootapp.dto.ProviderDTO;
import mercadona.springbootapp.exception.RestException;

public interface IProviderController {

	@Operation(summary = "getProviderByCod", description = "Get a proveedor by cod", tags={ "Provider" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProviderDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/getProviderByCod" }, method = { RequestMethod.GET })
	ResponseEntity<ProviderDTO> getProviderByCod(@RequestHeader("access-token") String token, 
			@RequestParam(name = "cod", required = true) Integer cod) throws RestException;
	
	@Operation(summary = "getAllProvider", description = "Get all proveedor", tags={ "Provider" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AllProviderResponse.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/getAllProvider" }, method = { RequestMethod.GET })
	ResponseEntity<AllProviderResponse> getAllProvider(@RequestHeader("access-token") String token) throws RestException;
	
	@Operation(summary = "createProvider", description = "Create a proveedor entity", tags={ "Provider" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProviderDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/createProvider" }, method = { RequestMethod.POST })
	ResponseEntity<ProviderDTO> createProvider(@RequestHeader("access-token") String token, 
			@RequestBody ProviderDTO request) throws RestException;
	
	@Operation(summary = "updateProvider", description = "update proveedor entity", tags={ "Provider" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProviderDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/updateProvider" }, method = { RequestMethod.PUT })
	ResponseEntity<ProviderDTO> updateProvider(@RequestHeader("access-token") String token, 
			@RequestBody ProviderDTO request) throws RestException;
	
	@Operation(summary = "deleteProvider", description = "Delete proveedor entity", tags={ "Provider" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProviderDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/deleteProvider" }, method = { RequestMethod.DELETE })
	ResponseEntity<ProviderDTO> deleteProvider(@RequestHeader("access-token") String token, 
			@RequestBody ProviderDTO request) throws RestException;
	
	
}
