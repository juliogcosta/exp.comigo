package br.com.comigo.autenticacao.config;


import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder
{
    @Override
    public Exception decode(String methodKey, Response response)
    {
        try
        {
            String from = response.request().url().split(Pattern.quote("/"))[2];

            String erroFromExt = new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
            
            String message = new JSONObject(erroFromExt).getString("message").concat(" [").concat(from).concat("][EXT]");

            return new Exception(String.valueOf(response.status()).concat(":").concat(message));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
