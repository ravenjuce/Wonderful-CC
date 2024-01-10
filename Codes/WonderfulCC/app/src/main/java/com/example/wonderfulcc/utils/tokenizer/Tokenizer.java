package com.example.wonderfulcc.utils.tokenizer;

/**
 * Tokenizer
 * Tokenization, within the context of this lab, is the process of splitting a string into
 * small units called, 'Tokens', to be passed onto the Parser.
 * @author Shiyun Zhu
 */
public class Tokenizer {
    private String buffer;          // String to be transformed into tokens each time next() is called.
    private Token currentToken;     // The current token. The next token is extracted when next() is called.


    /**
     * Tokenizer class constructor
     * The constructor extracts the first token and save it to currentToken
     * **** please do not modify this part ****
     */
    public Tokenizer(String text) {
        buffer = text;          // save input text (string)
        next();                 // extracts the first token.
    }

    /**
     * This function will find and extract a next token from {@code _buffer} and
     * save the token to {@code currentToken}.
     */
    public void next() {
        buffer = buffer.trim();     // remove whitespace

        if (buffer.isEmpty()) {
            currentToken = null;    // if there's no string left, set currentToken null and return
            return;
        }

        char firstChar = buffer.charAt(0);


        /**
         * check whether it is the author name like : @jack
         */
        if (firstChar == '@'){
            if(buffer.indexOf('#')==-1){
                currentToken = new Token(buffer,Token.Type.NAME);
            }else{int index = 0;
                for (int i = 0; i< buffer.length();i++){

                    if(buffer.charAt(i) != '#'){
                        index += 1;

                    }
                    else{
                        currentToken = new Token(buffer.substring(0,index),Token.Type.NAME);
                        break;
                    }
                }}


            /**
             * check whether it is the sep of tags
             */
        } else if (firstChar == '#') {

            currentToken = new Token("#", Token.Type.SEP);

        } else{
            if(buffer.length()==1){
                currentToken = new Token(buffer, Token.Type.TAG);}

            if(buffer.length()!=1){
                int index =0;
                for  (int i = 0; i< buffer.length(); i++){
                    if (buffer.charAt(i)!='#'){
                        index += 1;
                        if (index==buffer.length()){
                            currentToken = new Token(buffer.substring(0,index), Token.Type.TAG);
                        }
                    }else{
                        currentToken = new Token(buffer.substring(0,index), Token.Type.TAG);
                        break;}
                }
            }
        }

        // Remove the extracted token from buffer
        int tokenLen = currentToken.getToken().length();
        buffer = buffer.substring(tokenLen);
    }

    /**
     * Returns the current token extracted by {@code next()}
     * **** please do not modify this part ****
     *
     * @return type: Token
     */
    public Token current() {
        return currentToken;
    }

    /**
     * Check whether tokenizer still has tokens left
     * **** please do not modify this part ****
     *
     * @return type: boolean
     */
    public boolean hasNext() {
        return currentToken != null;
    }
}
