package com.example.wonderfulcc.testForTokenizerParser;
import com.example.wonderfulcc.utils.tokenizer.Token;
import com.example.wonderfulcc.utils.tokenizer.Tokenizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * @author Shiyun Zhu
 */
public class TestForTokenizer {

    private static Tokenizer tokenizer;
    private static final String AUTHOR = "@HarryPotter";
    private static final String SINGLETAG = "#Tree";
    private static final String MUTITAGS = "#Sun#Weather";
    private static final String FULLSTRING = "@Jack#Sun#Weather";

    @Test(timeout=1000)
    public void testFirstToken(){
        tokenizer = new Tokenizer(AUTHOR);
        // check the type of the first token
        assertEquals("wrong token type", Token.Type.NAME, tokenizer.current().getType());
        // check the actual token value
        assertEquals("wrong token value", "@HarryPotter", tokenizer.current().getToken());

    }


    @Test (timeout=1000)
    public void TestTokenizer(){
        tokenizer = new Tokenizer(FULLSTRING);
        assertEquals("wrong token type", Token.Type.NAME, tokenizer.current().getType());
        // check the actual token value
        assertEquals("wrong token value", "@Jack", tokenizer.current().getToken());

        tokenizer.next();
        assertEquals("wrong token type", Token.Type.SEP, tokenizer.current().getType());
        // check the actual token value
        assertEquals("wrong token value", "#", tokenizer.current().getToken());

        tokenizer.next();
        assertEquals("wrong token type", Token.Type.TAG, tokenizer.current().getType());
        // check the actual token value
        assertEquals("wrong token value", "Sun", tokenizer.current().getToken());
    }
}
