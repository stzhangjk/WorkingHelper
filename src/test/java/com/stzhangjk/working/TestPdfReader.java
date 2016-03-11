package com.stzhangjk.working;

import com.stzhangjk.working.entity.Article;
import com.stzhangjk.working.tools.ArticleReader;
import com.stzhangjk.working.tools.PdfReader;
import org.junit.Test;

import java.util.List;

/**
 * Created by Grady on 2016.3.11.
 */
public class TestPdfReader {

    @Test
    public void testGetPage() {
        PdfReader reader = new PdfReader();
        List<String> pages = reader.getPages("D:\\CodePrectice\\Intellij\\WorkingHelper\\src\\main\\resource\\集美大学学报（自然版）2016年第1期.pdf");

        ArticleReader articleReader = new ArticleReader();
//        articleReader.readFinalContents("D:\\CodePrectice\\Intellij\\WorkingHelper\\src\\main\\resource\\test.txt", "201601");
        List<Article> docs = articleReader.getDocs();

        System.out.println(pages.get(0));
        System.out.println(docs.get(docs.size() - 1).getTitleCN());


        System.out.println(new PdfReader().getStartPageNum(pages.get(0), docs.get(docs.size() - 1).getTitleCN(), "2016", "01"));
    }
}
