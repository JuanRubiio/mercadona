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
import mercadona.springbootapp.dto.AllDestinyResponse;
import mercadona.springbootapp.dto.DestinyDTO;
import mercadona.springbootapp.exception.RestException;

public interface IDestinyController {
	
	@Operation(summary = "getDestinyByCod", description = "Get a destino by cod", tags={ "Destiny" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinyDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/getDestinoByCod" }, method = { RequestMethod.GET })
	ResponseEntity<DestinyDTO> getDestinyByCod(@RequestHeader("access-token") String token, 
			@RequestParam(name = "cod", required = true) Integer cod) throws RestException;
	
	@Operation(summary = "getAllDestiny", description = "Get all destino", tags={ "Destiny" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AllDestinyResponse.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/getAllDestiny" }, method = { RequestMethod.GET })
	ResponseEntity<AllDestinyResponse> getAllDestiny(@RequestHeader("access-token") String token) throws RestException;
	
	@Operation(summary = "createDestiny", description = "Create a destino entity", tags={ "Destiny" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinyDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/createDestiny" }, method = { RequestMethod.POST })
	ResponseEntity<DestinyDTO> createDestiny(@RequestHeader("access-token") String token, 
			@RequestBody DestinyDTO request) throws RestException;
	
	@Operation(summary = "updateDestiny", description = "update destino entity", tags={ "Destiny" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinyDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/updateDestiny" }, method = { RequestMethod.PUT })
	ResponseEntity<DestinyDTO> updateDestiny(@RequestHeader("access-token") String token, 
			@RequestBody DestinyDTO request) throws RestException;
	
	@Operation(summary = "deleteDestiny", description = "Delete destino entity", tags={ "Destiny" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DestinyDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/deleteDestiny" }, method = { RequestMethod.DELETE })
	ResponseEntity<DestinyDTO> deleteDestiny(@RequestHeader("access-token") String token, 
			@RequestBody DestinyDTO request) throws RestException;
	

}
