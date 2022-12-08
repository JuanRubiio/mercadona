package mercadona.springbootapp.utils;

public class Constantes {
	
	// Spring Security

//	public static final String LOGIN_URL = "/login";
//	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
//	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

//	public static final String ISSUER_INFO = "https://www.mercadona.com/";
//	public static final String SUPER_SECRET_KEY = "1234";
//	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
	
	/** Configuraciones de autorizacion **/
	public static String SEPARATOR = "~";
	public static String AUTH_HEADER = "access-token";
	
	public static String AUTH_WHITELIST = "/v3/api-docs/**~/swagger-ui/**~/Autentication/**~/security/**~/actuator/**~/magnolia/alertaAplicacion**";
	
	public static String AUTH_MAX_TIME_INACTIVITY = "30";
	
	public static String ALLOWED_ORIGINS = "http://localhost:7001";
	
//	cyc.auth.max.time.inactivity = 30


}
