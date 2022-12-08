package mercadona.springbootapp.utils;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

import org.springframework.core.env.Environment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.DefaultClaims;


public class Utilidades {
	
	  private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static Boolean isNumeric(String s) {
		
        if (s == null || s.equals("")) {
            return false;
        }
	 
	        return s.chars().allMatch(Character::isDigit);
    }
	
	public static Claims validarJWT(String jwt, Environment env) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, IOException, CertificateException, NoSuchAlgorithmException, InvalidKeySpecException {
		
		Claims claims = validarToken(jwt, env); 
	    
	    return claims;
	}
	
	private static Claims validarToken(String jwt, Environment env) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, CertificateException, IOException, IllegalArgumentException, NoSuchAlgorithmException, InvalidKeySpecException { 

		return Jwts.parser().setSigningKey(getPublicKey(env)).parseClaimsJws(jwt).getBody(); 

	}
	
	private static PublicKey getPublicKey(Environment env) throws NoSuchAlgorithmException, InvalidKeySpecException {	
		PublicKey publicKey = null;

//        byte[] encoded = Base64.getDecoder().decode(env.getProperty("ccs.cer.publicKeyPEM"));
        byte[] encoded = Base64.getDecoder().decode("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.AyFlCKJ_JICuzAIx4fuAnCNH5Tg5pzoAfXm7ESGJiLg");
        
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        publicKey = keyFactory.generatePublic(keySpec); 
        
        return publicKey;
    }
	
	@SuppressWarnings("unchecked")
	public static Claims getClaimsJWT(String jwt) throws JsonMappingException, JsonProcessingException {
		
		String[] chunks = jwt.split("\\.");
		
		Base64.Decoder decoder = Base64.getUrlDecoder();
		String payload = new String(decoder.decode(chunks[1]));

        Claims claims = new DefaultClaims(objectMapper.readValue(payload, Map.class));
		
        return claims;
	}
	

}
