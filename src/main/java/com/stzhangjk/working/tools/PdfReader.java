package com.stzhangjk.working.tools;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Grady on 2016.3.11.
 */
public class PdfReader {

    private int maxPage;

    /**
     * 获取全部内容
     * @param filePath PDF文件路径
     * @return 包含整个文档的PDF文件
     */
    public String getALL(String filePath){
        PDDocument document = null;
        String result = null;
        try{
            document = PDDocument.load(filePath);
            maxPage = document.getNumberOfPages();
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(document.getNumberOfPages());
            result = Util.toDBC(stripper.getText(document));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(document!= null){
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }




    /**
     * 读取所有页面
     * @param filePath 文件路径
     * @return 页面字符串集合，半角
     */
    public List<String> getPages(String filePath) {
        PDDocument document = null;
        List<String> result = new ArrayList<String>();
        try {
            document = PDDocument.load(filePath);
            int end = document.getNumberOfPages();
            maxPage = end;
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            for (int i = 1; i <= end; i++) {
                stripper.setStartPage(i);
                stripper.setEndPage(i);
                String tmp = Util.toDBC(stripper.getText(document));
                if (tmp != null && !tmp.equals("")) {
//                    System.out.println(tmp);
                    result.add(tmp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public boolean hasTitle(String page, String title) {
        return page.contains(title);
    }

    public int getStartPageNum(String page, String title, String yyyy, String MM) {
        String str = null;
        if (hasTitle(page, title)) {
            Pattern pattern = Pattern.compile("\\[文章编号\\] [0-9]{4} - [0-9]{4}\\(" + yyyy + "\\)" + MM + " - [0-9]{4} - [0-9]{2}");
            Matcher matcher = pattern.matcher(page);
            while (matcher.find()) {
                str = matcher.group();
                System.out.println(str);
            }
        }
        if (str != null && !str.equals("")) {
            Pattern pattern = Pattern.compile("- [0-9]{4} -");
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()){
                str = matcher.group();
                System.out.println(str);
            }
        }
        if(str!=null && !str.equals("")){
            Pattern pattern = Pattern.compile("[0-9]{4}");
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()){
                str = matcher.group();
                System.out.println(str);
            }
        }

        return Integer.parseInt(str);
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }
}
