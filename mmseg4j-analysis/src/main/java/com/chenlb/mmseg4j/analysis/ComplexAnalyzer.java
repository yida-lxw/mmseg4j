package com.chenlb.mmseg4j.analysis;

import java.io.File;

import com.chenlb.mmseg4j.Dictionary;

/**
 * ComplexAnalyzer
 * 
 */
public class ComplexAnalyzer extends MMSegAnalyzer {

	public ComplexAnalyzer() {
		super();
		this.mode = MODE_COMPLEX;
	}

	/**
	 * @param path 词库路径
	 * @see Dictionary#getInstance(String)
	 */
	public ComplexAnalyzer(String path) {
		super(path);
		this.mode = MODE_COMPLEX;
	}
	
	/**
	 * 构造函数
	 * @param path
	 * @param stopwordsPath   自定义停用词词典文件加载路径(相对于Classpath)
	 */
	public ComplexAnalyzer(String path,String stopwordsPath) {
		super(path,stopwordsPath);
		this.mode = MODE_COMPLEX;
	}

	public ComplexAnalyzer(File path) {
		dic = Dictionary.getInstance(path);
		this.mode = MODE_COMPLEX;
	}
	
	public ComplexAnalyzer(Dictionary dic) {
		super(dic);
		this.mode = MODE_COMPLEX;
	}
}
