package com.chenlb.mmseg4j.analysis;

import java.io.File;

import com.chenlb.mmseg4j.Dictionary;


/**
 * 最多分词方式.
 * 
 */
public class MaxWordAnalyzer extends MMSegAnalyzer {

	public MaxWordAnalyzer() {
		super();
		this.mode = MODE_MAXWORD;
	}

	/**
	 * @param path 词库路径
	 * @see Dictionary#getInstance(String)
	 */
	public MaxWordAnalyzer(String path) {
		super(path);
		this.mode = MODE_MAXWORD;
	}
	
	/**
	 * 构造函数
	 * @param path
	 * @param stopwordsPath   自定义停用词词典文件加载路径(相对于Classpath)
	 */
	public MaxWordAnalyzer(String path,String stopwordsPath) {
		super(path,stopwordsPath);
		this.mode = MODE_MAXWORD;
	}

	public MaxWordAnalyzer(File path) {
		dic = Dictionary.getInstance(path);
		this.mode = MODE_MAXWORD;
	}
	
	public MaxWordAnalyzer(Dictionary dic) {
		super(dic);
		this.mode = MODE_MAXWORD;
	}
}
