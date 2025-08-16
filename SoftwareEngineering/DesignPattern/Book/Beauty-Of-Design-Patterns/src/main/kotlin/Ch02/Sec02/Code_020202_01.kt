package Ch02.Sec02

/**
 * 2.2.2 추상화
 *
 * p.g 31
 */
class Picture

class Image

class PictureMetaInfo

// 인터페이스를 통해 외부에서 구현에 대해서 신경쓸 필요가 없어짐
// 단순히 함수 선언(시그니쳐)만을 제공하며, 이외의 정보는 감춤
interface IPictureStorage {
    fun savePicture(picture: Picture)
    fun getPicture(pictureId: String): Image
    fun delete(pictureId: String)
    fun modifyMetaInfo(pictureId: String, metaInfo: PictureMetaInfo)
}

// 외부에서는 PictureStorage가 IPictureStorage 인터페이스를 구현했다는 것만 알면, 동일하게 사용 가능
// 추상화는 다형성과도 연관이 있음
class PictureStorage: IPictureStorage {
    override fun savePicture(picture: Picture) {
        TODO("Not yet implemented")
    }

    override fun getPicture(pictureId: String): Image {
        TODO("Not yet implemented")
    }

    override fun delete(pictureId: String) {
        TODO("Not yet implemented")
    }

    override fun modifyMetaInfo(pictureId: String, metaInfo: PictureMetaInfo) {
        TODO("Not yet implemented")
    }
}

