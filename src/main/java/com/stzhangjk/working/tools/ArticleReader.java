package com.stzhangjk.working.tools;

import com.stzhangjk.working.entity.Article;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Grady on 2016.3.11.
 */
public class ArticleReader {

    private List<Article> docs = new ArrayList<Article>();

    public List<String> readFinalContents(String txtName, String yyyy, String MM) {
        List<String> contents = new ArrayList<String>();
        try {
            File file = new File(txtName);
            Scanner scanner = new Scanner(file, "utf-8");
            String[] temp = new String[10];
            for (int i = 0; scanner.hasNext(); ) {
                String line = scanner.nextLine().trim();
                Pattern pattern = Pattern.compile("[　]+");
                Matcher matcher = pattern.matcher(line);
                while(matcher.find()){
                    line = line.replace("　"," ");
                }
                if (!line.equals("")) {
                    temp[i % 10] = line;
                    if (i % 10 == 9) {
                        Article doc = new Article();
                        doc.setTitleCN(temp[0]);
                        doc.setAuthorCN(temp[1]);
                        doc.setUnitCN(temp[2]);
                        temp[3] = temp[3].replace(Util.matchString(temp[3], Pattern.compile("[\\[【［][　 ]*摘[　 ]*要[　 ]*[\\]】］]")).get(0), "").trim();
                        doc.setAbstractCN(temp[3]);
                        temp[4] = temp[4].replace(Util.matchString(temp[4], Pattern.compile("[\\[【［][　 ]*关[　 ]*键[　 ]*词[　 ]*[\\]】］]")).get(0), "").trim();
                        doc.setKeyWordCN(temp[4]);


                        doc.setTitleEN(temp[5]);
                        doc.setAuthorEN(temp[6]);
                        doc.setUnitEN(temp[7]);
                        temp[8] = temp[8].replace(Util.matchString(temp[8], Pattern.compile("[\\[【［]?[　 ]*Abstract[　 ]*[:：]?[　 ]*[\\]】］]?")).get(0), "").trim();
                        doc.setAbstractEN(temp[8]);
                        temp[9] = temp[9].replace(Util.matchString(temp[9], Pattern.compile("[\\[【［]?[　 ]*Key[　 ]*words[　 ]*[:：]?[　 ]*[\\]】］]?")).get(0), "").trim();
                        doc.setKeyWordEN(temp[9]);

                        docs.add(doc);
                    }
                    i++;
                }
            }
            Collections.reverse(docs);
            setID(docs, yyyy + MM);
            //readPages(docs, pdfName, yyyy, MM);
            insertIntoContents(docs, contents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contents;
    }

    private void setID(List<Article> docs, String prefix) {
        int length = docs.size();
        for (int i = 0; i < length; i++) {
            docs.get(i).setId(prefix + String.format("%02d", i + 1));
        }
    }

    private void insertIntoContents(List<Article> docs, List<String> contents) {
        for (Article doc : docs) {
            contents.add(doc.getId());
            contents.add(doc.getTitleCN());
            contents.add(doc.getAuthorCN());
            contents.add(doc.getUnitCN());
            contents.add(doc.getKeyWordCN());
            contents.add(doc.getAbstractCN());

            contents.add(doc.getTitleEN());
            contents.add(doc.getAuthorEN());
            contents.add(doc.getUnitEN());
            contents.add(doc.getKeyWordEN());
            contents.add(doc.getAbstractEN());

            contents.add(String.valueOf(doc.getStartPage()));
            contents.add(String.valueOf(doc.getEndPage()));
        }
    }

    public List<Article> getDocs() {
        return docs;
    }

    public void setDocs(List<Article> docs) {
        this.docs = docs;
    }
}
