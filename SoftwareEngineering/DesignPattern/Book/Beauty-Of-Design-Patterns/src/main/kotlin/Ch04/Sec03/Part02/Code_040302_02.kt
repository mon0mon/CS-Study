package Ch04.Sec03.Part02

fun postBlog(
    title: String, summary: String, keywords: String, content: String, category: String, authorId: Long
): Nothing = TODO()

// 매개변수를 객체로 캡슐화
data class Blog(
    val title: String, val summary: String, val keywords: String, val content: String, val category: String,
    val authorId: Long
)

fun postBlog(blog: Blog): Nothing = TODO()
