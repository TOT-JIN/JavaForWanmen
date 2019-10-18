package buaa.dal.basics;

public class LhcScore {
	public static void main(String[] args) {
		int score1 = 100; // 令狐冲的Java成绩
		int score2 = 72; // 令狐冲的音乐成绩
		if ((score1 > 90 && score2 > 80) || (score1 == 100 && score2 > 70)) {
			System.out.println("师父说:不错，给你《独孤九剑》剑谱");
		}
	}
}
