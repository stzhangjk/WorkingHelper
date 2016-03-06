package com.stzhangjk.working;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by Grady on 2016.3.4.
 */
public class Main {

    public static int current = 0;
    public static List<String> contents = new ArrayList<String>();
    public static final int KEY_MARK = 0;
    public static List<DocBean> docs = new ArrayList<DocBean>();
    public static final Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();

    public static void read(String name) {

        try {
            File file = new File(name);
            Scanner scanner = new Scanner(file, "utf-8");
            String[] temp = new String[10];
            for (int i = 0; scanner.hasNext(); ) {
                String line = scanner.nextLine().trim();
                if (!line.equals("")) {
                    temp[i % 10] = line;
                    if (i % 10 == 9) {
                        DocBean doc = new DocBean();
                        doc.setTitleCN(temp[0]);
                        doc.setAuthorCN(temp[1]);
                        doc.setUnitCN(temp[2]);
                        temp[3] = temp[3].substring(temp[3].lastIndexOf("[摘要]")+4).trim();
                        doc.setAbstractCN(temp[3]);
                        temp[4] = temp[4].substring(temp[4].lastIndexOf("[关键词]")+5).trim();
                        doc.setKeyWordCN(temp[4]);

                        doc.setTitleEN(temp[5]);
                        doc.setAuthorEN(temp[6]);
                        doc.setUnitEN(temp[7]);
                        temp[8] = temp[8].substring(temp[8].lastIndexOf("Abstract:")+9).trim();
                        doc.setAbstractEN(temp[8]);
                        temp[9] = temp[9].substring(temp[9].lastIndexOf("Key words:")+10).trim();
                        doc.setKeyWordEN(temp[9]);
                        docs.add(doc);
                    }
                    i++;
                }
            }
            Collections.reverse(docs);
            setID("201601");
            for(DocBean doc : docs){
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
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setID(String prefix){
        int length = docs.size();
        for(int i=0;i<length;i++){
            docs.get(i).setId(prefix + String.format("%02d",i+1));
        }
    }


    public static void registerKey(){
        JIntellitype.getInstance().registerHotKey(KEY_MARK,JIntellitype.MOD_CONTROL,(int)'B');
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            public void onHotKey(int identifier) {
                if(identifier == KEY_MARK){
                    Transferable content = new StringSelection(contents.get(current++));
                    clip.setContents(content,null);
                }
            }
        });
    }

    public static void main(String[] args) {
        read("H:\\集美大学\\学报\\材料\\教育版\\2016\\test.txt");
        System.out.println(docs);
        registerKey();
    }
}
