package com.chenlb.mmseg4j.analysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.AttributeFactory;

import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.Word;

public class MMSegTokenizer extends Tokenizer {
	private MMSeg mmSeg;

	private CharTermAttribute termAtt;
	private OffsetAttribute offsetAtt;
	private PositionIncrementAttribute positionAtt;
	private TypeAttribute typeAtt;
	/**自定义停用词*/
	private Set<String> filter;
	
	public MMSegTokenizer(AttributeFactory factory,Seg seg,String stopwordsDir,Reader reader) {
		super(factory);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
		addStopwords(stopwordsDir);
	}
	
	public MMSegTokenizer(AttributeFactory factory,Seg seg, Set<String> filter,Reader reader) {
		super(factory);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
		this.filter = filter;
	}
	
	public MMSegTokenizer(AttributeFactory factory,Seg seg, String stopwordsDir) {
		super(factory);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
		addStopwords(stopwordsDir);
	}
	
	public MMSegTokenizer(AttributeFactory factory,Seg seg, Set<String> filter) {
		super(factory);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
		this.filter = filter;
	}
	
	public MMSegTokenizer(AttributeFactory factory,Seg seg,Reader reader) {
		super(factory);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
	}
	
	public MMSegTokenizer(AttributeFactory factory,Seg seg) {
		super(factory);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
	}
	
	/**
	 * 构造函数
	 * @param seg
	 * @param stopwordsDir  自定义停用词词典文件加载路径
	 * @param reader
	 */
	public MMSegTokenizer(Seg seg,String stopwordsDir,Reader reader) {
		//super(input);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
		addStopwords(stopwordsDir);
	}
	
	/**
	 * 构造函数
	 * @param seg
	 * @param filter  自定义停用词Set
	 * @param reader
	 */
	public MMSegTokenizer(Seg seg, Set<String> filter,Reader reader) {
		//super(input);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
		this.filter = filter;
	}
	
	/**
	 * 构造函数
	 * @param seg
	 * @param stopwordsDir  自定义停用词词典文件加载路径
	 */
	public MMSegTokenizer(Seg seg, String stopwordsDir) {
		//super(input);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
		addStopwords(stopwordsDir);
	}
	
	/**
	 * 构造函数
	 * @param seg
	 * @param filter  自定义停用词Set
	 */
	public MMSegTokenizer(Seg seg, Set<String> filter) {
		//super(input);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
		this.filter = filter;
	}
	
	public MMSegTokenizer(Seg seg, Reader reader) {
		//super(input);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
	}
	
	public MMSegTokenizer(Seg seg) {
		//super(input);
		mmSeg = new MMSeg(input, seg);
		termAtt = addAttribute(CharTermAttribute.class);
		offsetAtt = addAttribute(OffsetAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		positionAtt = addAttribute(PositionIncrementAttribute.class);
	}

	public void reset() throws IOException {
		//lucene 4.0
		//org.apache.lucene.analysis.Tokenizer.setReader(Reader)
		//setReader 自动被调用, input 自动被设置。
		
		//Lucene5.0下需要加这一句
		super.reset();
		mmSeg.reset(input);
	}

	/*//lucene 2.9 以下
 	public Token next(Token reusableToken) throws IOException {
		Token token = null;
		Word word = mmSeg.next();
		if(word != null) {
			//lucene 2.3
			reusableToken.clear();
			reusableToken.setTermBuffer(word.getSen(), word.getWordOffset(), word.getLength());
			reusableToken.setStartOffset(word.getStartOffset());
			reusableToken.setEndOffset(word.getEndOffset());
			reusableToken.setType(word.getType());

			token = reusableToken;

			//lucene 2.4
			//token = reusableToken.reinit(word.getSen(), word.getWordOffset(), word.getLength(), word.getStartOffset(), word.getEndOffset(), word.getType());
		}

		return token;
	}*/

	@Override
	public final boolean incrementToken() throws IOException {
		clearAttributes();
		Word word = null;
		String wordStr = null;
		boolean flag = true;
		int position = 0;
		do {
			word = mmSeg.next();
			if(null == word) {
				break;
			}
			wordStr = word.getString();
			if (filter != null && filter.contains(wordStr)) {
				continue;
			} else {
				position++;
				flag = false;
			}
		} while(flag);
		if(null != wordStr) {
			positionAtt.setPositionIncrement(position);
			termAtt.copyBuffer(word.getSen(), word.getWordOffset(), word.getLength());
			offsetAtt.setOffset(word.getStartOffset(), word.getEndOffset());
			typeAtt.setType(word.getType());
			return true;
		}
		end();
		return false;
	}
	
	/**
	 * 添加停用词
	 * @param dir
	 */
	private void addStopwords(String dir) {
        if (dir == null || "".equals(dir)) {
            return;
        }
        this.filter = new HashSet<String>();
        InputStreamReader reader;
        try {
        	InputStream is = this.getClass().getClassLoader().getResourceAsStream(dir);
            reader = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(reader); 
            String word = br.readLine();  
            while (word != null) {
                this.filter.add(word);
                word = br.readLine(); 
            }  
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No custom stopword file found");
        } catch (IOException e) {
        	throw new RuntimeException("Custom stopword file io exception");
        }      
    }
}
