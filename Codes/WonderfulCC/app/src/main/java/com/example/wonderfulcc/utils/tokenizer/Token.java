package com.example.wonderfulcc.utils.tokenizer;


import java.util.Objects;

/**
 * Token class to save extracted token from tokenizer.
 * Each token has its surface form saved in {@code token}
 * and type saved in {@code type} which is one of the predefined type in Type enum.
 * The following are the different types of tokens:
 *  NAME: @+String  ,be used to show author name;
 * TAG: String , a tag of post;
 * SEP: # ,separator of Tags.
 *  @author  Shiyun Zhu
 */
public class Token {
    // The following enum defines different types of tokens. Example of accessing these: Token.Type.INT
    public enum Type {NAME,TAG,SEP}

    /**
     * The following exception should be thrown if a tokenizer attempts to tokenize something that is not of one
     * of the types of tokens.
     */
    public static class IllegalTokenException extends IllegalArgumentException {
        public IllegalTokenException(String errorMessage) {
            super(errorMessage);
        }
    }

    // Fields of the class Token.
    private final String token; // Token representation in String form.
    private final Type type;    // Type of the token.

    public Token(String token, Type type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        if (type == Type.TAG) {
            return "TAG(" + token + ")";
        } else {
            return type + ",";
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true; // Same hashcode.
        }
        if (!(other instanceof Token)) {
            return false; // Null or not the same type.
        }
        return this.type == ((Token) other).getType() && this.token.equals(((Token) other).getToken()); // Values are the same.
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, type);
    }
}
