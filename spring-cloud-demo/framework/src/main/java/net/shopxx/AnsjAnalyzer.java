/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 * FileId: B1cPk+X5kqJO1WfGApOBWTIZBbg33MWcQ8rQ7jazXXU=
 */
package net.shopxx;

/**
 * Analyzer - Ansj
 * 
 * @author SHOP++ Team
 * @version 6.1
 */
public class AnsjAnalyzer extends org.ansj.lucene5.AnsjAnalyzer {

	/**
	 * 默认类型
	 */
	public static final org.ansj.lucene5.AnsjAnalyzer.TYPE DEFAULT_TYPE = org.ansj.lucene5.AnsjAnalyzer.TYPE.dic_ansj;

	/**
	 * 构造方法
	 */
	public AnsjAnalyzer() {
		super(DEFAULT_TYPE);
	}

}