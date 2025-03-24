package devcldkai.kaipizzas.util;

import devcldkai.kaipizzas.domain.auth.Token;
import devcldkai.kaipizzas.service.impl.TokenVerifyService;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

public class TokenUtil {

    private TokenUtil(){
    }

    public static Token generateToken(String username){
        String token = username +":"+ System.currentTimeMillis() + ":" + UUID.randomUUID().toString();
        return new Token(new String(Base64.getEncoder().encode(token.getBytes())));
    }

    public static String retrieveUsername(String token){
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token));
            String[] split = decodedToken.split(":");
            return split[0];
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isValidToken(String token){
        try {
            LocalDateTime expirationTime = TokenVerifyService.getInstance().getCreatedAt(token);
            return LocalDateTime.now().isBefore(expirationTime);
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static String generateOTPCode() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }



}
