package com.ultrapower.detection.supervision.regular;

public interface IRegular {
	
	/**
	 * 反编译生成字符串对应的正则表达式
	 * @param source
	 * @return
	 */
	public String generateRegular(String source);

}
