package com.chenlb.mmseg4j.analysis;

import java.io.File;

import com.chenlb.mmseg4j.Dictionary;

/**
 * mmseg 的 simple anlayzer.
 * 
 */
public class SimpleAnalyzer extends MMSegAnalyzer {
	
	public SimpleAnalyzer() {
		super();
		this.mode = MODE_SIMPLE;
	}

	/**
	 * @param path 词库路径
	 * @see Dictionary#getInstance(String)
	 */
	public SimpleAnalyzer(String path) {
		super(path);
		this.mode = MODE_SIMPLE;
	}
	
	/**
	 * 构造函数
	 * @param path
	 * @param stopwordsPath   自定义停用词词典文件加载路径(相对于Classpath)
	 */
	public SimpleAnalyzer(String path,String stopwordsPath) {
		super(path,stopwordsPath);
		this.mode = MODE_SIMPLE;
	}

	public SimpleAnalyzer(File path) {
		dic = Dictionary.getInstance(path);
		this.mode = MODE_SIMPLE;
	}
	
	public SimpleAnalyzer(Dictionary dic) {
		super(dic);
		this.mode = MODE_SIMPLE;
	}
}
