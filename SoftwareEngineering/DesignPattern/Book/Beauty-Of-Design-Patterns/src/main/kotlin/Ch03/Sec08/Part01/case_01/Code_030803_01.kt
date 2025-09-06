package Ch03.Sec08.Part01.case_01

class NetworkTransporter {
    fun send(htmlRequest: HtmlRequest): ByteArray = TODO()
}

class HtmlDownloader(
    private val transporter: NetworkTransporter
) {

    fun downloadHtml(url: String): Html {
        val rawHtml = transporter.send(HtmlRequest(url))

        return Html(rawHtml)
    }
}

class Html(
    private val rawHtml: ByteArray
)

class HtmlRequest(
    private val url: String
)

class Document(
    val url: String
) {
    val html: Html = run {
        val downloader = HtmlDownloader(NetworkTransporter())
        downloader.downloadHtml(this.url)
    }
}
