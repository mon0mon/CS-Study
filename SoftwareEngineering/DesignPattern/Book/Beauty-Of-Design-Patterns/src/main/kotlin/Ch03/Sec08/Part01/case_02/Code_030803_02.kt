package Ch03.Sec08.Part01.case_02

class NetworkTransporter {
    fun send(address: String, content: ByteArray): ByteArray = TODO()
}

class HtmlDownloader(
    private val transporter: NetworkTransporter
) {

    fun downloadHtml(url: String): Html {
        val htmlRequest = HtmlRequest(url)
        val rawHtml = transporter.send(htmlRequest.address, htmlRequest.content.toByteArray())

        return Html(rawHtml)
    }
}

class Html(
    private val rawHtml: ByteArray
)

class HtmlRequest(
    private val url: String
) {
    val address: String = TODO()
    val content: String = TODO()
}

class Document(
    val url: String,
    val html: Html
)

// Factory 메서드로 Document 클래스 객체 생성
class DocumentFactory(
    private val downloader: HtmlDownloader
) {

    fun createDocument(url: String): Document {
        val html = downloader.downloadHtml(url)

        return Document(url, html)
    }
}
