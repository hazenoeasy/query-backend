package plus.yuhaozhang.blog.dao.pojo;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Data
public class Article {
    public static final Integer ARTICLE_TOP = 1;

    public static final Integer ARTICLE_COMMON = 0;

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private Long authorId;

    private Long bodyId;

    private Long categoryId;

    private Integer weight = ARTICLE_COMMON;

    private Long createDate;

}
