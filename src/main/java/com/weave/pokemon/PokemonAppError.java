package com.weave.pokemon;

public enum PokemonAppError {

    NOT_FOUND(404, "Not found");

    private final Integer errorCode;
    private final String errorMessage;

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    PokemonAppError(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
