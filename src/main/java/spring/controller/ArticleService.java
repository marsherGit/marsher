package spring.controller;

public class ArticleService {

	public void writeArticle(NewArticleCommand command) {
		System.out.println("�ű� �Խñ� ���: " + command);
	}
}