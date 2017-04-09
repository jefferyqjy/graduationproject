package com.link.core;

import java.util.Comparator;

public class ComparatorUserScore  implements Comparator<UserScore>{

	@Override
	public int compare(UserScore o1, UserScore o2) {
		return o2.getScore() - o1.getScore();
	}

}
