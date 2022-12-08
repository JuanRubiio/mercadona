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
import mercadona.springbootapp.dto.AllProductResponse;
import mercadona.springbootapp.dto.ProductDTO;
import mercadona.springbootapp.exception.RestException;

public interface IProductController {

	@Operation(summary = "getProductByCod", description = "Get a Product by cod", tags={ "Product" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/getProductByCod" }, method = { RequestMethod.GET })
	ResponseEntity<ProductDTO> getProductByCod(@RequestHeader("access-token") String token, 
			@RequestParam(name = "cod", required = true) Integer cod) throws RestException;
	
	@Operation(summary = "getAllProduct", description = "Get all Product", tags={ "Product" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AllProductResponse.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/getAllProduct" }, method = { RequestMethod.GET })
	ResponseEntity<AllProductResponse> getAllProduct(@RequestHeader("access-token") String token) throws RestException;
	
	@Operation(summary = "createProduct", description = "Create a Product entity", tags={ "Product" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/createProduct" }, method = { RequestMethod.POST })
	ResponseEntity<ProductDTO> createProduct(@RequestHeader("access-token") String token, 
			@RequestBody ProductDTO request) throws RestException;
	
	@Operation(summary = "updateProduct", description = "update Product entity", tags={ "Product" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/updateProduct" }, method = { RequestMethod.PUT })
	ResponseEntity<ProductDTO> updateProduct(@RequestHeader("access-token") String token, 
			@RequestBody ProductDTO request) throws RestException;
	
	@Operation(summary = "deleteProduct", description = "Delete Product entity", tags={ "Product" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = { "/deleteProduct" }, method = { RequestMethod.DELETE })
	ResponseEntity<ProductDTO> deleteProduct(@RequestHeader("access-token") String token, 
			@RequestBody ProductDTO request) throws RestException;
	
}
