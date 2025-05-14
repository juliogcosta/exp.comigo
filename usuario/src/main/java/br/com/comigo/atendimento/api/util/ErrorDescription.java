package br.com.comigo.atendimento.api.util;

public class ErrorDescription {
    private String description = null;
    private String code = null;
    
    public ErrorDescription(String description, String code) {
        this.description = description;
        this.code = code;
    }
    
    public String getDescription() {
      return description;
    }

    public String getCode() {
      return code;
    }
}