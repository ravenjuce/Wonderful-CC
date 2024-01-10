package com.example.wonderfulcc.testForTokenizerParser;
import com.example.wonderfulcc.utils.tokenizer.Parser;
import com.example.wonderfulcc.utils.tokenizer.Token;
import com.example.wonderfulcc.utils.tokenizer.Tokenizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


import static org.junit.Assert.*;

import java.util.ArrayList;


/**
 * @author Shiyun Zhu
 */
public class TestForParser {

    private static final String TEST1 = "#Sun";
    private static final String TEST2 = "@Jack#Sun";


    Parser parser1 = new Parser(new Tokenizer(TEST1));
    Parser parser2 = new Parser(new Tokenizer(TEST2));

    @Test(timeout=1000)
    public void testGetName(){

        // check the type of the first token
        assertEquals("wrong in get Name", "Jack", parser2.getName());

    }

    @Test(timeout=1000)
    public void testGetTags(){

    }


}
