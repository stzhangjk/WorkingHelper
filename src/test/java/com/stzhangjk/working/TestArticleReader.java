package com.stzhangjk.working;

import com.stzhangjk.working.tools.PdfReader;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Grady on 2016.3.11.
 */
public class TestArticleReader {
    @Test
    public void testgetPage(){
        System.out.println(new PdfReader().getPages("D:\\CodePrectice\\Intellij\\WorkingHelper\\src\\main\\resource\\集美大学学报（自然版）2016年第1期.pdf"));
    }
}
