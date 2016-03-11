package com.stzhangjk.working;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.stzhangjk.working.entity.Article;
import com.stzhangjk.working.tools.ArticleReader;
import com.stzhangjk.working.tools.PdfReader;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.*;
import java.util.List;

/**
 * Created by Grady on 2016.3.4.
 */
public class Main {


    public static final Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
    public static final int KEY_MARK = 0;
    public static int current = 0;


    public static void registerKey(final List<String> contents){
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
        List<String> contents = new ArticleReader().readFinalContents(
                "D:\\CodePrectice\\Intellij\\WorkingHelper\\src\\main\\resource\\test.txt",
                "D:\\CodePrectice\\Intellij\\WorkingHelper\\src\\main\\resource\\集美大学学报（自然版）2016年第1期.pdf",
                "2016",
                "01"
        );
        registerKey(contents);

        System.out.println(contents);
    }
}
