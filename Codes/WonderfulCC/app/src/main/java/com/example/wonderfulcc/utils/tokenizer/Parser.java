package com.example.wonderfulcc.utils.tokenizer;


import java.util.ArrayList;
import java.util.List;

/**
 * the search expression can be:
 *
 *  (@Name#TAG)
 *  #TAG
 *  (@Name)
 *  we will search the post first in author then consider of the tag
 *  @author  Shiyun zhu
 */
public class Parser {

    Tokenizer tokenizer;

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public String getName() {
        String name ="";

        if (tokenizer.current().getType() == Token.Type.NAME) {
            name = tokenizer.current().getToken().substring(1);
        }
            tokenizer.next();
        return name;
    }

    public String getTags() {
        String tags="";
        if (tokenizer.current().getType() == Token.Type.SEP) {
            tokenizer.next();
            tags= tokenizer.current().getToken();
            return tags;
        }
        else{return null;}
    }
}